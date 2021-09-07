package com.douglas.os.config;

import com.douglas.os.service.DbService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService DbService;
    
    @Bean
    public void instanciaDB(){
        this.DbService.instanciaDB();
    }
    
}
