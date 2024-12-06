package com.example.familyHappyDb.config;

import com.example.familyHappyDb.seeders.BabysitterSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeederConfig {

    @Bean
    public CommandLineRunner runSeeder(BabysitterSeeder babysitterSeeder) {
        return args -> {
            babysitterSeeder.seedDatabase();
        };
    }
}

