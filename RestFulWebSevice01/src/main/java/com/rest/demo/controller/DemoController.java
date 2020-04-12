package com.rest.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.demo.dao.UserDaoService;
import com.rest.demo.exception.UserNotFoundException;
import com.rest.demo.model.DemoBean;
import com.rest.demo.model.User;

@RestController
public class DemoController {
	@Autowired
	private UserDaoService service;
	@Autowired
	ResourceBundleMessageSource messagesource;
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
		 User user=service.findOne(id);
		 if(user==null) {
			 throw new UserNotFoundException(id+" id not found for the request");
		 }
		 return user;
	}
	@PostMapping("/addUser")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		System.out.println("entered into addUser method...");
		User savedUser=service.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(savedUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/deleteUser/{id}")
	public User deleteUser(@PathVariable("id") int id) {
		 User user=service.deleteByid(id);
		 if(user==null) {
			 throw new UserNotFoundException(id+" id not found for the request");
		 }
		 return user;
	}
	@GetMapping("/geti18nmessage")
	public String i18nDemoMeth(@RequestHeader(name="Accept-language") Locale locale) {
		System.out.println(".............."+messagesource.getMessage("good.morning.message",null, locale));
		
		return messagesource.getMessage("good.morning.message",null, locale);
	}
	
	@GetMapping("/geti18nmessageWithoutHeaderInput")
	public String i18nDemoMeth() {
		System.out.println(".............."+messagesource.getMessage("good.morning.message",null,  LocaleContextHolder.getLocale()));
		
		return messagesource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
}
