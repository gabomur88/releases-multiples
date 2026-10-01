package com.example.demo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumidorController {

    private final RestTemplate restTemplate;

    public ConsumidorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consume-a")
    public String consumirDeModuloA() {

        String respuestaA = restTemplate.getForObject(
                "http://localhost:8081/saludo",
                String.class
        );

        return "El modulo B recibio: [" + respuestaA + "]";
    }
}