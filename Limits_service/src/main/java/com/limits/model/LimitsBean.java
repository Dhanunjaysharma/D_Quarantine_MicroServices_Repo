package com.limits.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class LimitsBean {
	
	private int minimum;
	private int maximium;
	
	protected LimitsBean() {
		
	}
	
	public LimitsBean(int minimum, int maximium) {
		this.minimum = minimum;
		this.maximium = maximium;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximium() {
		return maximium;
	}
	public void setMaximium(int maximium) {
		this.maximium = maximium;
	}
	

}
