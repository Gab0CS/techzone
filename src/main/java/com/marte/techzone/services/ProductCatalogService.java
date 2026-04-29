package com.marte.techzone.services;

import com.marte.techzone.entities.ProductCatalogEntity;
import com.marte.techzone.entities.ProductEntity;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductCatalogService {

    ProductCatalogEntity findById(UUID id);
    ProductCatalogEntity findByName(String name);
    List<ProductCatalogEntity> findNameLike(String key);
    List<ProductCatalogEntity> findPriceBetween(BigDecimal min, BigDecimal max);
    List<ProductCatalogEntity> findByCategoryName(BigInteger id);
    //List<ProductCatalogEntity> findByLaunchingDate(LocalDate date, DateEval key);
    List<ProductCatalogEntity> findByBrandAndRating(String brand, Short rating);
    //List<StatisticsProduct> findStatistics();

    Page<ProductCatalogEntity> findAll(String field, Boolean desc);
    Page<ProductCatalogEntity> findAllByBrand(String brand);


}
