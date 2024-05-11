package com.upc.api_examen_parcial_20211g034.services;

import com.upc.api_examen_parcial_20211g034.entities.Integrante;
import com.upc.api_examen_parcial_20211g034.repositories.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IntegranteService {
    @Autowired
    private IntegranteRepository integranteRepository;
    @Transactional
    public Integrante save(Integrante integrante){
        return integranteRepository.save(integrante);
    }
    public List<Integrante> list(){
        return integranteRepository.findAll();
    }
}
