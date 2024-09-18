package com.emazon.supply.adapters.driving.http.mapper.request;

import com.emazon.supply.adapters.driving.http.dto.request.SupplyRequest;
import com.emazon.supply.domain.model.Supply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ISupplyRequestMapper {

    @Mapping(target = "deliveryDate", ignore = true)
    Supply toSupply(SupplyRequest supplyRequest);

}
