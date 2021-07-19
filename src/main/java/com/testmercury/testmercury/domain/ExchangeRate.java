package com.testmercury.testmercury.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_EXCHANGE_RATE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_exchange_rate")
    @SequenceGenerator(name = "generator_exchange_rate", sequenceName = "seq_exchange_rate", allocationSize = 1)
    @Column(name = "EXCHANGE_RATE_ID", nullable = false)
    private Long id;

    @Column(name = "BUY")
    private Double buy;

    @Column(name = "SELL")
    private Double sell;

    @Column(name = "FECHA_VALOR")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date fechaValor;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;
}
