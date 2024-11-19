package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Ejercicios;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios.EjerciciosRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class EjerciciosServicioImplementacion implements EjerciciosServicio{

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    public
    EjerciciosRepositorio EjerciciosRepositorio;

    @Override
    public List<Ejercicios> obtenerTodo() {
        return EjerciciosRepositorio.findAll();
    }

    @Override
    public Ejercicios guardar(Ejercicios Ejercicios) {
        // TODO Auto-generated method stub
        return EjerciciosRepositorio.save(Ejercicios);
    }

    @Override
    public Ejercicios obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return EjerciciosRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(String id) {
        // TODO Auto-generated method stub
        EjerciciosRepositorio.deleteById(id);
    }
   
}
