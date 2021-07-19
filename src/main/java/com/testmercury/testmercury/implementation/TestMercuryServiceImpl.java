package com.testmercury.testmercury.implementation;

import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.presentation.ExchangeRateIdDTO;
import com.testmercury.testmercury.repository.BankRepository;
import com.testmercury.testmercury.repository.CurrencyRepository;
import com.testmercury.testmercury.repository.ExchangeRateRepository;
import com.testmercury.testmercury.service.TestMercuryService;
import com.testmercury.testmercury.utils.DateUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Log4j2
public class TestMercuryServiceImpl implements TestMercuryService {

    private ExchangeRateRepository exchangeRateRepository;
    private CurrencyRepository currencyRepository;
    private BankRepository bankRepository;

    public TestMercuryServiceImpl(ExchangeRateRepository exchangeRateRepository, CurrencyRepository currencyRepository, BankRepository bankRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.currencyRepository = currencyRepository;
        this.bankRepository = bankRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public ExchangeRate getExchangeRate(Long id, String date) throws ParseException {
        log.info("entering getExchangeRate method");

        if(DateUtils.stringToDate(date).after(new Date())){
            throw new IllegalArgumentException("You are passing a future date to the request");
        }

        List<ExchangeRate> er = exchangeRateRepository.obtainRatesByIdAndDate(id, date);

        if (er.isEmpty()) {

            Date dateFromString = DateUtils.stringToDate(date);
            Date nearestDate = DateUtils.getNearestDate(exchangeRateRepository.obtainDates(), dateFromString);

            if (null == nearestDate) {

                throw new NoSuchElementException("No records found with the provided information");
            }


            er = exchangeRateRepository.obtainRatesByDate(DateUtils.dateToStringFormatted(nearestDate));

            return er.get(0);
        }

        return er.get(0);
    }

    @Override
    @Transactional
    public ExchangeRateIdDTO addExchangeRate(ExchangeRate exchangeRate) {

        exchangeRateRepository.saveAndFlush(exchangeRate);

        ExchangeRateIdDTO exchangeRateIdDTO = new ExchangeRateIdDTO();

        exchangeRateIdDTO.setId(exchangeRate.getId());
        exchangeRateIdDTO.setDescription("Saved into database.");
        exchangeRateIdDTO.setStatus("Success");

        return exchangeRateIdDTO;
        }

    }
