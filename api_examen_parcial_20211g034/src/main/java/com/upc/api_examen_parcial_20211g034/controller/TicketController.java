package com.upc.api_examen_parcial_20211g034.controller;

import com.upc.api_examen_parcial_20211g034.dtos.TicketDTO;
import com.upc.api_examen_parcial_20211g034.dtos.SumDTO;
import com.upc.api_examen_parcial_20211g034.entities.Ticket;
import com.upc.api_examen_parcial_20211g034.services.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ncapi")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/ncticket")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<TicketDTO> save(@RequestBody TicketDTO ticketDTO){
        ModelMapper modelMapper = new ModelMapper();
        Ticket ticket = modelMapper.map(ticketDTO, Ticket.class);
        ticket = ticketService.save(ticket);
        ticketDTO = modelMapper.map(ticket, TicketDTO.class);
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }
    @GetMapping("/nctickets")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<TicketDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<TicketDTO> emp = Arrays.asList(
                modelMapper.map(ticketService.list(),
                TicketDTO[].class));
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @GetMapping("/ncticketCuotaPorIntegrante")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<SumDTO>> listSumCuota(){
        return new ResponseEntity<>(ticketService.listSumCuota(), HttpStatus.OK);
    }

}
