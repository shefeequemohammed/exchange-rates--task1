package com.shef.converter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shef.converter.cache.RatesCache;
import com.shef.converter.entity.ExchangeRate;
import com.shef.converter.entity.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;


@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatesCache ratesCache;

    @GetMapping("/api/{source}/{target}/{srcAmt}")
    public String currencyConverter(@PathVariable("source") String sourceCurrency,
                                    @PathVariable("target") String targetCurrency,
                                    @PathVariable("srcAmt") Double srcAmt) throws IOException, JSONException{

        //Check whether the rates present in cache or not
        String cacheKey = sourceCurrency+"_"+targetCurrency;
        Double cachedRate = ratesCache.getCachedRate(cacheKey);
        ResponseModel responseModel = null;
        ObjectMapper mapper = null;
        if(cachedRate!=null){
            responseModel = new ResponseModel();
            responseModel.setFromCurrency(sourceCurrency);
            responseModel.setToCurrency(targetCurrency);
            responseModel.setFromAmount(srcAmt);
            responseModel.setToAmount(srcAmt*cachedRate);
            responseModel.setExchangeRate(cachedRate);
        }else { 

            String url = "https://free.currencyconverterapi.com/api/v6/convert?q=" + sourceCurrency + "_" + targetCurrency + "&compact=y";
            //store the JSON as string
            JSONObject json = readJsonFromUrl(url, sourceCurrency, targetCurrency);
            String js = json.toString();
            //map JSON to Class
            mapper = new ObjectMapper();
            ExchangeRate exchangeRate = mapper.readValue(js, ExchangeRate.class);

            //set the response model
            responseModel = new ResponseModel();
            responseModel.setFromCurrency(sourceCurrency);
            responseModel.setToCurrency(targetCurrency);
            responseModel.setFromAmount(srcAmt);
            responseModel.setToAmount(srcAmt * exchangeRate.getSourceTarget().getVal());
            responseModel.setExchangeRate(exchangeRate.getSourceTarget().getVal());
            //Add the rates to the cache.
            ratesCache.addRateToCache(cacheKey,exchangeRate.getSourceTarget().getVal());

        }
        //convert ResponseModel to JSON
        mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(responseModel);
        return jsonInString;

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url,
                                             String sourceCurrency,
                                             String targetCurrency) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        String replaceString = sourceCurrency+"_"+targetCurrency;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            jsonText = jsonText.replace(replaceString,"SRC_TGT");
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}

