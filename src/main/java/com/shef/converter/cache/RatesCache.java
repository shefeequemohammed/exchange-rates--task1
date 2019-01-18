package com.shef.converter.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class RatesCache {

	@Value("${cache.expiry}")
	private int CACHE_DURATION;

	private Cache<String, Double> cache;

	@PostConstruct
	public void init() {
		if (cache == null) {					
			cache = CacheBuilder.newBuilder().expireAfterWrite(CACHE_DURATION, TimeUnit.MINUTES).build();
		}
	}

	public Double getCachedRate(String code) {
		return cache.getIfPresent(code);
	}

	public void addRateToCache(String code, Double rate) {
		cache.put(code, rate);
	}
}
