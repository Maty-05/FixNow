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
 * Contiene la lógica de negocio para la gestión de incidencias.
 */
@Service
public class IncidenciaService {

    private IncidenciaRepository repo;

    public IncidenciaService(IncidenciaRepository repo) {
        this.repo = repo;
    }

    /**
     * Retorna todas las incidencias.
     */
    public List<Incidencia> getAll() {
        return repo.getAll();
    }

    /**
     * Valida y crea una nueva incidencia.
     */
    public ResponseEntity<?> create(Incidencia i) {

        // Validaciones básicas de entrada
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

        // Se asigna automáticamente la fecha actual
        i.setFechaRegistro(LocalDate.now());
        return ResponseEntity.status(201).body(repo.save(i));
    }

    /**
     * Busca una incidencia por ID.
     */
    public ResponseEntity<?> getById(Long id) {
        Incidencia i = repo.getById(id);

        if (i == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        return ResponseEntity.ok(i);
    }

    /**
     * Valida y actualiza una incidencia existente.
     */
    public ResponseEntity<?> update(Long id, Incidencia i) {

        // Validaciones básicas
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

    /**
     * Elimina una incidencia si existe.
     */
    public ResponseEntity<?> delete(Long id) {
        Incidencia i = repo.getById(id);

        if (i == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        repo.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Filtra incidencias por estado.
     */
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