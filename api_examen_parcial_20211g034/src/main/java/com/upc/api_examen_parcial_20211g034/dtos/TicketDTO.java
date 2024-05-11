package com.upc.api_examen_parcial_20211g034.dtos;

import com.upc.api_examen_parcial_20211g034.entities.Integrante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private Long id;
    private LocalDate fechaEmision;
    private double cuota;
    private Integrante integrante;
}
