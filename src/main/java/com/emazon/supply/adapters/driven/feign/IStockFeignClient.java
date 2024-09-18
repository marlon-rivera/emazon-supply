package com.emazon.supply.adapters.driven.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;

@FeignClient(name = "emazon-stock", url = "http://localhost:8082/article")
public interface IStockFeignClient {

    @PutMapping("/increase/{id}")
    void increaseStock(@PathVariable("id") Long id, @RequestBody BigInteger quantity);

}
