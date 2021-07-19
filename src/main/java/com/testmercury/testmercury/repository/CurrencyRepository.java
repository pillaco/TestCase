package com.testmercury.testmercury.repository;

import com.testmercury.testmercury.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
