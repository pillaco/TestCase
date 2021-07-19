package com.testmercury.testmercury.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.helpers.TestHelpers;
import com.testmercury.testmercury.repository.BankRepository;
import com.testmercury.testmercury.repository.CurrencyRepository;
import com.testmercury.testmercury.repository.ExchangeRateRepository;
import com.testmercury.testmercury.service.TestMercuryService;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestMercuryController.class)
public class TestMercuryControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private TestMercuryService testMercuryService;
    @MockBean private CurrencyRepository currencyRepository;
    @MockBean private BankRepository bankRepository;
    @MockBean private ExchangeRateRepository exchangeRateRepository;

    protected static ObjectMapper om = new ObjectMapper();

    @Before
    public void setup() {
        ObjectMapper om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        JacksonTester.initFields(this, om);
    }

    @Test
    public void getExchangeRateOk() throws Exception {



        when(testMercuryService.getExchangeRate(1L,"2021-07-19"))
                .thenReturn(TestHelpers.createHelperERate());

        mockMvc
                .perform(get("/api/v1/exchange-rates").param("id", String.valueOf(1L)).param("date", "2021-07-19"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    public void saveExchangeRateOk() throws Exception {


        ExchangeRate exchangeRate = TestHelpers.createHelperERatePost();
        ExchangeRateIdDTO exchangeRateId = TestHelpers.createHelperERateDTO();

        when(testMercuryService.addExchangeRate(exchangeRate)).thenReturn(exchangeRateId);

        mockMvc
                .perform(post("/api/v1/exchange-rates")
                        .content(om.writeValueAsBytes(exchangeRate))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isCreated());

    }



}