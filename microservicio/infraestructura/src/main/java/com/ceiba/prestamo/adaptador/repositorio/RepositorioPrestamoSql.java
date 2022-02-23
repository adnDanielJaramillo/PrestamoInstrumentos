package com.ceiba.prestamo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.instrumento.modelo.entidad.Prestamo;
import com.ceiba.instrumento.puerto.repositorio.RepositorioPrestamo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPrestamoSql implements RepositorioPrestamo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="prestamo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="prestamo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="prestamo", value="buscarPorUsuario")
    private static String sqlBuscarPorUsuario;

    @SqlStatement(namespace="prestamo", value="existePorId")
    private static String sqlExistePorId;


    public RepositorioPrestamoSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Prestamo prestamo) {
        return this.customNamedParameterJdbcTemplate.crear(prestamo, sqlCrear);
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        this.customNamedParameterJdbcTemplate.actualizar(prestamo, sqlActualizar);
    }

    @Override
    public boolean buscarPorUsuario(String usuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("usuario", usuario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorUsuario,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }


}
