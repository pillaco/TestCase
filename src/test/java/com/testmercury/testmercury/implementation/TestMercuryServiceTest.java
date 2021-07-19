package com.testmercury.testmercury.implementation;

import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.helpers.TestHelpers;
import com.testmercury.testmercury.presentation.ExchangeRateIdDTO;
import com.testmercury.testmercury.repository.BankRepository;
import com.testmercury.testmercury.repository.CurrencyRepository;
import com.testmercury.testmercury.repository.ExchangeRateRepository;
import com.testmercury.testmercury.service.TestMercuryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TestMercuryServiceTest {

    @MockBean
    private TestMercuryService testMercuryService;

    @MockBean private CurrencyRepository currencyRepository;
    @MockBean private BankRepository bankRepository;
    @MockBean private ExchangeRateRepository exchangeRateRepository;

    @Before
    public void setUp(){
        testMercuryService = new TestMercuryServiceImpl(exchangeRateRepository, currencyRepository, bankRepository);
    }

    @Test
    public void getExchangeRateOk() throws ParseException {

        when(exchangeRateRepository.obtainRatesByIdAndDate(TestHelpers.createHelperERate().getId(), "2021-07-19"))
                .thenReturn(List.of(TestHelpers.createHelperERate()));

        ExchangeRate ex = testMercuryService.getExchangeRate(TestHelpers.createHelperERate().getId(), "2021-07-19");

        assertThat(TestHelpers.createHelperERate().getId()).isEqualTo(ex.getId());

    }

    @Test
    public void addExchangeRateOk() {

        when(exchangeRateRepository.saveAndFlush(TestHelpers.createHelperERatePost())).thenReturn(TestHelpers.createHelperERate());

        ExchangeRateIdDTO ex = testMercuryService.addExchangeRate(TestHelpers.createHelperERate());

        assertThat(ex.getId()).isEqualTo(TestHelpers.createHelperERate().getId());

    }
}