package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.dao.UserDaoService;
import com.rest.demo.model.DemoBean;
import com.rest.demo.model.User;

@RestController
public class DemoController {
	@Autowired
	private UserDaoService service;
	@GetMapping("/home")
	public String getHome() {
		return "Hello-World";
	}
	@GetMapping("/helloWorldBean")
	public DemoBean getBean() {
		return new DemoBean("Hello-World");
	}
	
	@GetMapping("/home/{pathVar}")
	public String pathVarDemoMeth(@PathVariable("pathVar") String s) {
		return String.format("Hello Dood %S", s);
	}
	@GetMapping("getUsers")
	public List<User> getAll(){
		return service.findAll();
	}
	@GetMapping("/getUser/{id}")
	public User getUserOne(@PathVariable("id") int id) {
		return service.findOne(id);
	}

}
