package com.marte.techzone.controllers;

import com.marte.techzone.dtos.DateEval;
import com.marte.techzone.dtos.ReportProduct;
import com.marte.techzone.entities.ProductCatalogEntity;
import com.marte.techzone.enums.LikeKey;
import com.marte.techzone.services.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "product-catalog")
@RequiredArgsConstructor
public class ProductCatalogController {

    private ProductCatalogService productCatalogService;

    @Autowired
    public ProductCatalogController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductCatalogEntity> getById(@PathVariable String id){
        return ResponseEntity.ok(this.productCatalogService.findById(UUID.fromString(id)));
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<ProductCatalogEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.productCatalogService.findByName(name));

    }

    @GetMapping(path = "like/{key}")
    public ResponseEntity<List<ProductCatalogEntity>> getByNameLike(@PathVariable LikeKey key, @RequestParam String word){
        final var placeholder = "%";

        if(key.equals(LikeKey.AFTER)){
            return ResponseEntity.ok(this.productCatalogService.findNameLike(placeholder + word));
        } else if (key.equals(LikeKey.BEFORE)) {
            return ResponseEntity.ok(this.productCatalogService.findNameLike(word + placeholder));
        } else if (key.equals(LikeKey.BETWEEN)) {
            return ResponseEntity.ok(this.productCatalogService.findNameLike(placeholder + word + placeholder));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(path = "between")
    public ResponseEntity<List<ProductCatalogEntity>> getBetween(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        return ResponseEntity.ok(this.productCatalogService.findPriceBetween(min, max));

    }

    @GetMapping(path = "category")
    public ResponseEntity<List<ProductCatalogEntity>> getByCategory(@RequestParam Long id){
        return ResponseEntity.ok(this.productCatalogService.findByCategoryId(id));

    }

    @GetMapping(path = "date-launch/{key}")
    public ResponseEntity<List<ProductCatalogEntity>> getByDate(@PathVariable DateEval key, @RequestParam LocalDate date){
        return ResponseEntity.ok(this.productCatalogService.findByLaunchingDate(date, key));

    }

    @GetMapping(path = "brand-rating")
    public ResponseEntity<List<ProductCatalogEntity>> getByBrandAndRating(@RequestParam String brand, @RequestParam Short rating){
        return ResponseEntity.ok(this.productCatalogService.findByBrandAndRating(brand, rating));

    }

    @GetMapping(path = "brand-or-rating")
    public ResponseEntity<List<ProductCatalogEntity>> getByBrandOrRating(@RequestParam String brand, @RequestParam Short rating){
        return ResponseEntity.ok(this.productCatalogService.findByBrandOrRating(brand, rating));

    }

    @GetMapping(path = "report")
    public ResponseEntity<List<ReportProduct>> getByCategory(){
        return ResponseEntity.ok(this.productCatalogService.makeReport());
    }

    @GetMapping(path = "all")
    public  ResponseEntity<Page<ProductCatalogEntity>> getAll(
        @RequestParam(required = false) String field,
        @RequestParam(required = true) Boolean desc,
        @RequestParam(required = true) Integer page)
    {
        return ResponseEntity.ok(this.productCatalogService.findAll(field, desc, page));

    }

    @GetMapping(path = "all-by-brand")
    public  ResponseEntity<Page<ProductCatalogEntity>> getAllByBrand(
            @RequestParam String brand,
            @RequestParam Integer page)
    {
        return ResponseEntity.ok(this.productCatalogService.findAllByBrand(brand, page));

    }

    @GetMapping(path = "brand-count/{brand}")
    public ResponseEntity<Integer> getCountByBrand(@PathVariable String brand){
        return ResponseEntity.ok(this.productCatalogService.countByBrand(brand));
    }
}
