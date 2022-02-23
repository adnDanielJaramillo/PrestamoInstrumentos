package com.ceiba.instrumento.modelo.entidad;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 231L;
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO = "Se debe ingresar el tipo de instrumento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_PRESTAMO = "Se debe ingresar la fecha de prestamo";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_PRESTAMO = "Se debe ingresar el valor del prestamo";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_INSTRUMENTO = "Se debe ingresar el nombre del instrumento";
    private static final String SE_DEBE_INGRESAR_EL_ID_USUARIO = "Se debe ingresar el id del usuario";

    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private LocalDateTime fechaPrestamo;
    private String idUsuario;

    public Prestamo(Long id, String tipo, String nombre, Double valorPrestamo, LocalDateTime fechaPrestamo, String idUsuario) {

        validarObligatorio(tipo, SE_DEBE_INGRESAR_EL_TIPO_DE_INSTRUMENTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_INSTRUMENTO);
        validarObligatorio(valorPrestamo, SE_DEBE_INGRESAR_EL_VALOR_PRESTAMO);
        validarObligatorio(fechaPrestamo, SE_DEBE_INGRESAR_LA_FECHA_PRESTAMO);
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_USUARIO);


        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.valorPrestamo = valorPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.idUsuario = idUsuario;
    }
}
