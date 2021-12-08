package com.douglas.reflectit.repository;

import java.time.LocalDate;
import java.util.List;

import com.douglas.reflectit.model.Pagamento;
import com.douglas.reflectit.model.PagamentoId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, PagamentoId> {

    @Query("SELECT to FROM Pagamento to")
    List<Pagamento> findAll();
    
    @Query("SELECT to FROM Pagamento to where to.pagamentoId.idPagamento = :idPagamento and to.pagamentoId.mesCorrente = :mesCorrente")
    Pagamento findByIdAndMesCorrente(@Param("idPagamento") Long idPagamento, @Param("mesCorrente") LocalDate mesCorrente);
}
