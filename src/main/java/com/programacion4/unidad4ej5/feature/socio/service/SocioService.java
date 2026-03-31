package com.programacion4.unidad4ej5.feature.socio.service;

import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioCreateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.request.SocioUpdateDTO;
import com.programacion4.unidad4ej5.feature.socio.dtos.response.SocioResponseDTO;
import com.programacion4.unidad4ej5.feature.socio.model.Socio;
import com.programacion4.unidad4ej5.feature.socio.repository.SocioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    /**
     * Creates a new socio from the SocioCreateDTO
     *
     * @param dto the DTO containing the socio data
     * @return the created socio as a SocioResponseDTO
     * @throws IllegalArgumentException if email or DNI already exists
     */
    public SocioResponseDTO crearSocio(SocioCreateDTO dto) {
        // Check if email already exists
        if (socioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya está registrado en el sistema");
        }

        // Check if DNI already exists
        if (socioRepository.findByDni(dto.getDni()).isPresent()) {
            throw new IllegalArgumentException("El DNI ya está registrado en el sistema");
        }

        // Create new Socio entity
        Socio socio = new Socio(
                dto.getNombre(),
                dto.getApellido(),
                dto.getEmail(),
                dto.getDni(),
                dto.getFechaNacimiento(),
                dto.getTelefono()
        );

        // Save to database
        Socio savedSocio = socioRepository.save(socio);

        // Convert to response DTO
        return convertToResponseDTO(savedSocio);
    }

    /**
     * Updates an existing socio with new profile information
     *
     * @param dto the DTO containing the socio update data
     * @return the updated socio as a SocioResponseDTO
     * @throws IllegalArgumentException if socio with ID doesn't exist
     */
    public SocioResponseDTO actualizarSocio(SocioUpdateDTO dto) {
        // Find the socio by ID
        Optional<Socio> existingSocio = socioRepository.findById(dto.getId());
        
        if (existingSocio.isEmpty()) {
            throw new IllegalArgumentException("El socio con ID " + dto.getId() + " no existe en el sistema");
        }

        // Get the existing socio
        Socio socio = existingSocio.get();

        // Update only provided fields
        if (dto.getUrlFoto() != null && !dto.getUrlFoto().isBlank()) {
            socio.setUrlFoto(dto.getUrlFoto());
        }

        if (dto.getAlias() != null && !dto.getAlias().isBlank()) {
            socio.setAlias(dto.getAlias());
        }

        // Save the updated socio
        Socio updatedSocio = socioRepository.save(socio);

        // Convert to response DTO
        return convertToResponseDTO(updatedSocio);
    }

    /**
     * Converts a Socio entity to a SocioResponseDTO
     *
     * @param socio the entity to convert
     * @return the converted DTO
     */
    private SocioResponseDTO convertToResponseDTO(Socio socio) {
        return new SocioResponseDTO(
                socio.getId(),
                socio.getNombre(),
                socio.getApellido(),
                socio.getEmail(),
                socio.getDni(),
                socio.getFechaNacimiento(),
                socio.getTelefono(),
                socio.getFechaRegistro(),
                socio.getUrlFoto(),
                socio.getAlias()
        );
    }
}
