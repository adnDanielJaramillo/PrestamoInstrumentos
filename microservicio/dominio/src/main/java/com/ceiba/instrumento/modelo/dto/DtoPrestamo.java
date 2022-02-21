package com.ceiba.instrumento.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPrestamo {
    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private LocalDateTime fechaPrestamo;
}
