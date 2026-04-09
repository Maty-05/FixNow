package com.FixNow.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * El modelo que representa una incidencia dentro del sistema.
 * Este contiene la información principal reportada por un usuario.
 */
public class Incidencia {

    private Long id;

    /**
     * El título breve de la incidencia.
     * No puede estar vacío y tiene un máximo de unos 100 caracteres.
     */

    @NotBlank
    @Size(max = 100)
    private String titulo;

    /**
     * Una descripción detallada del problema reportado.
     */

    @NotBlank
    private String descripcion;

    /**
     * El estado actual de la incidencia.
     */

    @NotNull
    private Estado estado;

    /**
     * El nivel de prioridad de la incidencia.
     */

    @NotNull
    private Prioridad prioridad;

    /**
     * El usuario que reporta la incidencia.
     */

    @NotBlank
    private String usuarioReportante;

    /**
     * La fecha en que se registra la incidencia en el sistema.
     */

    private LocalDate fechaRegistro;

    public Incidencia() {}

    // Los Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getUsuarioReportante() {
        return usuarioReportante;
    }

    public void setUsuarioReportante(String usuarioReportante) {
        this.usuarioReportante = usuarioReportante;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}