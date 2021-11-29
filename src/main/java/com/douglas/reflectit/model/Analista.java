package com.douglas.reflectit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Analista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "SALARIO")
    private double salario;


    public Analista(){
        super();
    }

    public Analista(String nome, String cpf, String telefone, double salario) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.salario = salario;

    }
    
}
