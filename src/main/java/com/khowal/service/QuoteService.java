package com.khowal.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.khowal.binding.Quote;
import com.khowal.dto.QuoteResponse;

@Service
public class QuoteService {

	public List<Quote> getAllQuotes() {

		String apiUrl = "https://dummyjson.com/quotes";
		RestTemplate rt = new RestTemplate();

		try {
			ResponseEntity<QuoteResponse> response = rt.getForEntity(apiUrl, QuoteResponse.class);

			if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
				return response.getBody().getQuotes();
			} else {
				System.out.println("Failed to fetch quotes: HTTP Status " + response.getStatusCode());
				return Collections.emptyList();
			}
		} catch (HttpStatusCodeException e) {
			System.out.println("HTTP Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
		} catch (Exception e) {
			System.out.println("Error fetching quotes: " + e.getMessage());
		}

		return Collections.emptyList();
	}

}
