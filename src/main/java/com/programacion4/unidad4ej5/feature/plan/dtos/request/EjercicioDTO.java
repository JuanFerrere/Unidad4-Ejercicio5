package com.programacion4.unidad4ej5.feature.plan.dtos.request;

import jakarta.validation.constraints.*;

public class EjercicioDTO {

    @NotBlank(message = "El nombre del ejercicio no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La descripción del ejercicio no puede estar vacía")
    private String descripcion;

    @NotNull(message = "Las series no pueden ser nulas")
    @Min(value = 1, message = "Las series deben ser al menos 1")
    @Max(value = 100, message = "Las series no pueden exceder 100")
    private Integer series;

    @NotNull(message = "Las repeticiones no pueden ser nulas")
    @Min(value = 1, message = "Las repeticiones deben ser al menos 1")
    @Max(value = 100, message = "Las repeticiones no pueden exceder 100")
    private Integer repeticiones;

    // Constructors
    public EjercicioDTO() {
    }

    public EjercicioDTO(String nombre, String descripcion, Integer series, Integer repeticiones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }
}
