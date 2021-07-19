package com.testmercury.testmercury.presentation;

import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.service.TestMercuryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/exchange-rates")
public class TestMercuryController {

    private TestMercuryService testMercuryService;

    public TestMercuryController(TestMercuryService testMercuryService) {
        this.testMercuryService = testMercuryService;
    }

    @GetMapping
    public ResponseEntity<ExchangeRate> getExchangeRate(@RequestParam(value = "id") Long id, @RequestParam(value = "date") String date) throws ParseException {
        return new ResponseEntity<>(testMercuryService.getExchangeRate(id, date), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExchangeRateIdDTO> saveExchangeRate(@RequestBody ExchangeRate exchangeRate) {

        testMercuryService.addExchangeRate(exchangeRate);

       return new ResponseEntity<>(testMercuryService.addExchangeRate(exchangeRate), HttpStatus.CREATED);

    }
}