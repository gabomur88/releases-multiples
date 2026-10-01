package com.example.demo.controladores;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SaludoController.class)
public class SaludoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void probandoSaludoEsperandoRespuestaTexto() throws Exception {

        mockMvc.perform(get("/saludo"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hola desde el Modulo A"));
    }
}