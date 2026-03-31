package com.programacion4.unidad4ej5.feature.socio.repository;

import com.programacion4.unidad4ej5.feature.socio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
    Optional<Socio> findByEmail(String email);

    Optional<Socio> findByDni(String dni);
}
