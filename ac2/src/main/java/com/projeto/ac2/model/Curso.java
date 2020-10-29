package com.projeto.ac2.model;

import java.time.LocalTime;

public class Curso {
    
    private int idCurso;
    private String nomeCurso;
    private String descricao;
    private String nomeProfessorCoordenador;
    private LocalTime cargaHoraria;
    private int alunosMatriculados;


    //https://medium.com/@racc.costa/data-e-hora-no-java-8-e-no-java-9-5f1e3fd8d560
    // LocalTime horaAgora = LocalTime.now();
    // LocalTime horaEspecifica = LocalTime.of(20, 30, 50);
    // LocalTime horaEspecificaDoTexto = LocalTime.parse("20:30:50");

    public Curso(int idCurso, String nomeCurso, String descricao, String nomeProfessorCoordenador,
            LocalTime cargaHoraria, int alunosMatriculados, Escola escola) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.descricao = descricao;
        this.nomeProfessorCoordenador = nomeProfessorCoordenador;
        this.cargaHoraria = cargaHoraria;
        this.alunosMatriculados = alunosMatriculados;
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

    @Override
    public String toString() {
        return "Curso [alunosMatriculados=" + alunosMatriculados + ", cargaHoraria=" + cargaHoraria + ", descricao="
                + descricao + ", idCurso=" + idCurso + ", nomeCurso=" + nomeCurso
                + ", nomeProfessorCoordenador=" + nomeProfessorCoordenador + "]";
    }    
}
