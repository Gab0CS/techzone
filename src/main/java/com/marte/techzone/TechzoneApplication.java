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
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

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

    @Autowired
    private RejectProductRepository rejectProductRepository;

	public static void main(String[] args) {
		SpringApplication.run(TechzoneApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

       /*final var home = this.categoriesRepository.findById(1L).orElseThrow();
        final var office = this.categoriesRepository.findById(2L).orElseThrow();

        this.productCatalogRepository.findAll().forEach(product -> {
            if(product.getDescription().contains("home")) {
                product.addCategory(home);
            }
            if (product.getDescription().contains("office")){
                product.addCategory(office);
            }
            this.productCatalogRepository.save(product);
        });

        var random = new Random();
        var productsCatalog = new LinkedList<>(this.productCatalogRepository.findAll());

        IntStream.range(0, productsCatalog.size()).forEach(i -> {
            var idOrderRandom = random.nextLong(16) + 1;
            var orderRandom = this.orderRepository.findById(idOrderRandom).orElseThrow();

            var product = ProductEntity.builder()
                    .quantity(BigInteger.valueOf(random.nextInt(5)+1))
                    .catalog(productsCatalog.poll())
                    .build();
            orderRandom.addProduct(product);
            product.setOrder(orderRandom);

            this.orderRepository.save(orderRandom);
            });*/


        /*this.rejectProductRepository.findAll().forEach(System.out::println);*/
    }
}
