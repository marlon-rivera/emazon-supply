package com.emazon.supply.domain.api.usecase;

import com.emazon.supply.domain.api.ISupplyServicePort;
import com.emazon.supply.domain.exceptions.SupplyQuantityNotBeZeroException;
import com.emazon.supply.domain.model.Article;
import com.emazon.supply.domain.model.Sale;
import com.emazon.supply.domain.model.SaleDetail;
import com.emazon.supply.domain.model.Supply;
import com.emazon.supply.domain.spi.IAuthenticationPort;
import com.emazon.supply.domain.spi.ISalePersistencePort;
import com.emazon.supply.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class SupplyUseCaseImpl implements ISupplyServicePort {

    private final ISupplyPersistencePort persistencePort;
    private final IAuthenticationPort authenticationPort;
    private final ISalePersistencePort salePersistencePort;

    @Override
    public void saveSupply(Supply supply) {
        String username = authenticationPort.getCurrentUsername();
        supply.setIdResponsible(username);
        supply.setDeliveryDate(LocalDate.now());
        if(supply.getQuantity().equals(BigInteger.ZERO)){
            throw new SupplyQuantityNotBeZeroException();
        }
        persistencePort.saveSupply(supply);
    }

    @Override
    public LocalDate getLastDateOfDeliveryOfArticle(Long idArticle) {
        return persistencePort.getLastDateOfDeliveryOfArticle(idArticle);
    }

    @Override
    public void saveSale(List<Article> articleList, List<BigInteger> quantities) {
        List<SaleDetail> details = new ArrayList<>();
        String email = authenticationPort.getCurrentEmail();
        for (int i = 0; i < articleList.size(); i++) {
            details.add(new SaleDetail(articleList.get(i).getId(), quantities.get(i), articleList.get(i).getPrice()));
        }
        salePersistencePort.saveSale(new Sale(email, details));
    }
}
