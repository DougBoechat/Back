package com.douglas.reflectit.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import com.douglas.reflectit.model.Analista;
import com.douglas.reflectit.model.Pagamento;
import com.douglas.reflectit.service.AnalistaService;
import com.douglas.reflectit.service.PagamentoService;

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
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<Pagamento>> findAllAnalistas() {
        List<Pagamento> pagamentos = pagamentoService.findAllPagamentos();
        return ResponseEntity.ok().body(pagamentos);
    }

    @GetMapping("/{id}/{mes}")
    public ResponseEntity<Pagamento> findByIdAndMesCorrente(@PathVariable Long id, @PathVariable LocalDate mes) {
        Pagamento pagamentoResult = pagamentoService.findById(id, mes);
        return ResponseEntity.ok().body(pagamentoResult);
    }

    @PostMapping("/criar")
    public ResponseEntity<Pagamento> savePagamento(@RequestBody Pagamento pagamento) {
        Pagamento pagamentoResult = pagamentoService.savePagamento(pagamento);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(pagamentoResult.getPagamentoId()).toUri();
        
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> updateByIdAndMesCorrente(@PathVariable Long id, @PathVariable LocalDate mes, @RequestBody Pagamento pagamento) {
        Pagamento pagamentoResult = pagamentoService.updatePagamento(id, mes, pagamento);
        if (pagamento != null){
            return ResponseEntity.ok().body(pagamentoResult);
        } else {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id, @PathVariable LocalDate mes) {
        pagamentoService.deletePagamento(id, mes);
    }
    
}
