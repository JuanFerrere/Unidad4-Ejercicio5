package com.programacion4.unidad4ej5.feature.plan.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.programacion4.unidad4ej5.feature.plan.dtos.request.PlanCreateDTO;
import com.programacion4.unidad4ej5.feature.plan.dtos.response.PlanResponseDTO;
import com.programacion4.unidad4ej5.feature.plan.service.PlanService;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public ResponseEntity<PlanResponseDTO> crearPlan(@Valid @RequestBody PlanCreateDTO planCreateDTO) {
        PlanResponseDTO planResponseDTO = planService.crearPlan(planCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(planResponseDTO);
    }
}
