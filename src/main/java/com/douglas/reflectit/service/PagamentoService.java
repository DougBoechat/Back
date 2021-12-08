package com.douglas.reflectit.service;

import java.time.LocalDate;
import java.util.List;

import com.douglas.reflectit.model.Pagamento;
import com.douglas.reflectit.repository.PagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> findAllPagamentos(){
        return pagamentoRepository.findAll();
    }

    public Pagamento savePagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento findById(Long id, LocalDate mesCorrente){
        return pagamentoRepository.findByIdAndMesCorrente(id, mesCorrente);
    }

    public Pagamento updatePagamento(Long id, LocalDate mesCorrente, Pagamento pagamento){
        Pagamento pagamentoSearch = pagamentoRepository.findByIdAndMesCorrente(id, mesCorrente);
        if (pagamentoSearch != null){
            pagamentoSearch.setTaxa(pagamento.getTaxa());
            pagamentoSearch.setValorHoraContrato(pagamento.getValorHoraContrato());
            pagamentoSearch.setPagamentoHoraExtra(pagamento.getPagamentoHoraExtra());
            pagamentoSearch.setPagamento(pagamento.getPagamento());
            pagamentoSearch.setHorasTrabalhadas(pagamento.getHorasTrabalhadas());
            pagamentoSearch.setHorasFixas(pagamento.getHorasFixas());
            pagamentoSearch.setHorasExtras(pagamento.getHorasExtras());
            return pagamentoRepository.save(pagamentoSearch);
        } else {
            return null;
        }
    }

    public void deletePagamento(Long id, LocalDate mesCorrente){
        Pagamento pagamentoSearch = pagamentoRepository.findByIdAndMesCorrente(id, mesCorrente);
        if (pagamentoSearch != null){
            pagamentoRepository.delete(pagamentoSearch);
        } 
    }
    
}
