package com.programacion4.unidad4ej5.feature.plan.model;

import jakarta.persistence.*;
import com.programacion4.unidad4ej5.feature.socio.model.Socio;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    @Column(nullable = false)
    private String objetivo;

    @Column(name = "frecuencia_semanal", nullable = false)
    private Integer frecuenciaSemanal;

    @Column(name = "peso_inicial", nullable = false)
    private Double pesoInicial;

    @Column(nullable = false)
    private Double altura;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ejercicio> ejercicios;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "peso_actual")
    private Double pesoActual;

    // Constructors
    public Plan() {
    }

    public Plan(Socio socio, String objetivo, Integer frecuenciaSemanal, Double pesoInicial, Double altura, List<Ejercicio> ejercicios) {
        this.socio = socio;
        this.objetivo = objetivo;
        this.frecuenciaSemanal = frecuenciaSemanal;
        this.pesoInicial = pesoInicial;
        this.altura = altura;
        this.ejercicios = ejercicios;
        this.fechaCreacion = LocalDateTime.now();
        this.pesoActual = pesoInicial;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
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

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }
}
