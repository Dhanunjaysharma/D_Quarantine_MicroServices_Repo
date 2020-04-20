package com.currency_caluclation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.currency_caluclation.model.CurrencyCaluclationBean;
import com.currency_caluclation.service.CurrencyCaluclationFeignProxy;
@RestController
public class CurrencyCaluclationController {
	@Autowired
	CurrencyCaluclationFeignProxy proxy;
	@GetMapping("/getCaluclatedValue/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCaluclationBean getCaluclatedValue(@PathVariable("from")String from,
			@PathVariable("to")String to,@PathVariable("quantity")BigDecimal quantity) {
		Map<String,String> map=new HashMap<>();
		map.put("from",	 from);
		map.put("to", to);
		ResponseEntity<CurrencyCaluclationBean> entity=new RestTemplate().getForEntity("http://localhost:8000/getCurrencyValue/from/{from}/to/{to}", CurrencyCaluclationBean.class,map); 
		CurrencyCaluclationBean currencyCaluclationBean=entity.getBody();
		return new CurrencyCaluclationBean(currencyCaluclationBean.getId(), 
				currencyCaluclationBean.getFrom(), currencyCaluclationBean.getTo(), Integer.parseInt(String.valueOf(quantity)), 
				currencyCaluclationBean.getValue(), currencyCaluclationBean.getValue().multiply(quantity),currencyCaluclationBean.getPort());
	}
	
	@GetMapping("/getCaluclatedValueFeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyCaluclationBean getFeignCaluclatedValue(@PathVariable("from")String from,
	@PathVariable("to")String to,@PathVariable("quantity")BigDecimal quantity){
		
		CurrencyCaluclationBean currencyCaluclationBean=proxy.getCurrencyValue(from, to);
		return new CurrencyCaluclationBean(currencyCaluclationBean.getId(), 
				currencyCaluclationBean.getFrom(), currencyCaluclationBean.getTo(), Integer.parseInt(String.valueOf(quantity)), 
				currencyCaluclationBean.getValue(), currencyCaluclationBean.getValue().multiply(quantity),currencyCaluclationBean.getPort());

	}

}
