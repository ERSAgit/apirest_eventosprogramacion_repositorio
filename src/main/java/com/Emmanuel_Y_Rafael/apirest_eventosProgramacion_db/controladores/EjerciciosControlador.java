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

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Ejercicios;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios.EjerciciosServicioImplementacion;

@RestController
@RequestMapping("/api/v1")
public class EjerciciosControlador {

    @Autowired
    EjerciciosServicioImplementacion EjerciciosServicio;

    @GetMapping("/ejercicios")
    public List<Ejercicios> obtenerEjercicios(){
        return EjerciciosServicio.obtenerTodo();
    }

    @PostMapping("/guardar_ejercicios")
    public ResponseEntity<Ejercicios> guardarEjercicios(@RequestBody Ejercicios Ejercicios){
        Ejercicios nuevo_Ejercicios = EjerciciosServicio.guardar(Ejercicios);
        return new ResponseEntity<>(nuevo_Ejercicios, HttpStatus.CREATED);
    }

    @GetMapping("/ejercicios/{id}")
    public ResponseEntity<Ejercicios> obtenerEjerciciosId(@PathVariable String id){
        Ejercicios EjerciciosPorId = EjerciciosServicio.obtenerPorId(id);

        return ResponseEntity.ok(EjerciciosPorId);
    }

    @PutMapping("/ejercicios/{id}")
    public ResponseEntity<Ejercicios> actualizar(@PathVariable String id, @RequestBody Ejercicios Ejercicios){
        Ejercicios EjerciciosPorId = EjerciciosServicio.obtenerPorId(id);
        EjerciciosPorId.setIdEjercicio(Ejercicios.getIdEjercicio());
        EjerciciosPorId.setNombreEjercicio(Ejercicios.getNombreEjercicio());
        EjerciciosPorId.setTiempoLimite(Ejercicios.getTiempoLimite());
        EjerciciosPorId.setPuntos(Ejercicios.getPuntos());
        EjerciciosPorId.setIdCategoria(Ejercicios.getIdCategoria());

        Ejercicios Ejercicios_actualizados = EjerciciosServicio.guardar(EjerciciosPorId);
        return new ResponseEntity<>(Ejercicios_actualizados, HttpStatus.CREATED);

    }

    @DeleteMapping("/ejercicios/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEjercicios(@PathVariable String id){
        this.EjerciciosServicio.eliminar(id);

        HashMap<String, Boolean> estadoEjerciciosEliminados = new HashMap<>();
        estadoEjerciciosEliminados.put("eliminado", true);
        return ResponseEntity.ok(estadoEjerciciosEliminados);
    }

}
