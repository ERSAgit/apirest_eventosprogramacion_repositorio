package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Equipos;

public interface EquiposServicio {

    public List<Equipos> obtenerTodo();

    public Equipos guardar(Equipos equipos);

    public Equipos obtenerPorId(String id);

    public void eliminar(String id);
    
    // Métodos para procedimientos almacenados
    public List<Equipos> consultarEquiposNoClasificados();

    public List<Object[]> obtenerTop10UniversidadesPorPais(String pais);


}
