package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.model.Profesor;
import com.example.demo.service.CursoService;
import com.example.demo.service.ProfersorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService servicio;

    public CursoController(CursoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Curso> obtenerTodos(){return servicio.listarTodos();}

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id){
        return servicio.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PostMapping
    public ResponseEntity<Curso> crea(@RequestBody Curso curso){
        Curso nuevo =servicio.guardarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (servicio.buscarPorId(id).isPresent()){
            servicio.eliminarCurso(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
