package com.emazon.supply.adapters.driving.http.dto.request;

import com.emazon.supply.domain.model.Article;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SaleRequest {

    @NotNull
    private List<Article> articles;
    @NotNull
    private List<BigInteger> quantities;

}
