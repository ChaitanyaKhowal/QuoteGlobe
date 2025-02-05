package com.khowal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khowal.binding.Quote;
import com.khowal.service.QuoteService;

@Controller
public class QuoteController {

	private QuoteService quoteService;

	public QuoteController(QuoteService quoteService) {
		super();
		this.quoteService = quoteService;
	}

	@GetMapping("/quotes")
	public String showQuotes(Model model) {
		List<Quote> allQuotes = quoteService.getAllQuotes();
		model.addAttribute("quotes", allQuotes);
		return "quotes";
	}

}
