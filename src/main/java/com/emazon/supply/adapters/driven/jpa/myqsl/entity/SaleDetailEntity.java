package com.emazon.supply.adapters.driven.jpa.myqsl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity(name = "sale_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long idArticle;
    @Column(nullable = false)
    private BigInteger quantity;
    @Column(nullable = false)
    private BigDecimal unitPrice;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private SaleEntity sale;

}
