package com.example.ExamenAdatJCarlos.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="coche")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String platenumber;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private boolean avalible;

    @Column(nullable = false)
    private String jclc_coor;

    @Column(nullable = false)
    private String jclc_cilindrada;
}
