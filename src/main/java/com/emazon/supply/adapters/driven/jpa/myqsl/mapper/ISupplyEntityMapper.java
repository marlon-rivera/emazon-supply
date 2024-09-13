package com.emazon.supply.adapters.driven.jpa.myqsl.mapper;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SupplyEntity;
import com.emazon.supply.domain.model.Supply;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ISupplyEntityMapper {

    SupplyEntity toSupplyEntity(Supply supply);

    Supply toSupply(SupplyEntity supplyEntity);

    default Optional<Supply> toSupplyOptional(Optional<SupplyEntity> optionalSupplyEntity) {
        return optionalSupplyEntity.map(this::toSupply);
    }

}
