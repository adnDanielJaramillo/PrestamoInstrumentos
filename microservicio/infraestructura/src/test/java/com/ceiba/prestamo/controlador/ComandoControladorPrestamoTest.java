package com.ceiba.prestamo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.instrumento.comando.ComandoPrestamo;
import com.ceiba.prestamo.servicio.testdatabuilder.ComandoPrestamoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPrestamo.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorPrestamoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un prestamo")
    void deberiaCrearUnPrestamo()throws Exception{
        // arrange
        ComandoPrestamo prestamo = new ComandoPrestamoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/prestamo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(prestamo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

    }

    @Test
    @DisplayName("Deberia actualizar un prestamo")
    void deberiaActualizarUnPrestamo() throws Exception{
        //Arrange
        Long id = 1L;
        ComandoPrestamo prestamo = new ComandoPrestamoTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/prestamo/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(prestamo)))
                .andExpect(status().isOk());
    }
}
