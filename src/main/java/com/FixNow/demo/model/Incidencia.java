package com.FixNow.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class Incidencia {

    private Long id;

    /**
     * Empleo validaciones para titulo, descripcion, estado, prioridad y usuarioReportante
     * para que no hallan espacios en blanco o vacios.
     */

    @NotBlank
    @Size(max = 100)
    private String titulo;

    @NotBlank
    private String descripcion;

    @NotNull
    private Estado estado;

    @NotNull
    private Prioridad prioridad;

    @NotBlank
    private String usuarioReportante;

    private LocalDate fechaRegistro;

    public Incidencia() {}

    /**
     * Hago los Getters y Setters de cada uno de los siguientes:
     * (id, titulo, descripcion, estado, prioridad, usuarioReportante y fechaRegistro).
     */

    public Long getId() {
        return id; }

    public void setId(Long id) {
        this.id = id; }

    public String getTitulo() {
        return titulo; }

    public void setTitulo(String titulo) {
        this.titulo = titulo; }

    public String getDescripcion() {
        return descripcion; }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; }

    public Estado getEstado() {
        return estado; }

    public void setEstado(Estado estado) {
        this.estado = estado; }

    public Prioridad getPrioridad() {
        return prioridad; }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad; }

    public String getUsuarioReportante() {
        return usuarioReportante; }

    public void setUsuarioReportante(String usuarioReportante) {
        this.usuarioReportante = usuarioReportante; }

    public LocalDate getFechaRegistro() {
        return fechaRegistro; }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro; }
}

