package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import com.programacion4.unidad4ej5.feature.socio.validators.DNIValidator;
import com.programacion4.unidad4ej5.feature.socio.validators.AgeValidator;

public class SocioCreateDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotBlank(message = "El DNI no puede estar vacío")
    @DNIValidator(message = "El DNI debe ser una cadena de exactamente 8 dígitos numéricos")
    private String dni;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @PastOrPresent(message = "La fecha de nacimiento debe ser una fecha pasada")
    @AgeValidator(message = "El socio debe tener al menos 18 años")
    private java.time.LocalDate fechaNacimiento;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+549\\d{9,10}$", message = "El teléfono debe seguir el formato internacional (ej: +549...)")
    private String telefono;

    // Constructors
    public SocioCreateDTO() {
    }

    public SocioCreateDTO(String nombre, String apellido, String email, String dni, java.time.LocalDate fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public java.time.LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(java.time.LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
