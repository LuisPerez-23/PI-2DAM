package com.example.demo.controller;


import com.example.demo.model.Estudiante;
import com.example.demo.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
    private final EstudianteService servicio;

    public EstudianteController(EstudianteService servicio) {
        this.servicio = servicio;
    }
    @GetMapping
    public List<Estudiante>obtenerTodos(){
        return servicio.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id){
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante){
        Estudiante nuevo = servicio.guardarEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (servicio.buscarPorId(id).isPresent()) {
            servicio.eliminarEstudiante(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

}
