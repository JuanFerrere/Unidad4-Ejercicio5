package com.programacion4.unidad4ej5.feature.plan.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EjerciciosValidatorImpl.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EjerciciosValidator {
    String message() default "Debe proporcionar al menos 3 ejercicios";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
