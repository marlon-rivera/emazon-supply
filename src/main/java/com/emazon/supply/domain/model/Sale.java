package com.emazon.supply.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Sale {

    private Long id;
    private String email;
    private LocalDateTime localDateTime;
    private BigDecimal total;
    private List<SaleDetail> details;

    public Sale(String email, List<SaleDetail> details) {
        this.email = email;
        this.details = details;
        this.localDateTime = LocalDateTime.now();
        total = BigDecimal.ZERO;
        calculateTotal();
    }

    private void calculateTotal(){
        for (SaleDetail detail : details) {
            this.total = total.add(detail.getTotalPrice());
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<SaleDetail> getDetails() {
        return details;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDetails(List<SaleDetail> details) {
        this.details = details;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
