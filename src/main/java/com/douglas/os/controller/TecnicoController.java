package com.douglas.os.controller;

import java.net.URI;
import java.util.List;

import com.douglas.os.model.Tecnico;
import com.douglas.os.service.TecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public ResponseEntity<List<Tecnico>> findAllTecnicos() {
        List<Tecnico> tecnicos = tecnicoService.findAllTecnicos();
        return ResponseEntity.ok().body(tecnicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id) {
        Tecnico tecnicoResult = tecnicoService.findById(id);
        return ResponseEntity.ok().body(tecnicoResult);
    }

    @PostMapping("/criar")
    public ResponseEntity<Tecnico> saveTecnico(@RequestBody Tecnico tecnico) {
        Tecnico tecnicoResult = tecnicoService.saveTecnico(tecnico);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(tecnicoResult.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> updateById(@PathVariable Integer id, @RequestBody Tecnico tecnico) {
        Tecnico tecnicoResult = tecnicoService.updateTecnico(id, tecnico);
        if (tecnico != null){
            return ResponseEntity.ok().body(tecnicoResult);
        } else {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        tecnicoService.deleteTecnico(id);
    }
    
    
}
