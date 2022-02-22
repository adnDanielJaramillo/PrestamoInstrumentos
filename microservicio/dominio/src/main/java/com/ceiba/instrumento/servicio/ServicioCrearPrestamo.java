package com.ceiba.instrumento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;

public class ServicioCrearPrestamo {

    private static final String EL_USUARIO_YA_TIENE_INSTRUMENTO = "El usuario ya tiene un instrumento prestado";

    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioCrearPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public Long ejecutar(Prestamo prestamo){
        validarPrestamoExistente(prestamo);
        return this.repositorioPrestamo.crear(prestamo);
    }

    private void validarPrestamoExistente(Prestamo prestamo){
        boolean existe = this.repositorioPrestamo.buscarPorUsuario(prestamo.getIdUsuario());
        if (existe){
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_TIENE_INSTRUMENTO);
        }
    }
}
