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

@WebMvcTest(controllers = InteraccionController.class)
public class InteraccionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RestTemplate restTemplate;

    @Test
    void probandoComunicacionModuloC() throws Exception {

        when(restTemplate.getForObject(
                "http://localhost:8082/consume-a",
                String.class
        )).thenReturn("El modulo B recibio: [Hola desde el Modulo A]");

        mockMvc.perform(get("/cintegracion"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "El modulo C recibio: [El modulo B recibio: [Hola desde el Modulo A]]"
                ));
    }
}