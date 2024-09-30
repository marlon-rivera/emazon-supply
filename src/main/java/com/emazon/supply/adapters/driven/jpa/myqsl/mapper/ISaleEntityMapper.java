package com.emazon.supply.adapters.driven.jpa.myqsl.mapper;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SaleEntity;
import com.emazon.supply.domain.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ISaleEntityMapper {

    @Mapping(target = "id", ignore = true)
    SaleEntity toSaleEntity(Sale sale);

    Sale toSale(SaleEntity saleEntity);

    default Optional<Sale> toSupplyOptional(Optional<SaleEntity> optionalSaleEntity) {
        return optionalSaleEntity.map(this::toSale);
    }

}
