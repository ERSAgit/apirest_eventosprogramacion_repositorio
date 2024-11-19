package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Categorias;

public interface CategoriasServicio {

    public List<Categorias> obtenerTodo();

    public Categorias guardar(Categorias categorias);

    public Categorias obtenerPorId(String id);

    public void eliminar(String id);

}