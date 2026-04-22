package com.marte.techzone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
        /*this.orderRepository.findAll().forEach(System.out::println);
        var bill = BillEntity.builder()
                .rfc("CASG990908NL6")
                .totalAmount(BigDecimal.TEN)
                .id("b-17")
                .build();
        this.billRepository.save(bill);

        var order1 = OrderEntity.builder()
                .createdAt(LocalDateTime.now())
                .clientName("Marte Canseco")
                .bill(bill)
                .build();

        this.orderRepository.save(order1);*/

        var orders = this.orderRepository.findById(17L).get();

        this.orderRepository.delete(orders);
    }
}
