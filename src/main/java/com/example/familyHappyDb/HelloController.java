package com.example.familyHappyDb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @GetMapping("/hello")
        public String sayHello() {
        return "Hello Simon you are using SpringBoot!";
    }
}
