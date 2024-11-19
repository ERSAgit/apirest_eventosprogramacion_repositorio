package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Categorias;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios.CategoriasRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CategoriasServicioImplementacion implements CategoriasServicio{

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    public
    CategoriasRepositorio CategoriasRepositorio;

    @Override
    public List<Categorias> obtenerTodo() {
        return CategoriasRepositorio.findAll();
    }

    @Override
    public Categorias guardar(Categorias Categorias) {
        // TODO Auto-generated method stub
        return CategoriasRepositorio.save(Categorias);
    }

    @Override
    public Categorias obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return CategoriasRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(String id) {
        // TODO Auto-generated method stub
        CategoriasRepositorio.deleteById(id);
    }
    
}
