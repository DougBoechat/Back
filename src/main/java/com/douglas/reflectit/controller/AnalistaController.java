package com.douglas.reflectit.controller;
import java.net.URI;
import java.util.List;

import com.douglas.reflectit.model.Analista;
import com.douglas.reflectit.service.AnalistaService;

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
@RequestMapping("/analistas")
public class AnalistaController {

    @Autowired
    private AnalistaService AnalistaService;

    @GetMapping
    public ResponseEntity<List<Analista>> findAllAnalistas() {
        List<Analista> Analistas = AnalistaService.findAllAnalistas();
        return ResponseEntity.ok().body(Analistas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Analista> findById(@PathVariable Integer id) {
        Analista AnalistaResult = AnalistaService.findById(id);
        return ResponseEntity.ok().body(AnalistaResult);
    }

    @PostMapping("/criar")
    public ResponseEntity<Analista> saveAnalista(@RequestBody Analista Analista) {
        Analista AnalistaResult = AnalistaService.saveAnalista(Analista);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(AnalistaResult.getId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Analista> updateById(@PathVariable Integer id, @RequestBody Analista Analista) {
        Analista AnalistaResult = AnalistaService.updateAnalista(id, Analista);
        if (Analista != null){
            return ResponseEntity.ok().body(AnalistaResult);
        } else {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        AnalistaService.deleteAnalista(id);
    }
    
}
