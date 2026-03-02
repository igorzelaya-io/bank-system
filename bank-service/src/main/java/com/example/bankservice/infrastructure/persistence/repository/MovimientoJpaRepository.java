package com.example.bankservice.infrastructure.persistence.repository;

import com.example.bankservice.domain.model.Movimiento;
import com.example.bankservice.infrastructure.persistence.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, UUID> {
    List<Movimiento> findAllByCuentaId(UUID cuentaId);

}
