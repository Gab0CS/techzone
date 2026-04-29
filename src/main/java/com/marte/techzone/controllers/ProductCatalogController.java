package com.marte.techzone.controllers;

import com.marte.techzone.entities.ProductCatalogEntity;
import com.marte.techzone.enums.LikeKey;
import com.marte.techzone.services.ProductCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
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



}
