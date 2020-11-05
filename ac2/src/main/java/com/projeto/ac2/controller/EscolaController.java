package com.projeto.ac2.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.projeto.ac2.dto.EscolaDTO;
import com.projeto.ac2.model.Escola;
import com.projeto.ac2.service.CursoService;
import com.projeto.ac2.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    
    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Escola> getAllEscolas(){
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> getEscolaByID(@PathVariable int id){
        Escola escola = escolaService.getEscolaByID(id);
        
        return ResponseEntity.ok(escola);
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody EscolaDTO escolaDTO,
                                        HttpServletRequest request,
                                        UriComponentsBuilder builder
                                        ){

        Escola escola = escolaService.fromDTO(escolaDTO);
        
        //Componentes da URI
        UriComponents components = builder.path(request.getRequestURI() + "/" + escola.getIdEscola()).build();

        //Construindo a URI a partir dos Components
        URI uri = components.toUri();

        //retornando
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> updateEscolaByID(@PathVariable int id, @RequestBody EscolaDTO escolaDTO){
        
        //recebendo os dados do DTO
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setIdEscola(id);
        
        //fazendo o update dos dados
        escola = escolaService.update(escola);

        //fazendo o return
        return ResponseEntity.ok(escola);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEscolaByID(@PathVariable int id){
        escolaService.remove(id);

        return ResponseEntity.noContent().build();
    }

    // @PostMapping("/{id}/cursos")
    // public ResponseEntity<Void> saveCurso(@PathVariable int id, @RequestBody CursoDTO cursoDTO, HttpServletRequest request, UriComponentsBuilder builder){
    //     Curso curso = cursoService.save(id,)
    // }
    
}
