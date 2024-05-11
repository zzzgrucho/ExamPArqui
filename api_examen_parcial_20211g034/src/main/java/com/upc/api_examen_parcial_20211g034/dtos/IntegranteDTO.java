package com.upc.api_examen_parcial_20211g034.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteDTO {
    private Long id;
    private String name;
    private String dni;
    private String email;
    private LocalDate fechaNacimiento;
}
