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

import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.modelos.Categorias;
import com.Emmanuel_Y_Rafael.apirest_eventosProgramacion_db.servicios.CategoriasServicioImplementacion;

@RestController
@RequestMapping("/api/v1")
public class CategoriasControlador {

    @Autowired
    CategoriasServicioImplementacion CategoriasServicio;

    @GetMapping("/categorias")
    public List<Categorias> obtenerCategorias(){
        return CategoriasServicio.obtenerTodo();
    }

    @PostMapping("/guardar_categorias")
    public ResponseEntity<Categorias> guardarCategorias(@RequestBody Categorias Categorias){
        Categorias nuevo_Categorias = CategoriasServicio.guardar(Categorias);
        return new ResponseEntity<>(nuevo_Categorias, HttpStatus.CREATED);
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categorias> obtenerCategoriasId(@PathVariable String id){
        Categorias CategoriasPorId = CategoriasServicio.obtenerPorId(id);

        return ResponseEntity.ok(CategoriasPorId);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categorias> actualizar(@PathVariable String id, @RequestBody Categorias Categorias){
        Categorias CategoriasPorId = CategoriasServicio.obtenerPorId(id);
        CategoriasPorId.setIdCategoria(Categorias.getIdCategoria());
        CategoriasPorId.setNombreCategoria(Categorias.getNombreCategoria());
        CategoriasPorId.setNivel(Categorias.getNivel());
        CategoriasPorId.setIdEvento(Categorias.getIdEvento());

        Categorias Categorias_actualizados = CategoriasServicio.guardar(CategoriasPorId);
        return new ResponseEntity<>(Categorias_actualizados, HttpStatus.CREATED);

    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarCategorias(@PathVariable String id){
        this.CategoriasServicio.eliminar(id);

        HashMap<String, Boolean> estadoCategoriasEliminados = new HashMap<>();
        estadoCategoriasEliminados.put("eliminado", true);
        return ResponseEntity.ok(estadoCategoriasEliminados);
    }

}
