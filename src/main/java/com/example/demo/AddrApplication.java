package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AddrApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddrApplication.class, args);
	}
	
    @PostConstruct
    public void initialize(){

    }
    
    @PreDestroy
    public void preDestroy() {

    }    
}
