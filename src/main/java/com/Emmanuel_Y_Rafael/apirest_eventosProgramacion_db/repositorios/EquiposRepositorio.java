package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Equipos;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios.EquiposServicioImplementacion;

import jakarta.persistence.StoredProcedureQuery;


@Repository
public interface EquiposRepositorio extends JpaRepository<Equipos, String> {
 
    @Procedure(procedureName = "ConsultarEquiposNoClasificados")
    List<Equipos> consultarEquiposNoClasificados();

    @Procedure(procedureName = "obtenerTop10UniversidadesPorPais")
    List<Object[]> obtenerTop10UniversidadesPorPais(@Param("paisInput") String pais);

    default List<Object[]> consultarEquiposNoClasificados(EquiposServicioImplementacion equiposServicioImplementacion, String universidad) {
        // Crear la consulta del procedimiento almacenado
        StoredProcedureQuery query = equiposServicioImplementacion.entityManager.createStoredProcedureQuery("ConsultarEquiposNoClasificados");
    
        // Registrar y asignar el parámetro de entrada
        query.registerStoredProcedureParameter(1, String.class, jakarta.persistence.ParameterMode.IN);
        query.setParameter(1, universidad);
    
        // Ejecutar el procedimiento almacenado y devolver el resultado
        return query.getResultList();
    }

}

