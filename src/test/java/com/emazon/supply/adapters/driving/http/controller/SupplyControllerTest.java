package com.emazon.supply.adapters.driving.http.controller;

import com.emazon.supply.adapters.driving.http.dto.request.SupplyRequest;
import com.emazon.supply.adapters.driving.http.mapper.request.ISupplyRequestMapper;
import com.emazon.supply.configuration.jwt.JWTAuthFilter;
import com.emazon.supply.configuration.jwt.JwtService;
import com.emazon.supply.domain.api.ISupplyServicePort;
import com.emazon.supply.domain.model.Supply;
import com.emazon.supply.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplyController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
class SupplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISupplyServicePort supplyService;

    @MockBean
    private ISupplyRequestMapper supplyRequestMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JWTAuthFilter jwtAuthFilter;

    @InjectMocks
    private JwtService jwtService;

    private SupplyRequest supplyRequest;
    private Supply supply;

    @BeforeEach
    void setUp() {
        supplyRequest = new SupplyRequest(1L, BigInteger.TEN);

        supply = new Supply(1L, 1L, LocalDate.now(), BigInteger.TEN, "123");
    }

    @Test
    void addSupply_shouldReturnOkWhenValidRequest() throws Exception {
        when(supplyRequestMapper.toSupply(supplyRequest)).thenReturn(supply);

        mockMvc.perform(post("/supply/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(supplyRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void addSupply_shouldReturnBadRequestWhenInvalidRequest() throws Exception {
        mockMvc.perform(post("/supply/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getLastDeliveryDate_ShouldReturnOk_WhenArticleExists() throws Exception {
        Long idArticle = 1L;
        LocalDate lastDeliveryDate = LocalDate.of(2024, 9, 15);

        when(supplyService.getLastDateOfDeliveryOfArticle(idArticle)).thenReturn(lastDeliveryDate);

        mockMvc.perform(get("/supply/last-delivery-date/{idArticle}", idArticle))
                .andExpect(status().isOk())
                .andExpect(content().json("\"2024-09-15\""));

        verify(supplyService).getLastDateOfDeliveryOfArticle(idArticle);
    }

    @Test
    void getLastDeliveryDate_ShouldReturnNotFound_WhenArticleDoesNotExist() throws Exception {
        Long idArticle = 999L;

        when(supplyService.getLastDateOfDeliveryOfArticle(idArticle)).thenThrow(new RuntimeException(Constants.EXCEPTION_SUPPLY_ARTICLE_NOT_FOUND));

        mockMvc.perform(get("/shopping-cart/last-delivery-date/{idArticle}", idArticle))
                .andExpect(status().isNotFound());

        verify(supplyService).getLastDateOfDeliveryOfArticle(idArticle);
    }
}
