package com.ceiba.prestamo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.instrumento.modelo.dto.DtoPrestamo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoPrestamo implements RowMapper<DtoPrestamo>, MapperResult {

    @Override
    public DtoPrestamo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String tipo = rs.getString("tipo");
        String nombre = rs.getString("nombre");
        Double valorPrestamo = rs.getDouble("valor_prestamo");
        LocalDateTime fechaPrestamo = extraerLocalDateTime(rs,"fecha_prestamo");
        String idUsuario = rs.getString("idUsuario");

        return new DtoPrestamo(id, tipo, nombre, valorPrestamo, fechaPrestamo, idUsuario);
    }

}
