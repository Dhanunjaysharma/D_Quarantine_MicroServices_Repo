package com.currency_exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency_exchange.model.CurrencyExchangeBean;
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeBean, Integer>{

	CurrencyExchangeBean findByFromAndTo(String from,String to);
}
