package com.emazon.supply.adapters.driven.jpa.myqsl.adapter;

import com.emazon.supply.adapters.driven.feign.IStockFeignClient;
import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SupplyEntity;
import com.emazon.supply.adapters.driven.jpa.myqsl.mapper.ISupplyEntityMapper;
import com.emazon.supply.adapters.driven.jpa.myqsl.repository.ISupplyRepository;
import com.emazon.supply.domain.model.Supply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class SupplyAdapterTest {

    @Mock
    private IStockFeignClient stockFeignClient;

    @Mock
    private ISupplyRepository supplyRepository;

    @Mock
    private ISupplyEntityMapper supplyEntityMapper;

    @InjectMocks
    private SupplyAdapter supplyAdapter;

    private Supply supply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        supply = new Supply(1L, 1L, LocalDate.now(), BigInteger.TEN, "123");

    }

    @Test
    void saveSupply_shouldIncreaseStockAndSaveSupply() {
        SupplyEntity supplyEntity = new SupplyEntity(1L, 1L, LocalDate.now(), BigInteger.TEN, "123");
        when(supplyEntityMapper.toSupplyEntity(supply)).thenReturn(supplyEntity);

        supplyAdapter.saveSupply(supply);

        verify(stockFeignClient).increaseStock(supply.getIdArticle(), supply.getQuantity());
        verify(supplyRepository).save(any());
    }

    @Test
    void getLastDateOfDeliveryOfArticle_ShouldReturnDate_WhenArticleExists() {
        Long idArticle = 1L;
        LocalDate expectedDate = LocalDate.of(2024, 9, 15);

        when(supplyRepository.findLastDeliveryDateByArticleId(idArticle)).thenReturn(Optional.of(expectedDate));

        LocalDate actualDate = supplyAdapter.getLastDateOfDeliveryOfArticle(idArticle);

        assertEquals(expectedDate, actualDate);
    }

    @Test
    void getLastDateOfDeliveryOfArticle_ShouldReturnNull_WhenArticleDoesNotExist() {
        Long idArticle = 999L;

        when(supplyRepository.findLastDeliveryDateByArticleId(idArticle)).thenReturn(Optional.empty());

        LocalDate actualDate = supplyAdapter.getLastDateOfDeliveryOfArticle(idArticle);

        assertNull(actualDate);
    }
}