package com.programacion4.unidad4ej5.feature.plan.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.programacion4.unidad4ej5.feature.plan.dtos.request.EjercicioDTO;
import java.util.List;

public class EjerciciosValidatorImpl implements ConstraintValidator<EjerciciosValidator, List<EjercicioDTO>> {

    private static final int MIN_EJERCICIOS = 3;

    @Override
    public void initialize(EjerciciosValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(List<EjercicioDTO> value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.size() >= MIN_EJERCICIOS;
    }
}
