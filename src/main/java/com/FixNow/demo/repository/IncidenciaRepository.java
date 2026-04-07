package com.FixNow.demo.repository;

import com.FixNow.demo.model.Incidencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio encargado de gestionar el almacenamiento en memoria
 * de las incidencias. Esta simula una base de datos usando una lista.
 */
@Repository
public class IncidenciaRepository {

    private List<Incidencia> lista = new ArrayList<>();
    private Long id = 1L;


     // Retorna todas y cada una de las incidencias almacenadas.

    public List<Incidencia> getAll() {
        return lista;
    }

     // Esta guarda una nueva incidencia en la lista.
     // Ademas asigna automáticamente un ID incremental.

    public Incidencia save(Incidencia incidencia) {
        incidencia.setId(id++);
        lista.add(incidencia);
        return incidencia;
    }


     // Se encarga de buscar a una incidencia por su ID.

    public Incidencia getById(Long id) {
        for (Incidencia incidencia : lista) {
            if (incidencia.getId().equals(id)) {
                return incidencia;
            }
        }
        return null;
    }


     // Se encarga de eliminar a una incidencia según su ID.

    public void delete(Long id) {
        lista.removeIf(incidencia -> incidencia.getId().equals(id));
    }
}
