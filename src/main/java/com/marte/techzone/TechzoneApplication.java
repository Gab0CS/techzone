package com.marte.techzone;

import com.marte.techzone.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechzoneApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(TechzoneApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        this.orderRepository.findAll().forEach(System.out::println);

    }
}
