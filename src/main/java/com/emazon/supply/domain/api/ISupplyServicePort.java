package com.emazon.supply.domain.api;

import com.emazon.supply.domain.model.Article;
import com.emazon.supply.domain.model.Supply;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface ISupplyServicePort {

    void saveSupply(Supply supply);
    LocalDate getLastDateOfDeliveryOfArticle(Long idArticle);
    void saveSale(List<Article> articleList, List<BigInteger> quantities);
}
