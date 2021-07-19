package com.testmercury.testmercury.repository;

import com.testmercury.testmercury.domain.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    @Query(value = "SELECT * FROM TB_EXCHANGE_RATE e WHERE e.EXCHANGE_RATE_ID = :id AND TO_CHAR(e.FECHA_VALOR, 'YYYY-MM-DD') = :date",
    nativeQuery = true)
    List<ExchangeRate> obtainRatesByIdAndDate(Long id, String date);

    @Query(value = "SELECT FECHA_VALOR FROM TB_EXCHANGE_RATE",
            nativeQuery = true)
    List<Date> obtainDates();

    @Query(value = "SELECT * FROM TB_EXCHANGE_RATE e WHERE TO_CHAR(e.FECHA_VALOR, 'YYYY-MM-DD') = :date", nativeQuery = true)
    List<ExchangeRate> obtainRatesByDate(String date);
}
