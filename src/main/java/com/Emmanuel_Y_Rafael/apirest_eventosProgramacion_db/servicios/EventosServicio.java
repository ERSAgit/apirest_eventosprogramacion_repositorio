package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Eventos;

public interface EventosServicio {

    public List<Eventos> obtenerTodo();

    public Eventos guardar(Eventos eventos);

    public Eventos obtenerPorId(Integer id);

    public void eliminar(Integer id);

}
