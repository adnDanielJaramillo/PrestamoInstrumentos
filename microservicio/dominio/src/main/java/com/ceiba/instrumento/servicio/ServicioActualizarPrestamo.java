package com.ceiba.instrumento.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioActualizarPrestamo {

    private static final String EL_PRESTAMO_NO_EXISTE_EN_EL_SISTEMA = "El prestamo no existe en el sistema";
    private static final String EL_PAGO_DEL_PRESTAMO_SOLO_SE_PUEDE_EN_SEMANA = "El pago del prestamo solo se puede de lunes a viernes";

    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioActualizarPrestamo(RepositorioPrestamo repositorioPrestamo) {
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public void ejecutar(Prestamo prestamo) {
        validarExistenciaPrevia(prestamo);
        validarDiaDePagoPrestamo(prestamo);
        this.repositorioPrestamo.actualizar(prestamo);
    }

    private void validarExistenciaPrevia(Prestamo prestamo) {
        boolean existe = this.repositorioPrestamo.existePorId(prestamo.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_PRESTAMO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarDiaDePagoPrestamo(Prestamo prestamo){
        LocalDate date = prestamo.getFechaUltimoPago();
        DayOfWeek day = date.getDayOfWeek();
        if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
            throw new ExcepcionValorInvalido(EL_PAGO_DEL_PRESTAMO_SOLO_SE_PUEDE_EN_SEMANA);
        }
    }
}
