package com.douglas.reflectit.repository;

import java.util.List;

import com.douglas.reflectit.model.Analista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalistaRepository extends JpaRepository <Analista, Integer> {

    @Query("SELECT to FROM Analista to")
    List<Analista> findAll();
    
}
