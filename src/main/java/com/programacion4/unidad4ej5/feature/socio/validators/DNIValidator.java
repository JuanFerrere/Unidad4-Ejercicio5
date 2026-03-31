package com.programacion4.unidad4ej5.feature.socio.validators;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DNIValidatorImpl.class)
@Documented
public @interface DNIValidator {
    String message() default "El DNI debe ser una cadena de exactamente 8 dígitos numéricos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class DNIValidatorImpl implements ConstraintValidator<DNIValidator, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null values are validated by @NotNull
        }
        // Must be exactly 8 digits
        return value.matches("^\\d{8}$");
    }
}
