package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Equipos;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios.EquiposRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class EquiposServicioImplementacion implements EquiposServicio{

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    public
    EquiposRepositorio equiposRepositorio;

    @Override
    public List<Equipos> obtenerTodo() {
        return equiposRepositorio.findAll();
    }

    @Override
    public Equipos guardar(Equipos equipos) {
        // TODO Auto-generated method stub
        return equiposRepositorio.save(equipos);
    }

    @Override
    public Equipos obtenerPorId(String id) {
        // TODO Auto-generated method stub
        return equiposRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(String id) {
        // TODO Auto-generated method stub
        equiposRepositorio.deleteById(id);
    }

    @Override
    public List<Equipos> consultarEquiposNoClasificados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarEquiposNoClasificados'");
    }

    @Override
    public List<Object[]> obtenerTop10UniversidadesPorPais(String pais) {
        // Crear la consulta para el procedimiento almacenado
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("obtenerTop10UniversidadesPorPais");
        
        // Registrar el parámetro de entrada
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        
        // Establecer el valor del parámetro
        query.setParameter(1, pais);
        
        // Ejecutar el procedimiento almacenado y obtener resultados
        return query.getResultList();
    }

    
}
