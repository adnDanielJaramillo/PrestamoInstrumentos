package com.ceiba.prestamo.servicio.testdatabuilder;

import com.ceiba.instrumento.comando.ComandoPrestamo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoPrestamoTestDataBuilder {

    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private String fechaPrestamo;
    private String fechaUltimoPago;
    private String idUsuario;

    public ComandoPrestamoTestDataBuilder() {

        tipo = UUID.randomUUID().toString();
        nombre = UUID.randomUUID().toString();
        valorPrestamo = 1000.0;
        fechaPrestamo = "24/02/2022";
        fechaUltimoPago = "24/02/2022";
        idUsuario = UUID.randomUUID().toString();
    }

    public ComandoPrestamoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoPrestamoTestDataBuilder conTipo(String tipo){
        this.tipo = tipo;
        return this;
    }

    public ComandoPrestamoTestDataBuilder conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public ComandoPrestamoTestDataBuilder conValorPrestamo(Double valorPrestamo){
        this.valorPrestamo = valorPrestamo;
        return this;
    }
    public ComandoPrestamoTestDataBuilder conFechaPrestamo(String fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
        return this;
    }
    public ComandoPrestamoTestDataBuilder fechaUltimoPago(String fechaUltimoPago){
        this.fechaUltimoPago = fechaUltimoPago;
        return this;
    }
    public ComandoPrestamoTestDataBuilder conIdUsuario(String idUsuario){
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoPrestamo build(){
        return new ComandoPrestamo(id,tipo,nombre,valorPrestamo,fechaPrestamo,fechaUltimoPago,idUsuario);
    }
}
