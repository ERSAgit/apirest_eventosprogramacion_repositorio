package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Ejercicios;

public interface EjerciciosServicio {

    public List<Ejercicios> obtenerTodo();

    public Ejercicios guardar(Ejercicios ejercicios);

    public Ejercicios obtenerPorId(String id);

    public void eliminar(String id);

}
