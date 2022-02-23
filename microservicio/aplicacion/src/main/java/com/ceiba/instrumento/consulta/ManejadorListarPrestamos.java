package com.ceiba.instrumento.consulta;

import com.ceiba.instrumento.modelo.dto.DtoPrestamo;
import com.ceiba.instrumento.puerto.dao.DaoPrestamo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPrestamos {

    private final DaoPrestamo daoPrestamo;

    public ManejadorListarPrestamos(DaoPrestamo daoPrestamo) {
        this.daoPrestamo = daoPrestamo;
    }

    public List<DtoPrestamo> ejecutar(){
        return this.daoPrestamo.listar();
    }
}
