package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre",nullable = false,length = 50)
    private String nombre;
    @Column(name = "especialidad",length = 50)
    private String especialidad;
    @Column(name = "experienciaAnios")
    private float experienciaAnios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public float getExperienciaAnios() {
        return experienciaAnios;
    }

    public void setExperienciaAnios(float experienciaAnios) {
        this.experienciaAnios = experienciaAnios;
    }



    public Profesor() {

    }

    public Profesor(String nombre, String especialidad, float experienciaAnios) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.experienciaAnios = experienciaAnios;
    }








}
