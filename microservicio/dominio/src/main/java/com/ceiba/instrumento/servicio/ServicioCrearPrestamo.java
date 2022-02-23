package com.ceiba.instrumento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;

public class ServicioCrearPrestamo {

    private static final String EL_USUARIO_YA_TIENE_INSTRUMENTO = "El usuario ya tiene un instrumento prestado";
    private static final String DEBE_INGRESAR_EL_VALOR_CORRECTO = "Debe ingresar el valor correcto para el tipo de instrumento";

    enum Tipos {
        VIENTO,
        CUERDA,
        PERCUSION
    }

    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioCrearPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public Long ejecutar(Prestamo prestamo){
        validarPrestamoExistente(prestamo);
        validarPagoPortipoInstrumento(prestamo);
        return this.repositorioPrestamo.crear(prestamo);
    }

    private void validarPrestamoExistente(Prestamo prestamo){
        boolean existe = this.repositorioPrestamo.buscarPorUsuario(prestamo.getIdUsuario());
        if (existe){
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_TIENE_INSTRUMENTO);
        }
    }

    private void validarPagoPortipoInstrumento(Prestamo prestamo){


        if(prestamo.getTipo().equalsIgnoreCase(Tipos.VIENTO.toString()) && !prestamo.getValorPrestamo().equals(1000.0)){
            throw new ExcepcionValorInvalido(DEBE_INGRESAR_EL_VALOR_CORRECTO);
        }


        if(prestamo.getTipo().equalsIgnoreCase(Tipos.CUERDA.toString()) && !prestamo.getValorPrestamo().equals(3000.0)){
            throw new ExcepcionValorInvalido(DEBE_INGRESAR_EL_VALOR_CORRECTO);
        }

        if(prestamo.getTipo().equalsIgnoreCase(Tipos.PERCUSION.toString()) && !prestamo.getValorPrestamo().equals(5000.0)){
            throw new ExcepcionValorInvalido(DEBE_INGRESAR_EL_VALOR_CORRECTO);
        }
    }
}
