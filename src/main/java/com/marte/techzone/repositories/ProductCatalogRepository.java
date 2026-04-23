package com.marte.techzone.repositories;

import com.marte.techzone.entities.ProductCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalogEntity, UUID> {
}
