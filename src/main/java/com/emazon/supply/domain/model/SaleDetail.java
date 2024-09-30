package com.emazon.supply.domain.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SaleDetail {

    private Long id;
    private Long idArticle;
    private BigInteger quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    public SaleDetail(Long idArticle, BigInteger quantity, BigDecimal unitPrice) {
        this.idArticle = idArticle;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity.doubleValue()));
    }

    public Long getId() {
        return id;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
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

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
