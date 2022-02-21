package com.ceiba.instrumento.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoInstrumento {

    private Long id;
    private String tipo;
    private String nombre;
    private String valorPrestamo;
    private LocalDateTime fechaPrestamo;
}
