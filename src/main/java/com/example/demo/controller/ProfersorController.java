package com.example.demo.controller;

import com.example.demo.model.Profesor;
import com.example.demo.service.ProfersorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ProfersorController {
    private final ProfersorService servicio;


    public ProfersorController(ProfersorService sevicio) {
        this.servicio = sevicio;
    }
    @GetMapping
    public List<Profesor> obtenerTodos(){return servicio.listarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(@PathVariable Long id){
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<Profesor> crea(@RequestBody Profesor profesor){
        Profesor nuevo =servicio.guardarProfesor(profesor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (servicio.buscarPorId(id).isPresent()){
            servicio.eliminarProfesor(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
