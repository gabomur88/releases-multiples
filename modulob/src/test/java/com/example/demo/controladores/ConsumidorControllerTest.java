package com.example.demo.controladores;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ConsumidorController.class)
public class ConsumidorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestTemplate restTemplate;

    @Test
    void probandoConsumoModuloA() throws Exception {

        when(restTemplate.getForObject(
                "http://localhost:8081/saludo",
                String.class
        )).thenReturn("Hola desde el Modulo A");

        mockMvc.perform(get("/consume-a"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "El modulo B recibio: [Hola desde el Modulo A]"
                ));
    }
}