package com.emazon.supply.adapters.driven.jpa.myqsl.mapper;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SupplyEntity;
import com.emazon.supply.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ISupplyEntityMapper {

    @Mapping(target = "id", ignore = true)
    SupplyEntity toSupplyEntity(Supply supply);

    Supply toSupply(SupplyEntity supplyEntity);

    default Optional<Supply> toSupplyOptional(Optional<SupplyEntity> optionalSupplyEntity) {
        return optionalSupplyEntity.map(this::toSupply);
    }

}
