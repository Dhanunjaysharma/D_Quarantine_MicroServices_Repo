package com.currency_caluclation.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency_caluclation.model.CurrencyCaluclationBean;

//@FeignClient(name="Currency-Exchange-Service", url = "localhost:8000")
@FeignClient(name="Currency-Exchange-Service")
@RibbonClient(name="Currency-Exchange-Service")
public interface CurrencyCaluclationFeignProxy {
	@GetMapping("getCurrencyValue/from/{from}/to/{to}")
	public CurrencyCaluclationBean getCurrencyValue(@PathVariable("from") String from,
			@PathVariable("to") String to) ;
	
}
