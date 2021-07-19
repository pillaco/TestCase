package com.testmercury.testmercury.repository;

import com.testmercury.testmercury.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
