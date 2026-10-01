package com.example.demo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InteraccionController {

    private final RestTemplate restTemplate;

    public InteraccionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/cintegracion")
    public String integrar() {

        String respuestaB = restTemplate.getForObject(
                "http://localhost:8082/consume-a",
                String.class
        );

        return "El modulo C recibio: [" + respuestaB + "]";
    }
}