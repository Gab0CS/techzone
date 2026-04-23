package com.marte.techzone;


import com.marte.techzone.entities.ProductCatalogEntity;
import com.marte.techzone.entities.ProductEntity;
import com.marte.techzone.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.marte.techzone.entities.BillEntity;
import com.marte.techzone.entities.OrderEntity;

@SpringBootApplication
public class TechzoneApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCatalogRepository productCatalogRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

	public static void main(String[] args) {
		SpringApplication.run(TechzoneApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {


    }
}
