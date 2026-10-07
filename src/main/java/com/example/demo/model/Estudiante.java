package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false,length = 50)
    private String nombre;
    @Column(name = "correo", nullable = false,unique = true)
    private String correo;
    @Column(name = "edad")
    private int edad;



    public Estudiante(String nombre, String correo,int edad){
        this.nombre=nombre;
        this.correo=correo;
        this.edad=edad;
    }
}
