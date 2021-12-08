package com.douglas.reflectit.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PagamentoId pagamentoId;

    @Column(name = "ID_ANALISTA")
    private Long idAnalista;
    @Column(name = "TAXA")
    private Double taxa;
    @Column(name = "VALOR_HORA_CONTRATO")
    private Double valorHoraContrato;
    @Column(name = "HORAS_FIXAS")
    private int horasFixas;
    @Column(name = "HORAS_TRABALHADAS")
    private Double horasTrabalhadas;
    @Column(name = "HORAS_EXTRAS")
    private Double horasExtras;
    @Column(name = "PAGAMENTO_HORA")
    private Double pagamentoHora;
    @Column(name = "PAGAMENTO_HORA_EXTRA")
    private Double pagamentoHoraExtra;
    @Column(name = "PAGAMENTO")
    private Double pagamento;

}
