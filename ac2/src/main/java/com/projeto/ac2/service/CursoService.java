package com.projeto.ac2.service;

import java.util.List;
import java.util.Optional;

import com.projeto.ac2.dto.CursoDTO;
import com.projeto.ac2.model.Curso;
import com.projeto.ac2.model.Escola;
import com.projeto.ac2.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    @Autowired
    private EscolaService escolaService;

    public Curso fromDTO(CursoDTO cursoDTO){
        Curso curso = new Curso();
        curso.setNomeCurso(cursoDTO.getNomeCurso());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setNomeProfessorCoordenador(cursoDTO.getNomeProfessorCoordenador());
        curso.setHorarioAula(cursoDTO.getHorarioAula());
        curso.setAlunosMatriculados(cursoDTO.getAlunosMatriculados());

        return curso;
    }

    public List<Curso> getAllCursos(){
       return repository.getAllCursos();
    }

    public Curso getCursoByID(int id){
        Optional<Curso> opCurso = repository.getCursoByID(id);
        return opCurso.orElseThrow( ()-> new ResponseStatusException( HttpStatus.NOT_FOUND, "Curso nao cadastrado"));
    }

    public Curso save(int id, Curso curso){
        
        //Verificar se existe uma escola com o codigo -> caso contrario retorna o erro 404.
        Escola escola = escolaService.getEscolaByID(id);

        //Adicionando a escola no objeto curso
        curso.setEscola(escola);
        //Adicionando o curso na lista de cursos da escola
        escola.addCurso(curso);

        return repository.save(curso);
    }
}
