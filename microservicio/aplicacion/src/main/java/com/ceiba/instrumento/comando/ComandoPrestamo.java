package com.ceiba.instrumento.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPrestamo {

    private Long id;
    private String tipo;
    private String nombre;
    private Double valorPrestamo;
    private String fechaPrestamo;
    private String fechaUltimoPago;
    private String idUsuario;
}
