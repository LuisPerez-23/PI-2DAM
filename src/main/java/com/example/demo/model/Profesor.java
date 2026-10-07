package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesores")
@Data
@NoArgsConstructor
@AllArgsConstructor
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



    public Profesor(String nombre, String especialidad, float experienciaAnios) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.experienciaAnios = experienciaAnios;
    }








}
