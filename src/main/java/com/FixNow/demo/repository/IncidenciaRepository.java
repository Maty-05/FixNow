package com.FixNow.demo.repository;

import com.FixNow.demo.model.Incidencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Simula una base de datos en memoria para almacenar incidencias.
 */
@Repository
public class IncidenciaRepository {

    private List<Incidencia> lista = new ArrayList<>();
    private Long id = 1L;

    /**
     * Retorna todas las incidencias almacenadas.
     */
    public List<Incidencia> getAll() {
        return lista;
    }

    /**
     * Guarda una nueva incidencia asignándole un ID único.
     */
    public Incidencia save(Incidencia incidencia) {
        incidencia.setId(id++);
        lista.add(incidencia);
        return incidencia;
    }

    /**
     * Busca una incidencia por su ID.
     */
    public Incidencia getById(Long id) {
        for (Incidencia incidencia : lista) {
            if (incidencia.getId().equals(id)) {
                return incidencia;
            }
        }
        return null;
    }

    /**
     * Actualiza los datos de una incidencia existente.
     */
    public Incidencia update(Long id, Incidencia nueva) {
        Incidencia existente = getById(id);

        if (existente != null) {
            existente.setTitulo(nueva.getTitulo());
            existente.setDescripcion(nueva.getDescripcion());
            existente.setEstado(nueva.getEstado());
            existente.setPrioridad(nueva.getPrioridad());
            existente.setUsuarioReportante(nueva.getUsuarioReportante());
            return existente;
        }

        return null;
    }

    /**
     * Elimina una incidencia según su ID.
     */
    public void delete(Long id) {
        lista.removeIf(incidencia -> incidencia.getId().equals(id));
    }
}