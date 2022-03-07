package com.ceiba.instrumento.consulta;

import com.ceiba.instrumento.modelo.dto.DtoPrestamo;
import com.ceiba.instrumento.puerto.dao.DaoPrestamo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPrestamoPorId{

    private final DaoPrestamo daoPrestamo;

    public ManejadorObtenerPrestamoPorId(DaoPrestamo daoPrestamo) {
        this.daoPrestamo = daoPrestamo;
    }

    public DtoPrestamo ejecutar(Long id){
        return this.daoPrestamo.obtenerPrestamoPorId(id);
    }
}
