package com.example.familyHappyDb.service;
import com.example.familyHappyDb.entity.Babysitter;
import com.example.familyHappyDb.repository.BabysitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BabysitterService {
    @Autowired
    private BabysitterRepository babysitterRepository;
    // CREATE
    public Babysitter createBabysitter(Babysitter babysitter) {
        return babysitterRepository.save(babysitter);
    }
    // READ ALL
    public List<Babysitter> getAllBabysitters() {
        return babysitterRepository.findAll();
    }
    // UPDATE
        public Babysitter updateBabysitter(Long id, Babysitter babysitterDetails) {
            // FindById the babysitter
            Babysitter existingBabysitter = babysitterRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Babysitter not found with id " + id));
            // Update only if it exists
            if (babysitterDetails.getFirstName() != null) {
                existingBabysitter.setFirstName(babysitterDetails.getFirstName());
            }
            if (babysitterDetails.getLastName() != null) {
                existingBabysitter.setLastName(babysitterDetails.getLastName());
            }
            if (babysitterDetails.getPhone() != null) {
                existingBabysitter.setPhone(babysitterDetails.getPhone());
            }
            if (babysitterDetails.getEmail() != null) {
                existingBabysitter.setEmail(babysitterDetails.getEmail());
            }
            if (babysitterDetails.getAddress() != null) {
                existingBabysitter.setAddress(babysitterDetails.getAddress());
            }
            if (babysitterDetails.getIsPayer() != null) {
                existingBabysitter.setIsPayer(babysitterDetails.getIsPayer());
            }

            return babysitterRepository.save(existingBabysitter);
        }

        // DELETE
    public void deleteBabysitter(Long id) {
        babysitterRepository.deleteById(id);
    }
    // GET BABYSITTER BY ID
    public Babysitter getBabysitterById(Long id) {
        return babysitterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Babysitter not found with id: " + id));
    }
}
