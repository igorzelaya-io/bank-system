package com.example.bankservice.infrastructure.persistence.repository;

import com.example.bankservice.infrastructure.persistence.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonaJpaRepository extends JpaRepository<PersonaEntity, UUID> {

    boolean existsByIdentificacion(String identificacion);

}
