package com.example.client_service.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    private final RestTemplate restTemplate;

    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/client/frontend")
    public String callBackend(HttpServletRequest request) {
        String clientType = request.getHeader("X-Client-Type");
        String result = restTemplate.getForObject("http://backend-service/backend", String.class);

        return "[Client-Type: " + clientType + "]\nResponse from backend: " + result;
    }
}
