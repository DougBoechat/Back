package com.douglas.reflectit.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PagamentoId implements Serializable{

        private static final long serialVersionUID = 1L;
    
        @Column(name = "ID_PAGAMENTO")
        private Long idPagamento;
        @Column(name = "MES_CORRENTE")
        private LocalDate mesCorrente;
    
}
