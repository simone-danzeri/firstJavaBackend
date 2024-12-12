package com.example.familyHappyDb.repository;
import com.example.familyHappyDb.entity.Babysitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BabysitterRepository extends JpaRepository <Babysitter, Long> {
    Babysitter getBabysitterById(Long id);
}
