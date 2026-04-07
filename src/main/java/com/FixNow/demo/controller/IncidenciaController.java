package com.FixNow.demo.controller;

import com.FixNow.demo.model.Incidencia;
import com.FixNow.demo.model.Estado;
import com.FixNow.demo.service.IncidenciaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Controlador que expone los endpoints REST.
 */
@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    private IncidenciaService service;

    public IncidenciaController(IncidenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Incidencia> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Incidencia i) {
        return service.create(i);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Incidencia i) {
        return service.update(id, i);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Incidencia> getByEstado(@PathVariable Estado estado) {
        return service.getByEstado(estado);
    }
}
