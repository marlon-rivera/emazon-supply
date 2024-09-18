package com.emazon.supply.adapters.driven.jpa.myqsl.adapter;

import com.emazon.supply.adapters.driven.feign.IStockFeignClient;
import com.emazon.supply.adapters.driven.jpa.myqsl.mapper.ISupplyEntityMapper;
import com.emazon.supply.adapters.driven.jpa.myqsl.repository.ISupplyRepository;
import com.emazon.supply.domain.model.Supply;
import com.emazon.supply.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {

    private final IStockFeignClient stockFeignClient;
    private final ISupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;

    @Override
    public void saveSupply(Supply supply) {
        stockFeignClient.increaseStock(supply.getIdArticle(), supply.getQuantity());
        supplyRepository.save(supplyEntityMapper.toSupplyEntity(supply));
    }

    @Override
    public LocalDate getLastDateOfDeliveryOfArticle(Long idArticle) {
        Optional<LocalDate> localDateOptional = supplyRepository.findLastDeliveryDateByArticleId(idArticle);
        return localDateOptional.orElse(null);
    }
}
