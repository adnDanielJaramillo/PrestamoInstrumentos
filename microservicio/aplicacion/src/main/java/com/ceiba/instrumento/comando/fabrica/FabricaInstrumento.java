package com.ceiba.instrumento.comando.fabrica;


import com.ceiba.instrumento.comando.ComandoPrestamo;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class FabricaInstrumento {

    public Prestamo crear(ComandoPrestamo comandoInstrumento){
        return new Prestamo(
          comandoInstrumento.getId(),
          comandoInstrumento.getTipo(),
          comandoInstrumento.getNombre(),
          comandoInstrumento.getValorPrestamo(),
          comandoInstrumento.getFechaPrestamo(),
          comandoInstrumento.getUsuario()
        );
    }

}
