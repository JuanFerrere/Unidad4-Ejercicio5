package com.programacion4.unidad4ej5.feature.plan.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import com.programacion4.unidad4ej5.feature.plan.validators.EjerciciosValidator;
import java.util.List;

public class PlanCreateDTO {

    @NotNull(message = "El ID del socio no puede ser nulo")
    private Long socioId;

    @NotBlank(message = "El objetivo no puede estar vacío")
    @Size(min = 10, max = 200, message = "El objetivo debe tener entre 10 y 200 caracteres")
    private String objetivo;

    @NotNull(message = "La frecuencia semanal no puede ser nula")
    @Min(value = 1, message = "La frecuencia semanal debe ser mínimo 1")
    @Max(value = 7, message = "La frecuencia semanal debe ser máximo 7")
    private Integer frecuenciaSemanal;

    @NotNull(message = "El peso inicial no puede ser nulo")
    @DecimalMin(value = "30.0", message = "El peso inicial debe ser mínimo 30.0 kg")
    @DecimalMax(value = "250.0", message = "El peso inicial debe ser máximo 250.0 kg")
    private Double pesoInicial;

    @NotNull(message = "La altura no puede ser nula")
    @DecimalMin(value = "1.0", message = "La altura debe ser mínimo 1.0 metros")
    @DecimalMax(value = "2.5", message = "La altura debe ser máximo 2.5 metros")
    private Double altura;

    @NotNull(message = "Los ejercicios no pueden ser nulos")
    @Valid
    @EjerciciosValidator
    private List<EjercicioDTO> ejercicios;

    // Constructors
    public PlanCreateDTO() {
    }

    public PlanCreateDTO(Long socioId, String objetivo, Integer frecuenciaSemanal, 
                         Double pesoInicial, Double altura, List<EjercicioDTO> ejercicios) {
        this.socioId = socioId;
        this.objetivo = objetivo;
        this.frecuenciaSemanal = frecuenciaSemanal;
        this.pesoInicial = pesoInicial;
        this.altura = altura;
        this.ejercicios = ejercicios;
    }

    // Getters and Setters
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

    public List<EjercicioDTO> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<EjercicioDTO> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
