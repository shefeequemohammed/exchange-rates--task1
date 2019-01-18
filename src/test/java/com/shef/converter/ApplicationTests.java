package com.shef.converter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testResponse() throws ClientProtocolException, IOException {
		/*// Given
		HttpUriRequest request = new HttpGet( "http://localhost:8091/api/AED/INR/10");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );*/

	}

}

