package com.programacion4.unidad4ej5.feature.socio.validators;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;
import java.time.Period;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidatorImpl.class)
@Documented
public @interface AgeValidator {
    String message() default "El socio debe tener al menos 18 años";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class AgeValidatorImpl implements ConstraintValidator<AgeValidator, LocalDate> {
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null values are validated by @NotNull
        }
        LocalDate today = LocalDate.now();
        int age = Period.between(value, today).getYears();
        return age >= 18;
    }
}
