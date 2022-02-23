package com.ceiba.prestamo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.instrumento.modelo.dto.DtoPrestamo;
import com.ceiba.instrumento.puerto.dao.DaoPrestamo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPrestamoSql implements DaoPrestamo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="prestamo", value="listar")
    private static String sqlListar;

    public DaoPrestamoSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPrestamo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPrestamo());
    }
}
