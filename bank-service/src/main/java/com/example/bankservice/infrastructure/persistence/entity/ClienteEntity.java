package com.example.bankservice.infrastructure.persistence.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cliente", schema = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {

    @Id
    private UUID id;

    @Column(name = "cliente_id", nullable = false, unique = true)
    private String clienteId;

    @MapsId
    @JoinColumn(name = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private PersonaEntity persona;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean estado;
}