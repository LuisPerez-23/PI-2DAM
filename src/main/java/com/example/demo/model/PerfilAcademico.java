package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="perfilesAcademicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfilAcademico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "biografia", length = 250)
    private String biografia;
    @Column(name = "nivel ingles", length = 20)
    private String nivelIngles;
    @Column(name = "expediente")
    private double expediente;

    public PerfilAcademico(String biografia, String nivelIngles, double expediente) {
        this.biografia = biografia;
        this.nivelIngles = nivelIngles;
        this.expediente=expediente;

    }



}
