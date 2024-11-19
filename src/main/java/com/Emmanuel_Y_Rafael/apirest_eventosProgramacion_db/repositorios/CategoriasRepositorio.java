package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Categorias;

@Repository
public interface CategoriasRepositorio extends JpaRepository<Categorias, String> {
    // Puedes agregar métodos personalizados si los necesitas
}