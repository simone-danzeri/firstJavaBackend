package com.example.familyHappyDb.seeders;
import com.example.familyHappyDb.entity.Babysitter;
import com.example.familyHappyDb.repository.BabysitterRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.List;
@Component
public class BabysitterSeeder {
    @Autowired
    private BabysitterRepository babysitterRepository;
    public void seedDatabase() {
        if (babysitterRepository.count() > 0) {
            System.out.println("Db already populated. Skipping seeder.");
            return;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/babysitters.json");
            List<Babysitter> babysitters = objectMapper.readValue(inputStream, new TypeReference<>() {});

            babysitterRepository.saveAll(babysitters);
            System.out.println("Db populated with " + babysitters.size() + " babysitters.");
        } catch (Exception e) {
            System.err.println("Error during seeding the db: " + e.getMessage());
        }
    }
}
