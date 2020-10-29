package com.projeto.ac2.dto;

import java.time.LocalTime;

public class CursoDTO {
    private String nomeCurso;
    private String descricao;
    private String nomeProfessorCoordenador;
    private LocalTime cargaHoraria;
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

    public LocalTime getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(LocalTime cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(int alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    
}
