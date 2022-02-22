package com.ceiba.instrumento.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Prestamo {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO = "Se debe ingresar el tipo de instrumento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_PRESTAMO = "Se debe ingresar la fecha de prestamo";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_INSTRUMENTO = "Se debe ingresar el nombre del instrumento";

    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private LocalDateTime fechaPrestamo;
    private String usuario;

    public Prestamo(Long id, String tipo, String nombre, Double valorPrestamo, LocalDateTime fechaPrestamo, String usuario) {

        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO);
        validarObligatorio(fechaPrestamo, SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO);
        validarObligatorio(usuario, SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO);


        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.valorPrestamo = valorPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.usuario = usuario;
    }
}
