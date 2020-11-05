package com.projeto.ac2.repository;

import java.util.List;
import java.util.Optional;

import com.projeto.ac2.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {

    private List<Curso> cursos;
    private int nextCode = 0;

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
        
        if(updateCurso != null){
            updateCurso.setNomeCurso(curso.getNomeCurso());
            updateCurso.setDescricao(curso.getDescricao());
            updateCurso.setNomeProfessorCoordenador(curso.getNomeProfessorCoordenador());
            updateCurso.setHorarioAula(curso.getHorarioAula());
            updateCurso.setAlunosMatriculados(curso.getAlunosMatriculados());
        }

        return updateCurso;
    }
}