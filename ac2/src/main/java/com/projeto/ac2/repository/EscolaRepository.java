package com.projeto.ac2.repository;

import java.util.List;

import com.projeto.ac2.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    
    private List<Escola> escolas;
    private int nextCode = 0;
    
}