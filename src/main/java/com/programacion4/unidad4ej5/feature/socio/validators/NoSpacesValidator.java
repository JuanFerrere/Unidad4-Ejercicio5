package com.programacion4.unidad4ej5.feature.socio.validators;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * Validator annotation to ensure an alias doesn't contain spaces
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoSpacesValidator.NoSpacesValidatorImpl.class)
public @interface NoSpacesValidator {

    String message() default "El alias no puede contener espacios";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Implementation of the no-spaces validator
     */
    class NoSpacesValidatorImpl implements ConstraintValidator<NoSpacesValidator, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            // If value is null or empty, it's valid (since it's optional)
            if (value == null || value.isBlank()) {
                return true;
            }

            // Check if it contains spaces
            return !value.contains(" ");
        }
    }
}
