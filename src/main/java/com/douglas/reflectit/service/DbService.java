package com.douglas.reflectit.service;

import java.util.Arrays;

import com.douglas.reflectit.model.Analista;
import com.douglas.reflectit.repository.AnalistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private AnalistaRepository AnalistaRepository; 

    public void instanciaDB(){

        Analista t1 = new Analista("Douglas", "05797387794", "21222222", 8000);
		Analista t2 = new Analista("Adriana", "05797387794", "21222222", 8000);
		Analista t3 = new Analista("Victor", "05797387794", "21222222", 8000);
		Analista t4 = new Analista("Arthur", "05797387794", "21222222", 8000);
		Analista t5 = new Analista("Izadora", "05797387794", "21222222", 8000);
		AnalistaRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));

    }
    
}
