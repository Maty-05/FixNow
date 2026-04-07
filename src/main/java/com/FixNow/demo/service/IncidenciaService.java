package com.FixNow.demo.service;

import com.FixNow.demo.model.Incidencia;
import com.FixNow.demo.model.Estado;
import com.FixNow.demo.repository.IncidenciaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio de incidencias.
 */
@Service
public class IncidenciaService {

    private IncidenciaRepository repo;

    public IncidenciaService(IncidenciaRepository repo) {
        this.repo = repo;
    }

    public List<Incidencia> getAll() {
        return repo.getAll();
    }

    public ResponseEntity<?> create(Incidencia i) {

        if (i.getTitulo() == null || i.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo titulo no puede estar vacio\"}");
        }

        if (i.getDescripcion() == null || i.getDescripcion().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo descripcion no puede estar vacio\"}");
        }

        if (i.getUsuarioReportante() == null || i.getUsuarioReportante().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo usuarioReportante no puede estar vacio\"}");
        }

        if (i.getEstado() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Estado no puede ser nulo\"}");
        }

        if (i.getPrioridad() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Prioridad no puede ser nulo\"}");
        }

        i.setFechaRegistro(LocalDate.now());
        return ResponseEntity.status(201).body(repo.save(i));
    }

    public ResponseEntity<?> getById(Long id) {
        Incidencia i = repo.getById(id);

        if (i == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        return ResponseEntity.ok(i);
    }

    public ResponseEntity<?> update(Long id, Incidencia i) {

        if (i.getTitulo() == null || i.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo titulo no puede estar vacio\"}");
        }

        if (i.getDescripcion() == null || i.getDescripcion().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo descripcion no puede estar vacio\"}");
        }

        if (i.getUsuarioReportante() == null || i.getUsuarioReportante().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo usuarioReportante no puede estar vacio\"}");
        }

        if (i.getEstado() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Estado no puede ser nulo\"}");
        }

        if (i.getPrioridad() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Prioridad no puede ser nulo\"}");
        }

        Incidencia actualizada = repo.update(id, i);

        if (actualizada == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        return ResponseEntity.ok(actualizada);
    }

    public ResponseEntity<?> delete(Long id) {
        Incidencia i = repo.getById(id);

        if (i == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        repo.delete(id);
        return ResponseEntity.noContent().build();
    }

    public List<Incidencia> getByEstado(Estado estado) {
        List<Incidencia> lista = new ArrayList<>();

        for (Incidencia i : repo.getAll()) {
            if (i.getEstado() == estado) {
                lista.add(i);
            }
        }

        return lista;
    }
}
