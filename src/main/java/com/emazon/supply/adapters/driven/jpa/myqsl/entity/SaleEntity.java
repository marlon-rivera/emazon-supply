package com.emazon.supply.adapters.driven.jpa.myqsl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private LocalDateTime localDateTime;
    @Column(nullable = false)
    private BigDecimal total;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleDetailEntity> details;

    public void setSaleDetails(){
        for(SaleDetailEntity detail : details){
            detail.setSale(this);
        }
    }

}
