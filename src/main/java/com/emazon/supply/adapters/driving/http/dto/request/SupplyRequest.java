package com.emazon.supply.adapters.driving.http.dto.request;

import com.emazon.supply.utils.Constants;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplyRequest {

    @NotNull(message = Constants.EXCEPTION_SUPPLY_ID_ARTICLE_BLANK)
    private Long idArticle;
    @NotNull(message = Constants.EXCEPTION_SUPPLY_DELIVERY_DATE_BLANK)
    private LocalDate deliveryDate;
    @NotNull(message = Constants.EXCEPTION_SUPPLY_QUANTITY_BLANK)
    private BigInteger quantity;
}
