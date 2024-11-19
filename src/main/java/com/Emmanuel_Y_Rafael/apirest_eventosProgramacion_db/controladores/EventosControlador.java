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

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Eventos;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios.EventosServicioImplementacion;

@RestController
@RequestMapping("/api/v1")
public class EventosControlador {

    @Autowired
    EventosServicioImplementacion EventosServicio;

    @GetMapping("/eventos")
    public List<Eventos> obtenerEventos(){
        return EventosServicio.obtenerTodo();
    }

    @PostMapping("/guardar_eventos")
    public ResponseEntity<Eventos> guardarEventos(@RequestBody Eventos eventos){
        Eventos nuevo_Eventos = EventosServicio.guardar(eventos);
        return new ResponseEntity<>(nuevo_Eventos, HttpStatus.CREATED);
    }

    @GetMapping("/eventos/{id}")
    public ResponseEntity<Eventos> obtenerEventosId(@PathVariable Integer id){
        Eventos EventosPorId = EventosServicio.obtenerPorId(id);

        return ResponseEntity.ok(EventosPorId);
    }

    @PutMapping("/eventos/{id}")
    public ResponseEntity<Eventos> actualizar(@PathVariable Integer id, @RequestBody Eventos Eventos){
        Eventos EventosPorId = EventosServicio.obtenerPorId(id);
        EventosPorId.setNombreEvento(Eventos.getNombreEvento());
        EventosPorId.setFechaHora(Eventos.getFechaHora());
        EventosPorId.setLugar(Eventos.getLugar());
        EventosPorId.setEstadoEvento(Eventos.getEstadoEvento());

        Eventos Eventos_actualizados = EventosServicio.guardar(EventosPorId);
        return new ResponseEntity<>(Eventos_actualizados, HttpStatus.CREATED);

    }

    @DeleteMapping("/eventos/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEventos(@PathVariable Integer id){
        this.EventosServicio.eliminar(id);

        HashMap<String, Boolean> estadoEventosEliminados = new HashMap<>();
        estadoEventosEliminados.put("eliminado", true);
        return ResponseEntity.ok(estadoEventosEliminados);
    }

}
