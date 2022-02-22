package com.ceiba.instrumento.comando.fabrica;


import com.ceiba.instrumento.comando.ComandoInstrumento;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import org.springframework.stereotype.Component;

@Component
public class FabricaInstrumento {

    public Prestamo crear(ComandoInstrumento comandoInstrumento){
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
