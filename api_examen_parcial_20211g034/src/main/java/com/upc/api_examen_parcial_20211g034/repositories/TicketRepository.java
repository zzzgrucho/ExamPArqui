package com.upc.api_examen_parcial_20211g034.repositories;

import com.upc.api_examen_parcial_20211g034.dtos.SumDTO;
import com.upc.api_examen_parcial_20211g034.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select sum(e.cuota), e.integrante.name from Ticket e group by e.integrante")
    List<Object[]> cuotaPorIntegrante();
    @Query("select new com.upc.api_examen_parcial_20211g034.dtos.SumDTO(sum(e.cuota), e.integrante.name)" +
            "  from Ticket e group by e.integrante")
    List<SumDTO> cuotaPorIntegranteDTO();
}
