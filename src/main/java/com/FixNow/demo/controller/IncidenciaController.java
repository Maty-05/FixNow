package com.FixNow.demo.controller;

import com.FixNow.demo.model.Incidencia;
import com.FixNow.demo.model.Estado;
import com.FixNow.demo.service.IncidenciaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Controlador REST que expone los endpoints para gestionar incidencias.
 */
@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    private IncidenciaService service;

    public IncidenciaController(IncidenciaService service) {
        this.service = service;
    }

    /**
     * Obtiene todas las incidencias registradas.
     */
    @GetMapping
    public List<Incidencia> getAll() {
        return service.getAll();
    }

    /**
     * Crea una nueva incidencia.
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Incidencia i) {
        return service.create(i);
    }

    /**
     * Obtiene una incidencia por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza los datos de una incidencia existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Incidencia i) {
        return service.update(id, i);
    }

    /**
     * Elimina una incidencia por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * Filtra incidencias según su estado.
     */
    @GetMapping("/estado/{estado}")
    public List<Incidencia> getByEstado(@PathVariable Estado estado) {
        return service.getByEstado(estado);
    }
}