package com.testmercury.testmercury.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_BANK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @Column(name = "BANK_ID", nullable = false)
    private Long id;

}
