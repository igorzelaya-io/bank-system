package com.example.bankservice.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "persona", schema = "bank")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaEntity {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    private String genero;

    private Integer edad;

    @Column(nullable = false, unique = true)
    private String identificacion;

    private String direccion;

    private String telefono;
}