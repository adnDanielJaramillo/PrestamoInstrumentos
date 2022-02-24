package com.ceiba.instrumento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoPrestamo {
    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaUltimoPago;
    private String usuario;
}
