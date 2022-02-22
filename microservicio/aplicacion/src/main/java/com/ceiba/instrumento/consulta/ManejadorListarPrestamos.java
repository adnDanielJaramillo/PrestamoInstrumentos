package com.ceiba.instrumento.consulta;

import com.ceiba.instrumento.modelo.dto.DtoPrestamo;
import com.ceiba.instrumento.puerto.dao.DaoPrestamo;

import java.util.List;

public class ManejadorListarPrestamos {

    private final DaoPrestamo daoPrestamo;

    public ManejadorListarPrestamos(DaoPrestamo daoPrestamo) {
        this.daoPrestamo = daoPrestamo;
    }

    public List<DtoPrestamo> ejecutar(){
        return this.daoPrestamo.listar();
    }
}
