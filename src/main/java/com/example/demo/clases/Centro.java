package com.example.demo.clases;

public class Centro {
    private String curso;
    private String centro;
    private String profesor;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }


    public Centro() {
        curso ="DAM B";
        centro = "DIGITECH";
        profesor = "Jaime";
    }

    public Centro(String curso, String centro, String profesor) {
        this.curso = curso;
        this.centro = centro;
        this.profesor = profesor;
    }
}
