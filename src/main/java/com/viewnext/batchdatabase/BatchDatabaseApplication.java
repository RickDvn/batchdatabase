package com.viewnext.batchdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BatchDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchDatabaseApplication.class, args);
	}

}
