package com.ceiba.instrumento.comando.fabrica;


import com.ceiba.instrumento.comando.ComandoPrestamo;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class FabricaInstrumento {

    public Prestamo crear(ComandoPrestamo comandoInstrumento){
        return new Prestamo(
          comandoInstrumento.getId(),
          comandoInstrumento.getTipo(),
          comandoInstrumento.getNombre(),
          comandoInstrumento.getValorPrestamo(),
          LocalDate.parse(comandoInstrumento.getFechaPrestamo(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
          LocalDate.parse(comandoInstrumento.getFechaUltimoPago(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
          comandoInstrumento.getIdUsuario()
        );
    }

}
