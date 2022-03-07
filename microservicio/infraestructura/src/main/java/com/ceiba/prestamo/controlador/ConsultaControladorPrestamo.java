package com.ceiba.prestamo.controlador;

import com.ceiba.instrumento.consulta.ManejadorListarPrestamos;
import com.ceiba.instrumento.consulta.ManejadorObtenerPrestamoPorId;
import com.ceiba.instrumento.modelo.dto.DtoPrestamo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@Api(tags={"Controlador consulta pretamo"})
public class ConsultaControladorPrestamo {

    private final ManejadorListarPrestamos manejadorListarPrestamos;
    private final ManejadorObtenerPrestamoPorId manejadorObtenerPrestamoPorId;

    public ConsultaControladorPrestamo(ManejadorListarPrestamos manejadorListarPrestamos, ManejadorObtenerPrestamoPorId manejadorObtenerPrestamoPorId) {
        this.manejadorListarPrestamos = manejadorListarPrestamos;
        this.manejadorObtenerPrestamoPorId = manejadorObtenerPrestamoPorId;
    }

    @GetMapping
    @ApiOperation("Listar prestamos")
    public List<DtoPrestamo> listar(){
        return this.manejadorListarPrestamos.ejecutar();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Obteneer prestamos por id")
    public DtoPrestamo obtenerPrestamosPorId(@PathVariable Long id){
        return this.manejadorObtenerPrestamoPorId.ejecutar(id);
    }
}
