package com.douglas.os.service;

import java.util.List;

import com.douglas.os.model.Tecnico;
import com.douglas.os.repository.TecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> findAllTecnicos(){
        return tecnicoRepository.findAll();
    }

    public Tecnico saveTecnico(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);
    }

    public Tecnico findById(Integer id){
        return tecnicoRepository.findById(id).get();
    }

    public Tecnico updateTecnico(Integer id, Tecnico tecnico){
        Tecnico tecnicoSearch = tecnicoRepository.findById(id).get();
        if (tecnicoSearch != null){
            tecnicoSearch.setNome(tecnico.getNome());
            tecnicoSearch.setCpf(tecnico.getCpf());
            tecnicoSearch.setTelefone(tecnico.getTelefone());
            return tecnicoRepository.save(tecnicoSearch);
        } else {
            return null;
        }
    }

    public void deleteTecnico(Integer id){
        Tecnico tecnicoSearch = tecnicoRepository.findById(id).get();
        if (tecnicoSearch != null){
            tecnicoRepository.delete(tecnicoSearch);
        } 
    }
    
}
