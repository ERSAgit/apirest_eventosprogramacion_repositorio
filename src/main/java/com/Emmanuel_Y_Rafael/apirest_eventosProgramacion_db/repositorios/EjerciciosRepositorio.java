package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Ejercicios;

@Repository
public interface EjerciciosRepositorio extends JpaRepository<Ejercicios, String> {
    
}