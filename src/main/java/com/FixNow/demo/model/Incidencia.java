package com.FixNow.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Modelo que representa una incidencia dentro del sistema.
 * Contiene la información principal reportada por un usuario.
 */
public class Incidencia {

    private Long id;

    /**
     * Título breve de la incidencia.
     * No puede estar vacío y tiene un máximo de 100 caracteres.
     */
    @NotBlank
    @Size(max = 100)
    private String titulo;

    /**
     * Descripción detallada del problema reportado.
     */
    @NotBlank
    private String descripcion;

    /**
     * Estado actual de la incidencia (flujo de trabajo).
     */
    @NotNull
    private Estado estado;

    /**
     * Nivel de prioridad de la incidencia.
     */
    @NotNull
    private Prioridad prioridad;

    /**
     * Usuario que reporta la incidencia.
     */
    @NotBlank
    private String usuarioReportante;

    /**
     * Fecha en que se registra la incidencia en el sistema.
     */
    private LocalDate fechaRegistro;

    public Incidencia() {}

    // Getters y setters

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