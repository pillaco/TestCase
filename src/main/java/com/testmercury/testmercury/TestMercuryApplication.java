package com.testmercury.testmercury;

import com.testmercury.testmercury.domain.Bank;
import com.testmercury.testmercury.domain.Currency;
import com.testmercury.testmercury.domain.ExchangeRate;
import com.testmercury.testmercury.repository.BankRepository;
import com.testmercury.testmercury.repository.CurrencyRepository;
import com.testmercury.testmercury.repository.ExchangeRateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TestMercuryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestMercuryApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoData(CurrencyRepository currencyRepository, BankRepository bankRepository, ExchangeRateRepository exchangeRateRepository) {
		return args -> {
			Currency currency = new Currency(281L);
			Currency currency1 = new Currency(308L);
			Currency currency2 = new Currency(316L);

			currencyRepository.saveAll(List.of(currency, currency1, currency2));

			Bank bank = new Bank(42L);

			bankRepository.save(bank);

			ExchangeRate exchangeRate = new ExchangeRate(1L, 1.0, 1.0, new Date(), bank, currency1);
			ExchangeRate exchangeRate1 = new ExchangeRate(2L, 1.1745, 1.1734, new Date(), bank, currency2);
			ExchangeRate exchangeRate2 = new ExchangeRate(3L, 133.28, 133.27, new Date(), bank, currency);

			exchangeRateRepository.saveAll(List.of(exchangeRate, exchangeRate1, exchangeRate2));
		};

	}
}