package com.ceiba.prestamo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;
import com.ceiba.instrumento.servicio.ServicioCrearPrestamo;
import com.ceiba.prestamo.servicio.testdatabuilder.PrestamoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPrestamoTest {

    @Test
    @DisplayName("Deberia Crear el prestamo correctamente")
    void deberiaCrearElPrestamoCorrectamente(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPrestamo.crear(prestamo)).thenReturn(10L);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act
        Long idPrestamo = servicioCrearPrestamo.ejecutar(prestamo);
        //assert
        assertEquals(10L,idPrestamo);
        Mockito.verify(repositorioPrestamo, Mockito.times(1)).crear(prestamo);
    }

    @Test
    @DisplayName("Deberia guardar correctamente el prestamo cuando el tipo de instrumento sea viento y el valor sea correctos")
    void deberiaGuardarCorrectamenteElPrestamoCuandoElTipoDeInstrumentoSeaVientoYelValorSeaCorrecto(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conTipo("cuerda").conValorPrestamo(3000.0).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPrestamo.crear(prestamo)).thenReturn(10L);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act
        Long idPrestamo = servicioCrearPrestamo.ejecutar(prestamo);
        //assert
        assertEquals(10L,idPrestamo);
        Mockito.verify(repositorioPrestamo, Mockito.times(1)).crear(prestamo);
    }

    @Test
    @DisplayName("Deberia guardar correctamente el prestamo cuando el tipo de instrumento sea viento y el valor sea correctos")
    void deberiaGuardarCorrectamenteElPrestamoCuandoElTipoDeInstrumentoSeaPercusionYelValorSeaCorrecto(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conTipo("percusion").conValorPrestamo(5000.0).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPrestamo.crear(prestamo)).thenReturn(10L);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act
        Long idPrestamo = servicioCrearPrestamo.ejecutar(prestamo);
        //assert
        assertEquals(10L,idPrestamo);
        Mockito.verify(repositorioPrestamo, Mockito.times(1)).crear(prestamo);
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide el prestamo por usuario")
    void deberiaLanzarUnaExcepcionCunadoSeValideElPrestamoPorUsuario(){
        //arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(true);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act-assert
        BasePrueba.assertThrows(()-> servicioCrearPrestamo.ejecutar(prestamo), ExcepcionDuplicidad.class, "El usuario ya tiene un instrumento prestado");
    }


    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el valor del prestamo no sea el correcto para el tipo de instrumento viento")
    void deberiaLanzarUnaExcepcionCuandoElValorDelPrestamoNoSeaElCorrectoParaElTipoDeInstrumentoViento(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conTipo("viento").conValorPrestamo(5000.0).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(false);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearPrestamo.ejecutar(prestamo), ExcepcionValorInvalido.class, "Debe ingresar el valor correcto para el tipo de instrumento");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el valor del prestamo no sea el correcto para el tipo de instrumento viento")
    void deberiaLanzarUnaExcepcionCuandoElValorDelPrestamoNoSeaElCorrectoParaElTipoDeInstrumentoCuerda(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conTipo("cuerda").conValorPrestamo(1000.0).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(false);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearPrestamo.ejecutar(prestamo), ExcepcionValorInvalido.class, "Debe ingresar el valor correcto para el tipo de instrumento");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el valor del prestamo no sea el correcto para el tipo de instrumento viento")
    void deberiaLanzarUnaExcepcionCuandoElValorDelPrestamoNoSeaElCorrectoParaElTipoDeInstrumentoPercusion(){
        //Arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conTipo("percusion").conValorPrestamo(3000.0).build();
        RepositorioPrestamo repositorioPrestamo = Mockito.mock(RepositorioPrestamo.class);
        Mockito.when(repositorioPrestamo.buscarPorUsuario(Mockito.anyString())).thenReturn(false);
        ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearPrestamo.ejecutar(prestamo), ExcepcionValorInvalido.class, "Debe ingresar el valor correcto para el tipo de instrumento");
    }
}
