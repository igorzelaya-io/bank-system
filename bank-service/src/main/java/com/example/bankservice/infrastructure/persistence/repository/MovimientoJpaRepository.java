package com.example.bankservice.infrastructure.persistence.repository;

import com.example.bankservice.infrastructure.persistence.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, UUID> { }
