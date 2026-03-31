package com.programacion4.unidad4ej5.feature.socio.validators;

import jakarta.validation.groups.Default;

/**
 * Validation groups for Socio DTOs
 * Allows different validation rules for creation vs update operations
 */
public class ValidationGroups {

    /**
     * Group for creation operations
     * Used when validating SocioCreateDTO
     */
    public interface OnCreate {
    }

    /**
     * Group for update operations
     * Used when validating SocioUpdateDTO
     */
    public interface OnUpdate {
    }
}
