package com.example.currecyexchange.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.currecyexchange.Bean.CurrencyExchange;
import com.example.currecyexchange.dao.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchange.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to){
		
		logger.info("retriveveExchangeValue called with {} to {} ", from, to);
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		
		
		if(currencyExchange == null ) {
			throw new RuntimeException("Unable to find data for " + from + " to "+ to);	
		}
		
		
		//Kubernatees
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		String version = "v1.0";
		
		
		
		currencyExchange.setEnvironnement(port + " " + version + " " + host);
		
		return currencyExchange;
	}
}
