package com.emazon.supply.adapters.driving.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyController {

    @PostMapping("/")
    public ResponseEntity<String> addSupply(){
        return ResponseEntity.ok("Soy aux_bodega");
    }

}
