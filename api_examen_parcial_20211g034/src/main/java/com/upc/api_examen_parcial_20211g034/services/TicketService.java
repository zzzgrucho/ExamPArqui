package com.upc.api_examen_parcial_20211g034.services;

import com.upc.api_examen_parcial_20211g034.dtos.SumDTO;
import com.upc.api_examen_parcial_20211g034.entities.Ticket;
import com.upc.api_examen_parcial_20211g034.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Transactional
    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }
    public List<Ticket> list(){
        return ticketRepository.findAll();
    }
    public List<SumDTO> listSumCuota(){
        return ticketRepository.cuotaPorIntegranteDTO();
    }
}
