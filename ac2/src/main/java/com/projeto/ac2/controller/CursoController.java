package com.projeto.ac2.controller;

import java.util.List;

import com.projeto.ac2.dto.CursoDTO;
import com.projeto.ac2.model.Curso;
import com.projeto.ac2.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService service;
    
    /**
     * Metodo utilizando {@code GetMapping} para obter a lista de todos os cursos cadastrados.
     * @author Gabriel Nogueira 
     * @return sera retornado um List com os cursos cadastrados
     */
    @GetMapping()
    public List<Curso> getAllCursos(){
        return service.getAllCursos();
    }

    /**
     * Metodo utilizando {@code GetMapping} para retornar as informacoes de um curso.
     * @author Gabriel Nogueira
     * @param id identificado do curso passado via {@code GET}.
     * @return o retorno sera um curso caso haja um curso com o {@code id} informado. Caso contrario, o retorno sera {@code Not Found(404)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable int id){
        Curso curso = service.getCursoByID(id);
        return ResponseEntity.ok(curso);
    }

    /**
     * Metodo utilizando {@code DeleteMapping} para fazer a exclusao de um curso a partir de seu {@code id}.
     * @author Gabriel Nogueira
     * @param id identificador do curso a ser excluido
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCursoById(@PathVariable int id){
        service.deleteCursoById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> alteraCursoById(@PathVariable int id, @RequestBody CursoDTO cursoDTO){
        
        //recebendo as alteracoes do DTO
        Curso curso = service.fromDTO(cursoDTO);
        
        //definindo o id do curso de acordo com o passado via PUT
        curso.setIdCurso(id);

        //realizando as alteracoes no repositorio
        curso = service.update(curso);

        return ResponseEntity.ok(curso);
    }


}
