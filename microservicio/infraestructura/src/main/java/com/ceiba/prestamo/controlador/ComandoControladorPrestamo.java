package com.ceiba.prestamo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.instrumento.comando.ComandoInstrumento;
import com.ceiba.instrumento.comando.manejador.ManejadorActualizarPrestamo;
import com.ceiba.instrumento.comando.manejador.ManejadorCrearPrestamo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamo")
@Api(tags = { "Controlador comando prestamo"})
public class ComandoControladorPrestamo {

    private final ManejadorCrearPrestamo manejadorCrearPrestamo;
    private final ManejadorActualizarPrestamo manejadorActualizarPrestamo;

    @Autowired
    public ComandoControladorPrestamo(ManejadorCrearPrestamo manejadorCrearPrestamo, ManejadorActualizarPrestamo manejadorActualizarPrestamo) {
        this.manejadorCrearPrestamo = manejadorCrearPrestamo;
        this.manejadorActualizarPrestamo = manejadorActualizarPrestamo;
    }

    @PostMapping
    @ApiOperation("Crear Prestamo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoInstrumento comandoInstrumento){
        return manejadorCrearPrestamo.ejecutar(comandoInstrumento);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Prestamo")
    public void actualizar(@RequestBody ComandoInstrumento comandoInstrumento, @PathVariable Long id){
        comandoInstrumento.setId(id);
        manejadorActualizarPrestamo.ejecutar(comandoInstrumento);
    }
}
