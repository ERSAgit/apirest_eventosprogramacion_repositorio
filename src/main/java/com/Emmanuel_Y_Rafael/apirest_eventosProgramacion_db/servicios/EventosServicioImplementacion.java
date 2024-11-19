package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Eventos;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios.EventosRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class EventosServicioImplementacion implements EventosServicio{

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    public
    EventosRepositorio EventosRepositorio;

    @Override
    public List<Eventos> obtenerTodo() {
        return EventosRepositorio.findAll();
    }

    @Override
    public Eventos guardar(Eventos Eventos) {
        // TODO Auto-generated method stub
        return EventosRepositorio.save(Eventos);
    }

    @Override
    public Eventos obtenerPorId(Integer id) {
        // TODO Auto-generated method stub
        return EventosRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        EventosRepositorio.deleteById(id);
    }

}
