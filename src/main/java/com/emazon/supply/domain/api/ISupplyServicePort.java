package com.emazon.supply.domain.api;

import com.emazon.supply.domain.model.Supply;

import java.time.LocalDate;

public interface ISupplyServicePort {

    void saveSupply(Supply supply);
    LocalDate getLastDateOfDeliveryOfArticle(Long idArticle);

}
