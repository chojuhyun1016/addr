package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class AddrApplication extends SpringBootServletInitializer{

	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { 
		return application.sources(AddrApplication.class);
	}

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
