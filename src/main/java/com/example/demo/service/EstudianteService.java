package com.example.demo.service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository repo;


    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante>listarTodos(){
        return repo.findAll();
    }

    public Optional<Estudiante> buscarPorId(Long id){
        return repo.findById(id);
    }
    public Estudiante guardarEstudiante(Estudiante estudiante){
        return repo.save(estudiante);
    }
    public void eliminarEstudiante(Long id){
        repo.deleteById(id);
    }
}
