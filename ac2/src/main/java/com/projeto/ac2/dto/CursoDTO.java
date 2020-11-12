package com.projeto.ac2.dto;

import java.time.LocalTime;

public class CursoDTO {
    private int idCurso;
    private String nomeCurso;
    private String descricao;
    private String nomeProfessorCoordenador;
    private LocalTime horarioAula;
    private int alunosMatriculados;

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

    public int getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(int alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public LocalTime getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(LocalTime horarioAula) {
        this.horarioAula = horarioAula;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    
}
