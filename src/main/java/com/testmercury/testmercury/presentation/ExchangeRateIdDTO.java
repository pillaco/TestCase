package com.testmercury.testmercury.presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExchangeRateIdDTO {

    private String status;
    private String description;
    private Long id;
}
