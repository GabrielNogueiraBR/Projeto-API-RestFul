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

        //Salvando o curso e recebendo o id do curso
        curso = repository.save(curso);

        //Adicionando o curso na lista de cursos da escola
        escola.addCurso(curso);

        return curso;
    }

	public void deleteCursoById(int id) {
        
        //caso nao encontre o curso sera retornado o 404
        Curso curso = getCursoByID(id);

        //obtendo a escola do curso
        Escola escola = escolaService.getEscolaByID(curso.getEscola().getIdEscola());

        //removendo o curso da escola
        escola.getListaCursos().remove(curso);

        //removendo o curso do repositorio
        repository.remove(curso);
    }

	public Curso update(Curso curso) {
        
        //apenas para validar se existe o curso, caso contrario, lanca o 404
        getCursoByID(curso.getIdCurso());
        
        return repository.update(curso);
	}
}
