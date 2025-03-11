package com.example.ExamenAdatJCarlos.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Coche coche;

    @Column(nullable = false)
    private LocalDateTime rentalDate;

    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private EstadoAlquiler status;

    @Column(nullable = false)
    private String jclc_modoPago;

    @Column(nullable = false)
    private String jclc_seguro;
}

// Creo el Enum para el estado del alquiler
public enum EstadoAlquiler {
    ACTIVE, COMPLETED
}