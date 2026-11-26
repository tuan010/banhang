package com.spring.demo_tx;

import com.spring.demo_tx.entity.Product;
import com.spring.demo_tx.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoTxApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTxApplication.class, args);
	}

	@Bean
	CommandLineRunner seed(ProductRepository repo){
		return args -> {
			if (repo.count() == 0) repo.save(new Product("Iphone", 100));
		};
	}
}
