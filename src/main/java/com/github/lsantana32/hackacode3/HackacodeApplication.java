package com.github.lsantana32.hackacode3;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.github.lsantana32.hackacode3.entity")
public class HackacodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackacodeApplication.class, args);
	}

}
