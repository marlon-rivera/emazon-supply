package com.emazon.supply.domain.model;

import java.math.BigInteger;
import java.time.LocalDate;

public class Supply {

    private Long id;
    private Long idArticle;
    private LocalDate deliveryDate;
    private BigInteger quantity;
    private String idResponsible;

    public Supply(Long id, Long idArticle, LocalDate deliveryDate, BigInteger quantity, String idResponsible) {
        this.id = id;
        this.idArticle = idArticle;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.idResponsible = idResponsible;
    }

    public Long getId() {
        return id;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(String idResponsible) {
        this.idResponsible = idResponsible;
    }
}
