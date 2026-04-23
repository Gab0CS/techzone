package com.marte.techzone.repositories;

import com.marte.techzone.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
