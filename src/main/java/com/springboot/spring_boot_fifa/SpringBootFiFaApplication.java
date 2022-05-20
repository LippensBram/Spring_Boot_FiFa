package com.springboot.spring_boot_fifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.VoetbalServiceImpl;

@SpringBootApplication
public class SpringBootFiFaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFiFaApplication.class, args);
    }
    @Bean
    public VoetbalServiceImpl voetbalServiceImpl() {
        return new VoetbalServiceImpl();
    }
}
