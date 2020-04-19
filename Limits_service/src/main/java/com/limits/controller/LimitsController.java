package com.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limits.model.LimitsBean;
@RestController
public class LimitsController {
	@Autowired
	LimitsBean bean;
	@GetMapping("/getLimits")
	public LimitsBean getLimits() {
		return bean;
	}

}
