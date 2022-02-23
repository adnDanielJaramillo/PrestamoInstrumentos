package com.ceiba.instrumento.comando.manejador;


import com.ceiba.instrumento.comando.ComandoInstrumento;
import com.ceiba.instrumento.comando.fabrica.FabricaInstrumento;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.servicio.ServicioActualizarPrestamo;
import com.ceiba.manejador.ManejadorComando;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPrestamo implements ManejadorComando<ComandoInstrumento> {

    private final FabricaInstrumento fabricaInstrumento;
    private final ServicioActualizarPrestamo servicioActualizarPrestamo;

    public ManejadorActualizarPrestamo(FabricaInstrumento fabricaInstrumento, ServicioActualizarPrestamo servicioActualizarPrestamo) {
        this.fabricaInstrumento = fabricaInstrumento;
        this.servicioActualizarPrestamo = servicioActualizarPrestamo;
    }

    @Override
    public void ejecutar(ComandoInstrumento comando) {
        Prestamo prestamo = this.fabricaInstrumento.crear(comando);
        this.servicioActualizarPrestamo.ejecutar(prestamo);
    }
}
