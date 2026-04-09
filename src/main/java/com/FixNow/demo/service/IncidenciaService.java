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
 * Contiene la lógica de negocio para la gestión de las incidencias.
 */

@Service
public class IncidenciaService {

    private IncidenciaRepository repo;

    public IncidenciaService(IncidenciaRepository repo) {
        this.repo = repo;
    }

    /**
     * Esta retorna todas las incidencias.
     */
    public List<Incidencia> getAll() {
        return repo.getAll();
    }

    /**
     * Esta valida y crea una nueva incidencia.
     */
    public ResponseEntity<?> create(Incidencia incidencia) {

        // Validaciones básicas de entrada

        if (incidencia.getTitulo() == null || incidencia.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo titulo no puede estar vacio\"}");
        }

        if (incidencia.getDescripcion() == null || incidencia.getDescripcion().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo descripcion no puede estar vacio\"}");
        }

        if (incidencia.getUsuarioReportante() == null || incidencia.getUsuarioReportante().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo usuarioReportante no puede estar vacio\"}");
        }

        if (incidencia.getEstado() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Estado no puede ser nulo\"}");
        }

        if (incidencia.getPrioridad() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Prioridad no puede ser nulo\"}");
        }

        // Se le asigna automáticamente la fecha actual

        incidencia.setFechaRegistro(LocalDate.now());
        return ResponseEntity.status(201).body(repo.save(incidencia));
    }

    /**
     * Busca una incidencia por la ID.
     */

    public ResponseEntity<?> getById(Long id) {
        Incidencia incidencia = repo.getById(id);

        if (incidencia == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        return ResponseEntity.ok(incidencia);
    }

    /**
     * Esta valida y actualiza una incidencia existente.
     */

    public ResponseEntity<?> update(Long id, Incidencia incidencia) {

        // Validaciones muy básicas

        if (incidencia.getTitulo() == null || incidencia.getTitulo().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo titulo no puede estar vacio\"}");
        }

        if (incidencia.getDescripcion() == null || incidencia.getDescripcion().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo descripcion no puede estar vacio\"}");
        }

        if (incidencia.getUsuarioReportante() == null || incidencia.getUsuarioReportante().isBlank()) {
            return ResponseEntity.badRequest().body("{\"error\":\"El campo usuarioReportante no puede estar vacio\"}");
        }

        if (incidencia.getEstado() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Estado no puede ser nulo\"}");
        }

        if (incidencia.getPrioridad() == null) {
            return ResponseEntity.badRequest().body("{\"error\":\"Prioridad no puede ser nulo\"}");
        }

        Incidencia actualizada = repo.update(id, incidencia);

        if (actualizada == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        return ResponseEntity.ok(actualizada);
    }

    /**
     * Esta elimina una incidencia si existe.
     */

    public ResponseEntity<?> delete(Long id) {
        Incidencia incidencia = repo.getById(id);

        if (incidencia == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        repo.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Esta filtra incidencias por estado.
     */

    public List<Incidencia> getByEstado(Estado estado) {
        List<Incidencia> lista = new ArrayList<>();

        for (Incidencia incidencia : repo.getAll()) {
            if (incidencia.getEstado() == estado) {
                lista.add(incidencia);
            }
        }

        return lista;
    }
}