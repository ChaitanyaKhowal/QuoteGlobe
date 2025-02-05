package com.khowal.dto;

import java.util.List;

import com.khowal.binding.Quote;

import lombok.Data;

@Data
public class QuoteResponse {

	private List<Quote> quotes;

}
