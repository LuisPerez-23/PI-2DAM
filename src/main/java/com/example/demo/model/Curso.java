package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_curso",nullable = false, length = 100)
    private String nombreCurso;
    @Column(name="creditos")
    private int creditos;
    //muchos cursos pertenece a un profesor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id",nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties({"cursos","hibernateLazyInitializer","handler"})
    private Profesor profesor;

}
