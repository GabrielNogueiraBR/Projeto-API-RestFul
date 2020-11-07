package com.projeto.ac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.projeto.ac2.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    
    private List<Escola> escolas = new ArrayList<Escola>();
    private int nextCode = 1;

    public List<Escola> getAllEscolas(){
        return escolas;
    }
    
    public Optional<Escola> getEscolaByID(int id){
        for (Escola escola : escolas) {
            if(escola.getIdEscola() == id){
                return Optional.of(escola);
            }
        }
        return Optional.empty();
    }

    public Escola save(Escola escola){
        escola.setIdEscola(nextCode++);
        escolas.add(escola);
        return escola;
    }

    public Boolean remove(Escola escola){
        
        //remove a escola apenas se ela nao tive nenhum curso vinculado a ela
        if(escola.getListaCursos().isEmpty())         
            return escolas.remove(escola);
        
        return false;
    }

    public Escola update(Escola escola){
        Escola updateEscola = getEscolaByID(escola.getIdEscola()).get();

        //de acordo com as especificacoes do projeto, apenas dois atributos podem ser alterados
        if(updateEscola != null){
            updateEscola.setCidade(escola.getCidade());
            updateEscola.setRua(escola.getRua());
        }
        
        return updateEscola;
    }
}