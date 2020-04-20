package com.currency_caluclation.model;

import java.math.BigDecimal;

public class CurrencyCaluclationBean {
	private int id;
	private String from;
	private String to;
	private int quantity;
	private BigDecimal value;
	private BigDecimal caluclatedValue;
	private int port;
	public CurrencyCaluclationBean(int id, String from, String to, int quantity, BigDecimal value,
			BigDecimal caluclatedValue,int port) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.value = value;
		this.caluclatedValue = caluclatedValue;
		this.port=port;
	}
	public CurrencyCaluclationBean() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public BigDecimal getCaluclatedValue() {
		return caluclatedValue;
	}
	public void setCaluclatedValue(BigDecimal caluclatedValue) {
		this.caluclatedValue = caluclatedValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
}
