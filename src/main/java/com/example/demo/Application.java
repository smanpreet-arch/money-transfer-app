package com.example.demo;

import com.example.demo.repo.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Preload some accounts
    @Bean
    public org.springframework.boot.CommandLineRunner init(AccountRepository repo) {
    return args -> {
        repo.createAccount(1L, 1000.0);
        repo.createAccount(2L, 500.0);
    };
    }
}