package com.programacion4.unidad4ej5.feature.pago.repository;

import com.programacion4.unidad4ej5.feature.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    Optional<Pago> findByCodigoTransaccion(String codigoTransaccion);

}
