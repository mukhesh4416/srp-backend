package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController{

    @GetMapping("/hello")
    public List<Map<String, String>> sayHello() {
        return List.of(Map.of("message", "Hello, Spring Boot Working fine"));
    }
}

