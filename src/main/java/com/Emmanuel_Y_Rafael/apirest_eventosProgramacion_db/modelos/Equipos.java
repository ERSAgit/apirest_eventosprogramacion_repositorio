package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "ConsultarEquiposNoClasificados",
        procedureName = "ConsultarEquiposNoClasificados",
        resultClasses = {Equipos.class}
    ),
    @NamedStoredProcedureQuery(
        name = "obtenerTop10UniversidadesPorPais",
        procedureName = "obtenerTop10UniversidadesPorPais",
        parameters = {
            @jakarta.persistence.StoredProcedureParameter(mode = ParameterMode.IN, name = "paisInput", type = String.class)
        },
        resultClasses = {Object[].class}
    )
})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String idEquipo;
    private String nombreEquipo;
    private String institucion;
    private int puntajeTotal;
    private String idCategoria;
    private String pais;
    private Date fechaClasificacion;
    private int cantidadEventosGanados;

    public Equipos() {
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String id) {
        this.idEquipo = id;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaClasificacion() {
        return fechaClasificacion;
    }

    public void setFechaClasificacion(Date fechaClasificacion) {
        this.fechaClasificacion = fechaClasificacion;
    }

    public int getCantidadEventosGanados() {
        return cantidadEventosGanados;
    }

    public void setCantidadEventosGanados(int cantidadEventosGanados) {
        this.cantidadEventosGanados = cantidadEventosGanados;
    }
}

