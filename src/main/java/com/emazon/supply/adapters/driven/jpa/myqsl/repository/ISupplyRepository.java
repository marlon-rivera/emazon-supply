package com.emazon.supply.adapters.driven.jpa.myqsl.repository;

import com.emazon.supply.adapters.driven.jpa.myqsl.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface ISupplyRepository extends JpaRepository<SupplyEntity, Long> {

    @Query("SELECT MAX(s.deliveryDate) FROM supplies s WHERE s.idArticle = :idArticle")
    Optional<LocalDate> findLastDeliveryDateByArticleId(@Param("idArticle") Long idArticle);

}
