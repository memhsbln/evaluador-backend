package com.evaluetiondoc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EvaluacionDocenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionDocenteApplication.class, args);
	}

}
