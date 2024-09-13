package com.emazon.supply.configuration;

import com.emazon.supply.adapters.driven.authentication.AuthenticationAdapter;
import com.emazon.supply.adapters.driven.feign.IStockFeignClient;
import com.emazon.supply.adapters.driven.jpa.myqsl.adapter.SupplyAdapter;
import com.emazon.supply.adapters.driven.jpa.myqsl.mapper.ISupplyEntityMapper;
import com.emazon.supply.adapters.driven.jpa.myqsl.repository.ISupplyRepository;
import com.emazon.supply.domain.api.ISupplyServicePort;
import com.emazon.supply.domain.api.usecase.SupplyUseCaseImpl;
import com.emazon.supply.domain.spi.IAuthenticationPort;
import com.emazon.supply.domain.spi.ISupplyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ISupplyRepository supplyRepository;
    private final ISupplyEntityMapper supplyEntityMapper;
    private final IStockFeignClient stockFeignClient;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(stockFeignClient, supplyRepository, supplyEntityMapper);
    }

    @Bean
    public IAuthenticationPort authenticationPort() {
        return new AuthenticationAdapter();
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCaseImpl(supplyPersistencePort(), authenticationPort());
    }

}
