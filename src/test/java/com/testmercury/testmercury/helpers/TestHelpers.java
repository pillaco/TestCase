package com.testmercury.testmercury.helpers;

import com.testmercury.testmercury.domain.Bank;
import com.testmercury.testmercury.domain.Currency;
import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.presentation.ExchangeRateIdDTO;

import java.util.Date;

public class TestHelpers {


    public static ExchangeRate createHelperERate(){

        ExchangeRate exchangeRate = new ExchangeRate();
        Bank bank = new Bank();
        bank.setId(1L);
        Currency currency = new Currency();
        currency.setId(1L);
        exchangeRate.setBank(bank);
        exchangeRate.setCurrency(currency);
        exchangeRate.setId(1L);
        exchangeRate.setBuy(1.0);
        exchangeRate.setSell(1.0);
        exchangeRate.setFechaValor(new Date());

        return exchangeRate;


    }



    public static ExchangeRate createHelperERatePost(){

        ExchangeRate exchangeRate = new ExchangeRate();
        Bank bank = new Bank();
        bank.setId(1L);
        Currency currency = new Currency();
        currency.setId(1L);
        exchangeRate.setBank(bank);
        exchangeRate.setCurrency(currency);
        exchangeRate.setBuy(1.0);
        exchangeRate.setSell(1.0);
        exchangeRate.setFechaValor(new Date());

        return exchangeRate;


    }


    public static ExchangeRateIdDTO createHelperERateDTO(){

        ExchangeRateIdDTO exchangeRate = new ExchangeRateIdDTO();
        exchangeRate.setStatus("Success");
        exchangeRate.setDescription("Saved into database");
        exchangeRate.setId(1L);

        return exchangeRate;


    }

}
