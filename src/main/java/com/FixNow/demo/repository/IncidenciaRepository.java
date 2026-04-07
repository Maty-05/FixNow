package com.FixNow.demo.repository;

import com.FixNow.demo.model.Incidencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Maneja el almacenamiento en memoria de las incidencias.
 */
@Repository
public class IncidenciaRepository {

    private List<Incidencia> lista = new ArrayList<>();
    private Long id = 1L;

    public List<Incidencia> getAll() {
        return lista;
    }

    public Incidencia save(Incidencia i) {
        i.setId(id++);
        lista.add(i);
        return i;
    }

    public Incidencia getById(Long id) {
        for (Incidencia i : lista) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

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

    public void delete(Long id) {
        lista.removeIf(i -> i.getId().equals(id));
    }
}



