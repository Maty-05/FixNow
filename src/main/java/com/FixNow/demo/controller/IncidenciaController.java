package com.FixNow.demo.controller;

import com.FixNow.demo.model.Incidencia;
import com.FixNow.demo.model.Estado;
import com.FixNow.demo.service.IncidenciaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * El controlador "REST" que expone los endpoints para gestionar incidencias.
 */

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    private IncidenciaService service;

    public IncidenciaController(IncidenciaService service) {
        this.service = service;
    }

    /**
     * Este obtiene todas las incidencias registradas.
     */

    @GetMapping
    public List<Incidencia> getAll() {
        return service.getAll();
    }

    /**
     * Este crea una nueva incidencia.
     */

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Incidencia incidencia) {
        return service.create(incidencia);
    }

    /**
     * Este obtiene una incidencia gracias a su ID.
     */

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Este actualiza los datos de una incidencia que ya existe (una incidencia existente).
     */

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Incidencia incidencia) {
        return service.update(id, incidencia);
    }

    /**
     * Esta elimina una incidencia gracias a su ID.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    /**
     * Y por ultimo esta filtra incidencias según su estado (ABIERTA, EN_PROCESO, RESUELTA O CERRADA).
     */

    @GetMapping("/estado/{estado}")
    public List<Incidencia> getByEstado(@PathVariable Estado estado) {
        return service.getByEstado(estado);
    }
}