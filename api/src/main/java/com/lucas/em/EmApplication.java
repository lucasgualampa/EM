package com.lucas.em;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmApplication {
// first open MySQL cmd and create a database with given name
	public static void main(String[] args) {
		SpringApplication.run(EmApplication.class, args);
	}

}
