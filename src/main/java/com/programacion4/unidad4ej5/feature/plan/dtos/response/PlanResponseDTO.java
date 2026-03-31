package com.programacion4.unidad4ej5.feature.plan.dtos.response;

import java.time.LocalDateTime;
import java.util.List;

public class PlanResponseDTO {

    private Long id;
    private Long socioId;
    private String objetivo;
    private Integer frecuenciaSemanal;
    private Double pesoInicial;
    private Double altura;
    private Double pesoActual;
    private LocalDateTime fechaCreacion;
    private List<EjercicioResponseDTO> ejercicios;

    // Constructors
    public PlanResponseDTO() {
    }

    public PlanResponseDTO(Long id, Long socioId, String objetivo, Integer frecuenciaSemanal,
                          Double pesoInicial, Double altura, Double pesoActual, 
                          LocalDateTime fechaCreacion, List<EjercicioResponseDTO> ejercicios) {
        this.id = id;
        this.socioId = socioId;
        this.objetivo = objetivo;
        this.frecuenciaSemanal = frecuenciaSemanal;
        this.pesoInicial = pesoInicial;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.fechaCreacion = fechaCreacion;
        this.ejercicios = ejercicios;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSocioId() {
        return socioId;
    }

    public void setSocioId(Long socioId) {
        this.socioId = socioId;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getFrecuenciaSemanal() {
        return frecuenciaSemanal;
    }

    public void setFrecuenciaSemanal(Integer frecuenciaSemanal) {
        this.frecuenciaSemanal = frecuenciaSemanal;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<EjercicioResponseDTO> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<EjercicioResponseDTO> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
