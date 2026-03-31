package com.programacion4.unidad4ej5.feature.plan.dtos.response;

public class EjercicioResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer series;
    private Integer repeticiones;

    // Constructors
    public EjercicioResponseDTO() {
    }

    public EjercicioResponseDTO(Long id, String nombre, String descripcion, Integer series, Integer repeticiones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.series = series;
        this.repeticiones = repeticiones;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
