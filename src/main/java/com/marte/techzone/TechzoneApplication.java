package com.marte.techzone;


import com.marte.techzone.entities.ProductEntity;
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
import com.marte.techzone.repositories.BillRepository;
import com.marte.techzone.repositories.OrderRepository;

@SpringBootApplication
public class TechzoneApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillRepository billRepository;

	public static void main(String[] args) {
		SpringApplication.run(TechzoneApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        var order = this.orderRepository.findById(2L).orElseThrow();

        /*var product1 = ProductEntity.builder().quantity(BigInteger.ONE).build();
        var product2 = ProductEntity.builder().quantity(BigInteger.TWO).build();
        var product3 = ProductEntity.builder().quantity(BigInteger.TEN).build();
        var products = List.of(product1, product2, product3);
        order.setProducts(products);
        products.forEach(product -> product.setOrder(order));*/

        order.getProducts().removeFirst();

        this.orderRepository.save(order);
    }
}
