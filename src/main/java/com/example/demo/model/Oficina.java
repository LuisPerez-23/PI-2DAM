package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oficina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "codigo_oficina",length = 250)
    private String codigoOficina;
    @Column(name ="edificio",length = 250)
    private String edificio;

    public Oficina(String codigoOficina, String edificio) {
        this.codigoOficina = codigoOficina;
        this.edificio = edificio;
    }
}
