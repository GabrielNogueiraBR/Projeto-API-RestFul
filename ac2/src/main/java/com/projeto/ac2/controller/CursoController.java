package com.projeto.ac2.controller;

import com.projeto.ac2.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService service;
    
}
