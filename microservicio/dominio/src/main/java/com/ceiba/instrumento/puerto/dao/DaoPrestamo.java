package com.ceiba.instrumento.puerto.dao;

import com.ceiba.instrumento.modelo.dto.DtoPrestamo;

import java.util.List;

public interface DaoPrestamo {
    /**
     * Permite listar prestamos
     * @return los prestamos
     */
    List<DtoPrestamo> listar();

    /**
     * Permite obtener un prestamos por id
     * @param id
     * @return
     */
    DtoPrestamo obtenerPrestamoPorId(Long id);
}
