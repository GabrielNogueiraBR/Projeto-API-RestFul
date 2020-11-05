package com.projeto.ac2.service;

import java.util.List;
import java.util.Optional;

import com.projeto.ac2.dto.EscolaDTO;
import com.projeto.ac2.model.Escola;
import com.projeto.ac2.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {
    
    @Autowired
    private EscolaRepository repository;
    
    public Escola fromDTO(EscolaDTO dto){
        Escola escola = new Escola();
        escola.setNomeEscola(dto.getNomeEscola());
        escola.setRua(dto.getRua());
        escola.setCidade(dto.getCidade());
        escola.setEstado(dto.getEstado());
        escola.setDataFundacao(dto.getDataFundacao());
        
        return escola;
    }

    public List<Escola> getAllEscolas(){
        return repository.getAllEscolas();
    }

    public Escola getEscolaByID(int id){
        Optional<Escola> opEscola = repository.getEscolaByID(id);
        return opEscola.orElseThrow( 
                ()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                             "Escola nao cadastrada."));
    }

    public Escola save(Escola escola){
        return repository.save(escola);
    }

    public Boolean remove(int id){
        
        if(repository.remove(getEscolaByID(id)))
            return true;
        
        return false;
    }

    public Escola update(Escola escola){
        Escola updateEscola = getEscolaByID(escola.getIdEscola());

        return repository.update(updateEscola);
    }
}
