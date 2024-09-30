package com.emazon.supply.domain.spi;

import com.emazon.supply.domain.model.Sale;

public interface ISalePersistencePort {

    void saveSale(Sale sale);

}
