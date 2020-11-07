package com.projeto.ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto.ac2.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {

    private List<Curso> cursos = new ArrayList<Curso>();
    private int nextCode = 1;

    public List<Curso> getAllCursos() {
        return cursos;
    }

    public Optional<Curso> getCursoByID(int id){
        for (Curso curso : cursos) {
            if(curso.getIdCurso() == id){
                return Optional.of(curso);
            }
        }
        return Optional.empty();
    }

    public Curso save(Curso curso){
        curso.setIdCurso(nextCode++);
        cursos.add(curso);
        return curso;
    }

    public void remove(Curso curso){
        cursos.remove(curso);
    }

    public Curso update(Curso curso){

        Curso updateCurso = getCursoByID(curso.getIdCurso()).get();
        
        //de acordo com as especificacoes do projeto, apenas um atributo do curso pode ser alterado
        if(updateCurso != null){
            updateCurso.setAlunosMatriculados(curso.getAlunosMatriculados());
        }

        return updateCurso;
    }
}