package com.testmercury.testmercury.service;

import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.presentation.ExchangeRateIdDTO;

import java.text.ParseException;

public interface TestMercuryService {

    public ExchangeRate getExchangeRate(Long id, String date) throws ParseException;

    public ExchangeRateIdDTO addExchangeRate(ExchangeRate exchangeRate);

}
