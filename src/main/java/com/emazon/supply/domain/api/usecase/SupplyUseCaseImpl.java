package com.emazon.supply.domain.api.usecase;

import com.emazon.supply.domain.api.ISupplyServicePort;
import com.emazon.supply.domain.exceptions.SupplyQuantityNotBeZeroException;
import com.emazon.supply.domain.model.Supply;
import com.emazon.supply.domain.spi.IAuthenticationPort;
import com.emazon.supply.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDate;

@RequiredArgsConstructor
public class SupplyUseCaseImpl implements ISupplyServicePort {

    private final ISupplyPersistencePort persistencePort;
    private final IAuthenticationPort authenticationPort;

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
}
