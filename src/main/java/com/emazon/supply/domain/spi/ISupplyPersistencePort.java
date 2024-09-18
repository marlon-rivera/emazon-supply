package com.emazon.supply.domain.spi;

import com.emazon.supply.domain.model.Supply;

import java.time.LocalDate;

public interface ISupplyPersistencePort {

    void saveSupply(Supply supply);
    LocalDate getLastDateOfDeliveryOfArticle(Long idArticle);

}
