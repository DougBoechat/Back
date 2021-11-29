package com.douglas.reflectit.service;

import java.util.List;

import com.douglas.reflectit.model.Analista;
import com.douglas.reflectit.repository.AnalistaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalistaService {

    @Autowired
    private AnalistaRepository AnalistaRepository;

    public List<Analista> findAllAnalistas(){
        return AnalistaRepository.findAll();
    }

    public Analista saveAnalista(Analista Analista){
        return AnalistaRepository.save(Analista);
    }

    public Analista findById(Integer id){
        return AnalistaRepository.findById(id).get();
    }

    public Analista updateAnalista(Integer id, Analista Analista){
        Analista AnalistaSearch = AnalistaRepository.findById(id).get();
        if (AnalistaSearch != null){
            AnalistaSearch.setNome(Analista.getNome());
            AnalistaSearch.setCpf(Analista.getCpf());
            AnalistaSearch.setTelefone(Analista.getTelefone());
            return AnalistaRepository.save(AnalistaSearch);
        } else {
            return null;
        }
    }

    public void deleteAnalista(Integer id){
        Analista AnalistaSearch = AnalistaRepository.findById(id).get();
        if (AnalistaSearch != null){
            AnalistaRepository.delete(AnalistaSearch);
        } 
    }
    
}
