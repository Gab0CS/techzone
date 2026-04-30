package com.marte.techzone.services;

import com.marte.techzone.dtos.DateEval;
import com.marte.techzone.dtos.ReportProduct;
import com.marte.techzone.entities.ProductCatalogEntity;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductCatalogService {

    ProductCatalogEntity findById(UUID id);
    ProductCatalogEntity findByName(String name);
    List<ProductCatalogEntity> findNameLike(String key);
    List<ProductCatalogEntity> findPriceBetween(BigDecimal min, BigDecimal max);
    List<ProductCatalogEntity> findByCategoryId(Long id);
    List<ProductCatalogEntity> findByLaunchingDate(LocalDate date, DateEval key);
    List<ProductCatalogEntity> findByBrandAndRating(String brand, Short rating);
    List<ProductCatalogEntity> findByBrandOrRating(String brand, Short rating);
    List<ReportProduct> makeReport();

    Page<ProductCatalogEntity> findAll(String field, Boolean desc, Integer page);
    Page<ProductCatalogEntity> findAllByBrand(String brand, Integer page);
    Integer countByBrand(String brand);
}
