package com.emazon.supply.adapters.driven.jpa.myqsl.repository;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
