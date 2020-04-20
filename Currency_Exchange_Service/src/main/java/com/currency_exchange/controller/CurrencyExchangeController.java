package com.currency_exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency_exchange.dao.CurrencyExchangeRepository;
import com.currency_exchange.model.CurrencyExchangeBean;
@RestController
public class CurrencyExchangeController {
	@Autowired
	private CurrencyExchangeRepository repo;
	@Autowired
	private Environment env;
	@GetMapping("getCurrencyValue/from/{from}/to/{to}")
	public CurrencyExchangeBean getCurrencyValue(@PathVariable("from") String from,@PathVariable("to") String to) {
		System.out.println("------------>>>"+from+"\n--------->"+to);
		CurrencyExchangeBean currencyExchangeBean=repo.findByFromAndTo(from, to);
		System.out.println("------------>>>"+currencyExchangeBean);
		currencyExchangeBean.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return currencyExchangeBean;
	}
}
