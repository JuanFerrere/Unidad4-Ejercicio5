package com.programacion4.unidad4ej5.feature.socio.dtos.request;

import jakarta.validation.constraints.*;
import com.programacion4.unidad4ej5.feature.socio.validators.URLValidator;
import com.programacion4.unidad4ej5.feature.socio.validators.NoSpacesValidator;
import com.programacion4.unidad4ej5.feature.socio.validators.ValidationGroups;

/**
 * DTO for updating an existing socio
 * Uses validation groups to have different validations than creation
 */
public class SocioUpdateDTO {

    /**
     * Socio ID - Required only on update
     */
    @NotNull(groups = ValidationGroups.OnUpdate.class, message = "El ID del socio es obligatorio para la actualización")
    @Positive(groups = ValidationGroups.OnUpdate.class, message = "El ID debe ser un número positivo")
    private Long id;

    /**
     * Profile photo URL - Optional, must be valid URL if provided
     */
    @URLValidator(message = "La URL de la foto no tiene un formato válido")
    private String urlFoto;

    /**
     * User alias - Optional, 3-15 characters, no spaces
     */
    @Size(min = 3, max = 15, message = "El alias debe tener entre 3 y 15 caracteres")
    @NoSpacesValidator(message = "El alias no puede contener espacios")
    private String alias;

    // Constructors
    public SocioUpdateDTO() {
    }

    public SocioUpdateDTO(Long id, String urlFoto, String alias) {
        this.id = id;
        this.urlFoto = urlFoto;
        this.alias = alias;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "SocioUpdateDTO{" +
                "id=" + id +
                ", urlFoto='" + urlFoto + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}
