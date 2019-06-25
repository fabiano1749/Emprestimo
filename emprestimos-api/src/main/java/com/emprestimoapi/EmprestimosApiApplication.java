package com.emprestimoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.emprestimoapi.config.property.EmprestimoApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(EmprestimoApiProperty.class)
public class EmprestimosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmprestimosApiApplication.class, args);
	}
}
