package com.ceiba.prestamo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.testdatabuilder.PrestamoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrestamoTest {

    @Test
    @DisplayName("Deberia crear correctamente el prestamo")
    void deberiaCrearCorrectamenteElPrestamo(){
        //arrange
        LocalDate fechaPrestamo = LocalDate.now();
        //act
        Prestamo prestamo = new PrestamoTestDataBuilder().conFechaPrestamo(fechaPrestamo).conId(1L).build();
        //assert
        assertEquals(1, prestamo.getId());
        assertEquals("viento", prestamo.getTipo());
        assertEquals("flauta", prestamo.getNombre());
        assertEquals(1000.0, prestamo.getValorPrestamo());
        assertEquals(fechaPrestamo, prestamo.getFechaPrestamo());
        assertEquals("1", prestamo.getIdUsuario());
    }

    @Test
    void deberiaFallarSinTipo(){
        //Arrage
        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conTipo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
            prestamoTestDataBuilder.build();
        },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de instrumento"
        );
    }

    @Test
    void deberiaFallarSinNombre(){
        //Arrage
        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del instrumento"
        );
    }

    @Test
    void deberiaFallarSinValorPrestamo(){
        //Arrage
        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conValorPrestamo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el valor del prestamo"
        );
    }

    @Test
    void deberiaFallarSinFechaPrestamo(){
        //Arrage
        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conFechaPrestamo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de prestamo"
        );
    }

    @Test
    void deberiaFallarSinFechaUltimoPago(){
        //Arrage
        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conFechaUltimoPago(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de ultimo pago"
        );
    }

    @Test
    void deberiaFallarSinIdUsuario(){
        //Arrage
        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conIdUsuario(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()->{
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el id del usuario"
        );
    }
}
