package com.marte.techzone.repositories;

import com.marte.techzone.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoryEntity, Long> {
}
