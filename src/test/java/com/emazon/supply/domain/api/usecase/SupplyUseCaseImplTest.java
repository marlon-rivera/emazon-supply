package com.emazon.supply.domain.api.usecase;

import com.emazon.supply.domain.exceptions.SupplyQuantityNotBeZeroException;
import com.emazon.supply.domain.model.Supply;
import com.emazon.supply.domain.spi.IAuthenticationPort;
import com.emazon.supply.domain.spi.ISupplyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.cglib.core.Local;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SupplyUseCaseImplTest {

    @Mock
    private ISupplyPersistencePort persistencePort;

    @Mock
    private IAuthenticationPort authenticationPort;

    @InjectMocks
    private SupplyUseCaseImpl supplyUseCase;

    private Supply supply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        supply = new Supply(1L, 1L, LocalDate.now(), BigInteger.TEN, "123");
    }

    @Test
    void saveSupply_shouldSetIdResponsibleAndSaveSupply() {
        String username = "123";
        when(authenticationPort.getCurrentUsername()).thenReturn(username);

        supplyUseCase.saveSupply(supply);

        verify(authenticationPort).getCurrentUsername();
        verify(persistencePort).saveSupply(supply);
        assert (supply.getIdResponsible().equals(username));
    }

    @Test
    void saveSupply_shouldThrowExceptionWhenQuantityIsZero() {
        supply.setQuantity(BigInteger.ZERO);

        assertThrows(SupplyQuantityNotBeZeroException.class, () -> supplyUseCase.saveSupply(supply));

        verify(persistencePort, never()).saveSupply(any());
    }
}
