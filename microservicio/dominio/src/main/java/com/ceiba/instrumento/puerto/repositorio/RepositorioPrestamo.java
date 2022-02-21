package com.ceiba.instrumento.puerto.repositorio;

import com.ceiba.instrumento.modelo.entidad.Prestamo;

public interface RepositorioPrestamo {

    /**
     * Permite crear un prestamo
     * @param prestamo
     * @return el id generado
     */
    Long crear(Prestamo prestamo);

    /**
     * Permite actualizar un prestamo
     * @param prestamo
     */
    void actualizar(Prestamo prestamo);
}
