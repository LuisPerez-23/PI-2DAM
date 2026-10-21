package com.example.demo.controller;


import com.example.demo.model.Estudiante;
import com.example.demo.model.PerfilAcademico;
import com.example.demo.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id,
                                                 @RequestBody Estudiante datos){
        Optional<Estudiante> encontrado = servicio.buscarPorId(id);
        if (encontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Estudiante existente = encontrado.get();
        existente.setNombre(datos.getNombre());
        existente.setCorreo(datos.getCorreo());
        existente.setEdad(datos.getEdad());

        // la parte nueva: que hacemos con el perfil
        PerfilAcademico perfilNuevo= datos.getPerfilAcademico();
        PerfilAcademico perfilActual= existente.getPerfilAcademico();

        if (perfilNuevo==null){
            existente.setPerfilAcademico(null); //caso1
        }else if (perfilActual==null){
            existente.setPerfilAcademico(perfilNuevo);//caso2
        }else {
            perfilActual.setBiografia(perfilNuevo.getBiografia());
            perfilActual.setNivelIngles(perfilNuevo.getNivelIngles());//caso3
        }
        return ResponseEntity.ok(servicio.guardarEstudiante(existente));

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
