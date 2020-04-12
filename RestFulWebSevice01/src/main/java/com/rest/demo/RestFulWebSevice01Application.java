package com.rest.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestFulWebSevice01Application {

	public static void main(String[] args) {
		SpringApplication.run(RestFulWebSevice01Application.class, args);
	}
	/*
	 * @Bean public LocaleResolver getLocaleResolver() { SessionLocaleResolver
	 * resolver=new SessionLocaleResolver(); resolver.setDefaultLocale(Locale.US);
	 * return resolver; }
	 */
	
	@Bean
	public LocaleResolver getLocaleResolver() {
		AcceptHeaderLocaleResolver resolver=new AcceptHeaderLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
	}
	/*
	 * @Bean public ResourceBundleMessageSource source() {
	 * ResourceBundleMessageSource source=new ResourceBundleMessageSource();
	 * source.setBasename("message"); return source; }
	 */

}
