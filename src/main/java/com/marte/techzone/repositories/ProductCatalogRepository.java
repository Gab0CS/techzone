package com.marte.techzone.repositories;

import com.marte.techzone.dtos.ReportProduct;
import com.marte.techzone.entities.ProductCatalogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalogEntity, UUID> {

    Optional<ProductCatalogEntity> findByName(String name);

    List<ProductCatalogEntity> findByNameLike(String key);

    @Query("FROM productCatalog p WHERE p.price between :min and :max")
    List<ProductCatalogEntity> findBetweenTwoPrices(BigDecimal min, BigDecimal max);

    @Query("FROM productCatalog p LEFT JOIN fetch p.categories c WHERE c.id = :categoryId")
    List<ProductCatalogEntity> getByCategory(Long categoryId);

    List<ProductCatalogEntity> findByLaunchingDateBefore(LocalDate date);

    List<ProductCatalogEntity> findByLaunchingDateAfter(LocalDate date);

    List<ProductCatalogEntity> findByBrandAndRatingGreaterThan(String brand, Short rating);

    List<ProductCatalogEntity> findByBrandOrRatingGreaterThan(String brand, Short rating);

    @Query("SELECT new com.marte.techzone.dtos.ReportProduct(" + "pc.brand," + "avg(pc.price)," + "sum(pc.price))" +  "from productCatalog pc group by pc.brand")
    List<ReportProduct> findAndMakeReport();

    Page<ProductCatalogEntity> findAllByBrand(String brand, Pageable pageable);

    @Procedure(procedureName = "count_total_products_by_brand", outputParameterName = "response")
    Integer countTotalProductsByBrandStoredProcedure(@Param(value = "brand") String brand);
}
