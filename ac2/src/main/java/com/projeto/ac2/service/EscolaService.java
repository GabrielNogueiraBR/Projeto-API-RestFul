package com.projeto.ac2.service;

import com.projeto.ac2.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EscolaService {
    
    @Autowired
    private EscolaRepository repository;
    
}
