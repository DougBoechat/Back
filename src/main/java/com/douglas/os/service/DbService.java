package com.douglas.os.service;

import java.util.Arrays;

import com.douglas.os.model.Tecnico;
import com.douglas.os.repository.TecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private TecnicoRepository tecnicoRepository; 

    public void instanciaDB(){

        Tecnico t1 = new Tecnico("Douglas", "05797387794", "21222222");
		Tecnico t2 = new Tecnico("Adriana", "05797387794", "21222222");
		Tecnico t3 = new Tecnico("Victor", "05797387794", "21222222");
		Tecnico t4 = new Tecnico("Arthur", "05797387794", "21222222");
		Tecnico t5 = new Tecnico("Izadora", "05797387794", "21222222");
		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));

    }
    
}
