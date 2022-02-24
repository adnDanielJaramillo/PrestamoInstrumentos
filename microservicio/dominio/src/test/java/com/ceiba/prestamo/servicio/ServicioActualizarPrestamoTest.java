package com.ceiba.prestamo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;
import com.ceiba.instrumento.servicio.ServicioActualizarPrestamo;
import com.ceiba.prestamo.servicio.testdatabuilder.PrestamoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.*;

public class ServicioActualizarPrestamoTest {

    @Test
    @DisplayName("Deberia validar la existencia del prestamo")
    void deberiaValidarLaExistenciaDelPrestamo(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPrestamo servicioActualizarPrestamo = new ServicioActualizarPrestamo(repositorioPrestamo);
        // act - assert
        BasePrueba.assertThrows(()->servicioActualizarPrestamo.ejecutar(prestamo), ExcepcionDuplicidad.class, "El prestamo no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el dia de Pago sea sabado")
    void deberiaLanzarUnaExcepcionCuandoElDiaDePagoSeaSabado(){
        //Arrange
        LocalDate date = LocalDate.of(2022,Month.FEBRUARY,26);
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(20L).conFechaUltimoPago(date).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPrestamo servicioActualizarPrestamo = new ServicioActualizarPrestamo(repositorioPrestamo);
        // act - assert
        BasePrueba.assertThrows(()->servicioActualizarPrestamo.ejecutar(prestamo), ExcepcionValorInvalido.class,"El pago del prestamo solo se puede de lunes a viernes");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el dia de pago sea domingo")
    void deberiaLanzarUnaExcepcionCuandoElDiaDePagoSeaDomingo(){
        //Arrange
        LocalDate date = LocalDate.of(2022,Month.FEBRUARY,27);
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(20L).conFechaUltimoPago(date).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPrestamo servicioActualizarPrestamo = new ServicioActualizarPrestamo(repositorioPrestamo);
        // act - assert
        BasePrueba.assertThrows(()->servicioActualizarPrestamo.ejecutar(prestamo), ExcepcionValorInvalido.class,"El pago del prestamo solo se puede de lunes a viernes");
    }

    @Test
    @DisplayName("Deberia actualizar el prestamo correctamente")
    void deberiaActualizarElPrestamoCorrectamen(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPrestamo servicioActualizarPrestamo = new ServicioActualizarPrestamo(repositorioPrestamo);
        //act
        servicioActualizarPrestamo.ejecutar(prestamo);
        //assert
        Mockito.verify(repositorioPrestamo,Mockito.times(1)).actualizar(prestamo);
    }

}
