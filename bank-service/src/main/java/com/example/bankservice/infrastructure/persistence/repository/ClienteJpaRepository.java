package com.example.bankservice.infrastructure.persistence.repository;

import com.example.bankservice.infrastructure.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {

    boolean existsByClienteId(String clienteId);

    Optional<ClienteEntity> findByClienteId(String clienteId);

    void deleteByClienteId(String clienteId);

}
