package com.upc.api_examen_parcial_20211g034.controller;

import com.upc.api_examen_parcial_20211g034.dtos.TicketDTO;
import com.upc.api_examen_parcial_20211g034.services.IntegranteService;
import com.upc.api_examen_parcial_20211g034.dtos.IntegranteDTO;
import com.upc.api_examen_parcial_20211g034.entities.Integrante;
import com.upc.api_examen_parcial_20211g034.services.IntegranteService;
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
public class IntegranteController {
    @Autowired
    private IntegranteService integranteService;

    @PostMapping("/ncintegrante")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<IntegranteDTO> save(@RequestBody IntegranteDTO integranteDTO){
        ModelMapper modelMapper = new ModelMapper();
        Integrante integrante = modelMapper.map(integranteDTO, Integrante.class);
        integrante = integranteService.save(integrante);
        integranteDTO = modelMapper.map(integrante, IntegranteDTO.class);
        return new ResponseEntity<>(integranteDTO, HttpStatus.OK);
    }
    @GetMapping("/ncintegrantes")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<IntegranteDTO>> list(){
        ModelMapper modelMapper = new ModelMapper();
        List<IntegranteDTO> emp = Arrays.asList(
                modelMapper.map(integranteService.list(),
                        IntegranteDTO[].class));
        return new ResponseEntity<>(emp, HttpStatus.OK);
}
    }