package com.FixNow.demo.service;

import com.FixNow.demo.model.Incidencia;
import com.FixNow.demo.model.Estado;
import com.FixNow.demo.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * El servicio que contiene la lógica de negocio para la gestión de incidencias.
 * Este coordina las operaciones entre el Controlador y el Repositorio.
 */
@Service
public class IncidenciaService {

    private IncidenciaRepository repo;

    public IncidenciaService(IncidenciaRepository repo) {
        this.repo = repo;
    }


     // Esta obtiene todas las incidencias registradas en el sistema.

    public List<Incidencia> getAll() {
        return repo.getAll();
    }

    /**
     * Registra una nueva incidencia en el sistema.
     * Ademas que valida que los campos obligatorios no estén vacíos y asigna le asigna la fecha automáticamente.
     */
    public ResponseEntity<?> create(Incidencia incidencia) {

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

        incidencia.setFechaRegistro(LocalDate.now());
        return ResponseEntity.status(201).body(repo.save(incidencia));
    }

     // Busca una incidencia por su ID, en el caso de no encontrarla te manda el mensaje de "Incidencia no encontrada".

    public ResponseEntity<?> getById(Long id) {
        Incidencia incidencia = repo.getById(id);

        if (incidencia == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }
        return ResponseEntity.ok(incidencia);
    }


     // Elimina una incidencia por su ID, en el caso de no encontrarla te manda el mensaje de "Incidencia no encontrada".

    public ResponseEntity<?> delete(Long id) {
        Incidencia incidencia = repo.getById(id);

        if (incidencia == null) {
            return ResponseEntity.status(404).body("{\"error\":\"Incidencia no encontrada\"}");
        }

        repo.delete(id);
        return ResponseEntity.noContent().build();
    }


      // Esta filtra incidencias según su estado (ABIERTA, EN_PROCESO, RESUELTA, CERRADA) respectivamente.

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

