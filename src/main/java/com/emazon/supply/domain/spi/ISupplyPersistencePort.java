package com.emazon.supply.domain.spi;

import com.emazon.supply.domain.model.Supply;

public interface ISupplyPersistencePort {

    void saveSupply(Supply supply);

}
