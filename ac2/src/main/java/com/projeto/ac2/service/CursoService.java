package com.projeto.ac2.service;

import com.projeto.ac2.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    
}
