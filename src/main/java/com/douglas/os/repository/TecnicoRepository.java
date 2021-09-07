package com.douglas.os.repository;

import java.util.List;

import com.douglas.os.model.Tecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository <Tecnico, Integer> {

    @Query("SELECT to FROM Tecnico to")
    List<Tecnico> findAll();
    
}
