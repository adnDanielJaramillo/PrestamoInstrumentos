package com.ceiba.configuracion;

import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;
import com.ceiba.instrumento.servicio.ServicioActualizarPrestamo;
import com.ceiba.instrumento.servicio.ServicioCrearPrestamo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPrestamo {

    @Bean
    public ServicioCrearPrestamo servicioCrearPrestamo(RepositorioPrestamo repositorioPrestamo){
        return new ServicioCrearPrestamo(repositorioPrestamo);
    }

    @Bean
    public ServicioActualizarPrestamo servicioActualizarPrestamo(RepositorioPrestamo repositorioPrestamo){
        return new ServicioActualizarPrestamo(repositorioPrestamo);
    }
}
