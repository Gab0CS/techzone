package com.marte.techzone.repositories;

import com.marte.techzone.entities.ProductCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalogEntity, UUID> {

    Optional<ProductCatalogEntity> findByName(String name);

    List<ProductCatalogEntity> findByNameLike(String key);

    @Query("FROM ProductCatalogEntity p WHERE p.price between :min and :max")
    List<ProductCatalogEntity> findBetweenTwoPrices(BigDecimal min, BigDecimal max);
}
