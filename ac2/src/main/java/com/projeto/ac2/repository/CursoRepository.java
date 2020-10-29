package com.projeto.ac2.repository;

import java.util.List;

import com.projeto.ac2.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {

    private List<Curso> cursos;
    private int nextCode = 0;

}