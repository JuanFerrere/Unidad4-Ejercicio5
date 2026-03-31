package com.programacion4.unidad4ej5.feature.plan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.programacion4.unidad4ej5.feature.plan.dtos.request.PlanCreateDTO;
import com.programacion4.unidad4ej5.feature.plan.dtos.request.EjercicioDTO;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.PlanResponseDTO;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.EjercicioResponseDTO;
import com.programacion4.unidad4ej5.feature.plan.model.Plan;
import com.programacion4.unidad4ej5.feature.plan.model.Ejercicio;
import com.programacion4.unidad4ej5.feature.plan.repository.PlanRepository;
import com.programacion4.unidad4ej5.feature.socio.repository.SocioRepository;
import com.programacion4.unidad4ej5.feature.socio.model.Socio;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final SocioRepository socioRepository;

    public PlanService(PlanRepository planRepository, SocioRepository socioRepository) {
        this.planRepository = planRepository;
        this.socioRepository = socioRepository;
    }

    @Transactional
    public PlanResponseDTO crearPlan(PlanCreateDTO planCreateDTO) {
        // Verificar que el socio existe
        Socio socio = socioRepository.findById(planCreateDTO.getSocioId())
                .orElseThrow(() -> new IllegalArgumentException("El socio con ID " + planCreateDTO.getSocioId() + " no existe"));

        // Crear el plan
        Plan plan = new Plan();
        plan.setSocio(socio);
        plan.setObjetivo(planCreateDTO.getObjetivo());
        plan.setFrecuenciaSemanal(planCreateDTO.getFrecuenciaSemanal());
        plan.setPesoInicial(planCreateDTO.getPesoInicial());
        plan.setAltura(planCreateDTO.getAltura());

        // Convertir DTOs de ejercicios a entidades
        List<Ejercicio> ejercicios = planCreateDTO.getEjercicios().stream()
                .map(ejercicioDTO -> {
                    Ejercicio ejercicio = new Ejercicio();
                    ejercicio.setNombre(ejercicioDTO.getNombre());
                    ejercicio.setDescripcion(ejercicioDTO.getDescripcion());
                    ejercicio.setSeries(ejercicioDTO.getSeries());
                    ejercicio.setRepeticiones(ejercicioDTO.getRepeticiones());
                    ejercicio.setPlan(plan);
                    return ejercicio;
                })
                .collect(Collectors.toList());

        plan.setEjercicios(ejercicios);

        // Guardar el plan
        Plan planGuardado = planRepository.save(plan);

        // Convertir a DTO de respuesta
        return convertirPlanAResponseDTO(planGuardado);
    }

    private PlanResponseDTO convertirPlanAResponseDTO(Plan plan) {
        List<EjercicioResponseDTO> ejerciciosDTO = plan.getEjercicios().stream()
                .map(ejercicio -> new EjercicioResponseDTO(
                        ejercicio.getId(),
                        ejercicio.getNombre(),
                        ejercicio.getDescripcion(),
                        ejercicio.getSeries(),
                        ejercicio.getRepeticiones()
                ))
                .collect(Collectors.toList());

        return new PlanResponseDTO(
                plan.getId(),
                plan.getSocio().getId(),
                plan.getObjetivo(),
                plan.getFrecuenciaSemanal(),
                plan.getPesoInicial(),
                plan.getAltura(),
                plan.getPesoActual(),
                plan.getFechaCreacion(),
                ejerciciosDTO
        );
    }
}
