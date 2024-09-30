package com.emazon.supply.adapters.driven.jpa.myqsl.adapter;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SaleEntity;
import com.emazon.supply.adapters.driven.jpa.myqsl.mapper.ISaleEntityMapper;
import com.emazon.supply.adapters.driven.jpa.myqsl.repository.ISaleRepository;
import com.emazon.supply.domain.model.Sale;
import com.emazon.supply.domain.model.SaleDetail;
import com.emazon.supply.domain.spi.ISalePersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleAdapter implements ISalePersistencePort {

    private final ISaleRepository saleRepository;
    private final ISaleEntityMapper saleEntityMapper;

    @Override
    public void saveSale(Sale sale) {
        SaleEntity saleEntity = saleEntityMapper.toSaleEntity(sale);
        saleEntity.setSaleDetails();
        saleRepository.save(saleEntity);
    }

}
