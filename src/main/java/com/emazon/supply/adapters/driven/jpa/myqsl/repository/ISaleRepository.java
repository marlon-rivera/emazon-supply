package com.emazon.supply.adapters.driven.jpa.myqsl.repository;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<SaleEntity, Long> {
}
