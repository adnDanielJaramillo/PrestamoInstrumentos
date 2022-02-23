package com.ceiba.instrumento.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.instrumento.comando.ComandoPrestamo;
import com.ceiba.instrumento.comando.fabrica.FabricaInstrumento;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.servicio.ServicioCrearPrestamo;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPrestamo implements ManejadorComandoRespuesta<ComandoPrestamo, ComandoRespuesta<Long>> {

    private final FabricaInstrumento fabricaInstrumento;
    private final ServicioCrearPrestamo servicioCrearPrestamo;

    public ManejadorCrearPrestamo(FabricaInstrumento fabricaInstrumento, ServicioCrearPrestamo servicioCrearPrestamo) {
        this.fabricaInstrumento = fabricaInstrumento;
        this.servicioCrearPrestamo = servicioCrearPrestamo;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPrestamo comandoInstrumento) {
        Prestamo prestamo = this.fabricaInstrumento.crear(comandoInstrumento);
        return new ComandoRespuesta<>(this.servicioCrearPrestamo.ejecutar(prestamo));
    }
}
