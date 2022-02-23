package com.ceiba.prestamo.servicio.testdatabuilder;

import com.ceiba.instrumento.modelo.entidad.Prestamo;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class PrestamoTestDataBuilder {

    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private LocalDateTime fechaPrestamo;
    private String idUsuario;

    public PrestamoTestDataBuilder() {
        tipo = "viento";
        nombre = "flauta";
        valorPrestamo = 1000.0;
        fechaPrestamo = LocalDateTime.now();
        idUsuario = "1";
    }

    public PrestamoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public PrestamoTestDataBuilder conTipo(String tipo){
        this.tipo = tipo;
        return this;
    }

    public PrestamoTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public PrestamoTestDataBuilder conValorPrestamo(Double valorPrestamo){
        this.valorPrestamo = valorPrestamo;
        return this;
    }
    public PrestamoTestDataBuilder conFechaPrestamo(LocalDateTime fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
        return this;
    }
    public PrestamoTestDataBuilder conIdUsuario(String idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public Prestamo build(){
        return new Prestamo(id,tipo,nombre,valorPrestamo,fechaPrestamo,idUsuario);
    }
}
