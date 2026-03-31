package com.programacion4.unidad4ej5.feature.socio.controller;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDTO;
import com.programacion4.unidad4ej5.feature.socio.service.SocioService;
import com.programacion4.unidad4ej5.feature.socio.validators.ValidationGroups;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    /**
     * Creates a new socio in the system
     *
     * @param dto the socio creation data
     * @return the created socio with HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<SocioResponseDTO> crearSocio(@Valid @RequestBody SocioCreateDTO dto) {
        try {
            SocioResponseDTO response = socioService.crearSocio(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Updates an existing socio's profile information
     * Uses validation group OnUpdate to enforce ID requirement
     *
     * @param id    the socio ID from URL path
     * @param dto   the socio update data
     * @return the updated socio with HTTP 200 status
     */
    @PutMapping("/{id}")
    @Validated(ValidationGroups.OnUpdate.class)
    public ResponseEntity<SocioResponseDTO> actualizarSocio(
            @PathVariable Long id,
            @Valid @RequestBody SocioUpdateDTO dto) {
        try {
            // Ensure DTO ID matches path ID
            dto.setId(id);
            SocioResponseDTO response = socioService.actualizarSocio(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
