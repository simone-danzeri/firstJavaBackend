package com.example.familyHappyDb.controller;
import com.example.familyHappyDb.entity.Babysitter;
import com.example.familyHappyDb.repository.BabysitterRepository;
import com.example.familyHappyDb.service.BabysitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/babysitters")
public class BabysitterController {
    @Autowired
    private BabysitterService babysitterService;
    // CREATE
    @PostMapping
    public Babysitter createBabysitter(@RequestBody Babysitter babysitter) {
        return babysitterService.createBabysitter(babysitter);
    }
    // READ ALL
    @GetMapping
    public List<Babysitter> getAllBabysitters() {
        return babysitterService.getAllBabysitters();
    }
    // UPDATE
    @PutMapping("/{id}")
    public Babysitter updateBabysitter(@PathVariable Long id, @RequestBody Babysitter babysitter) {
        return babysitterService.updateBabysitter(id, babysitter);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteBabysitter(@PathVariable Long id) {
        babysitterService.deleteBabysitter(id);
    }
}
