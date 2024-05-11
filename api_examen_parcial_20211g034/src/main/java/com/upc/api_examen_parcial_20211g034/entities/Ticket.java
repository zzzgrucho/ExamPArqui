package com.upc.api_examen_parcial_20211g034.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaEmision;
    private double cuota;
    @ManyToOne
    @JoinColumn(name = "integrante_id")
    private Integrante integrante;
}
