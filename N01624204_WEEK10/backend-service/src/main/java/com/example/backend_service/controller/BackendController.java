package com.example.backend_service.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {

    private final Environment environment;

    public BackendController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public String health() {
        return "I need medical attention!";
    }

    @GetMapping("/backend")
    public String backend() {
        String port = environment.getProperty("local.server.port");
        return "Hello from BACKEND - Port: " + port;
    }
}
