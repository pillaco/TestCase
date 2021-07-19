package com.testmercury.testmercury.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_CURRENCY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    @Column(name = "CURRENCY_ID", nullable = false)
    private Long id;
}
