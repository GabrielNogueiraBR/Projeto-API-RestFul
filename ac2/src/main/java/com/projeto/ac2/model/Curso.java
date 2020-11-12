package com.projeto.ac2.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Curso {
    
    private int idCurso;
    private String nomeCurso;
    private String descricao;
    private String nomeProfessorCoordenador;
    private LocalTime horarioAula;
    private int alunosMatriculados;
    
    /**
     * O @JsonIgnore foi utilizado seguindo as orientações do professor para não ocorrer um looping de informações no momento de ser exibidos todos os cursos.
     */
    @JsonIgnore
    private Escola escola;


    public Curso(){};
    
    public Curso(int idCurso, String nomeCurso, String descricao, String nomeProfessorCoordenador,
            LocalTime horarioAula, int alunosMatriculados, Escola escola) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.nomeProfessorCoordenador = nomeProfessorCoordenador;
        this.horarioAula = horarioAula;
        this.alunosMatriculados = alunosMatriculados;
        this.escola = escola;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeProfessorCoordenador() {
        return nomeProfessorCoordenador;
    }

    public void setNomeProfessorCoordenador(String nomeProfessorCoordenador) {
        this.nomeProfessorCoordenador = nomeProfessorCoordenador;
    }

    public LocalTime getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(LocalTime horarioAula) {
        this.horarioAula = horarioAula;
    }

    public int getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(int alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    //https://medium.com/@racc.costa/data-e-hora-no-java-8-e-no-java-9-5f1e3fd8d560
    // LocalTime horaAgora = LocalTime.now();
    // LocalTime horaEspecifica = LocalTime.of(20, 30, 50);
    // LocalTime horaEspecificaDoTexto = LocalTime.parse("20:30:50");   
}
