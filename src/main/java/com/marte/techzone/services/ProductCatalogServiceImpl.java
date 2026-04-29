package com.marte.techzone.services;

import com.marte.techzone.entities.ProductCatalogEntity;
import com.marte.techzone.repositories.ProductCatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductCatalogRepository productCatalogRepository;

    @Override
    public ProductCatalogEntity findById(UUID id) {
        return this.productCatalogRepository.findById(id).orElseThrow();
    }

    @Override
    public ProductCatalogEntity findByName(String name) {
        return this.productCatalogRepository.findByName(name).orElseThrow(() -> new RuntimeException("Product not found with name: " +  name));

    }

    @Override
    public List<ProductCatalogEntity> findNameLike(String key) {
        return this.productCatalogRepository.findByNameLike(key);
    }

    @Override
    public List<ProductCatalogEntity> findPriceBetween(BigDecimal min, BigDecimal max) {

        return this.productCatalogRepository.findBetweenTwoPrices(min, max);
    }

    @Override
    public List<ProductCatalogEntity> findByCategoryName(BigInteger id) {
        return List.of();
    }

    @Override
    public List<ProductCatalogEntity> findByBrandAndRating(String brand, Short rating) {
        return List.of();
    }

    @Override
    public Page<ProductCatalogEntity> findAll(String field, Boolean desc) {
        return null;
    }

    @Override
    public Page<ProductCatalogEntity> findAllByBrand(String brand) {
        return null;
    }
}
