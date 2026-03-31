package com.programacion4.unidad4ej5.feature.socio.validators;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import java.net.URL;

/**
 * Validator annotation to ensure a string is a valid URL
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = URLValidator.URLValidatorImpl.class)
public @interface URLValidator {

    String message() default "La URL no tiene un formato válido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Implementation of the URL validator
     */
    class URLValidatorImpl implements ConstraintValidator<URLValidator, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            // If value is null or empty, it's valid (since it's optional)
            if (value == null || value.isBlank()) {
                return true;
            }

            try {
                new URL(value);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
