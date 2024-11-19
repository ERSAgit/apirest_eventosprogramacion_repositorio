package com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.controladores;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Equipos;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios.EquiposServicioImplementacion;

@RestController
@RequestMapping("/api/v1")
public class EquiposControlador {

    @Autowired
    EquiposServicioImplementacion equiposServicio;

    @GetMapping("/equipos")
    public List<Equipos> obtenerEquipos(){
        return equiposServicio.obtenerTodo();
    }

    @PostMapping("/guardar_equipos")
    public ResponseEntity<Equipos> guardarEquipos(@RequestBody Equipos equipos){
        Equipos nuevo_equipos = equiposServicio.guardar(equipos);
        return new ResponseEntity<>(nuevo_equipos, HttpStatus.CREATED);
    }

    @GetMapping("/equipos/{id}")
    public ResponseEntity<Equipos> obtenerEquiposId(@PathVariable String id){
        Equipos equiposPorId = equiposServicio.obtenerPorId(id);

        return ResponseEntity.ok(equiposPorId);
    }

    @PutMapping("/equipos/{id}")
    public ResponseEntity<Equipos> actualizar(@PathVariable String id, @RequestBody Equipos equipos){
        Equipos equiposPorId = equiposServicio.obtenerPorId(id);
        equiposPorId.setIdEquipo(equipos.getIdEquipo());
        equiposPorId.setNombreEquipo(equipos.getNombreEquipo());
        equiposPorId.setInstitucion(equipos.getInstitucion());
        equiposPorId.setPuntajeTotal(equipos.getPuntajeTotal());
        equiposPorId.setIdCategoria(equipos.getIdCategoria());
        equiposPorId.setPais(equipos.getPais());
        equiposPorId.setFechaClasificacion(equipos.getFechaClasificacion());
        equiposPorId.setCantidadEventosGanados(equipos.getCantidadEventosGanados());

        Equipos equipos_actualizados = equiposServicio.guardar(equiposPorId);
        return new ResponseEntity<>(equipos_actualizados, HttpStatus.CREATED);

    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEquipos(@PathVariable String id){
        this.equiposServicio.eliminar(id);

        HashMap<String, Boolean> estadoEquiposEliminados = new HashMap<>();
        estadoEquiposEliminados.put("eliminado", true);
        return ResponseEntity.ok(estadoEquiposEliminados);
    }

    @GetMapping("/equipos/no-clasificados/{universidad}")
    public ResponseEntity<List<Object[]>> consultarEquiposNoClasificados(@PathVariable String universidad) {
        List<Object[]> resultado = equiposServicio.equiposRepositorio.consultarEquiposNoClasificados(equiposServicio, universidad);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/equipos/top-universidades/{pais}")
    public ResponseEntity<List<HashMap<String, Object>>> obtenerTop10UniversidadesPorPais(@PathVariable String pais) {
        List<Object[]> resultados = equiposServicio.obtenerTop10UniversidadesPorPais(pais);

        // Convertir los resultados en una lista de mapas para mayor claridad
        List<HashMap<String, Object>> respuesta = new ArrayList<>();
        for (Object[] fila : resultados) {
            HashMap<String, Object> registro = new HashMap<>();
            registro.put("institucion", fila[0]);
            registro.put("pais", fila[1]);
            registro.put("total_eventos_ganados", fila[2]);
            respuesta.add(registro);
        }

        return ResponseEntity.ok(respuesta);
    }

}
