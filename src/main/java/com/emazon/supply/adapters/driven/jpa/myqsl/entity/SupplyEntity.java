package com.emazon.supply.adapters.driven.jpa.myqsl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Entity(name = "supplies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idArticle;
    @Column(nullable = false)
    private LocalDate deliveryDate;
    @Column(nullable = false)
    private BigInteger quantity;
    @Column(nullable = false)
    private String idResponsible;

}
