package com.projeto.ac2.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Escola {
    
    private int idEscola;
    private String nomeEscola;
    private String rua;
    private String cidade;
    private String estado;
    private LocalDate dataFundacao;
    private List<Curso> listaCursos = new ArrayList<Curso>();

    //Sobreposicao de metodos construtores
    public Escola(){

    }

    public Escola(int idEscola, String nomeEscola, String rua, String cidade, String estado, LocalDate dataFundacao) {
        this.idEscola = idEscola;
        this.nomeEscola = nomeEscola;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.dataFundacao = dataFundacao;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    //Primeira forma de adicionar um curso
    public Boolean addCurso(Curso curso){
        return listaCursos.add(curso);
    }

    //Segunda forma de adicionar um curso
    public Boolean addCurso(int idCurso, String nomeCurso, String descricao, String nomeProfessorCoordenador, LocalTime cargaHoraria, int alunosMatriculados, Escola escola){
        return listaCursos.add(new Curso(idCurso, nomeCurso, descricao, nomeProfessorCoordenador, cargaHoraria, alunosMatriculados, escola));
    }
    
    public Boolean removeCurso(Curso curso){
        return listaCursos.remove(curso);
    }

    @Override
    public String toString() {
        return "\n\nNome da Escola:" + nomeEscola + "\nData de Fundacao = " + dataFundacao + "\nRua = " + rua + "\nCidade = " + cidade  + "\nEstado = " + estado +  "\nidEscola = "
                + idEscola + "\nLista de Cursos = " + listaCursos + "\n\n";
    }

    
    
}
