package com.example.demo.service;

import com.example.demo.model.Curso;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CursoService {
    private final CursoRepository repo;


    public CursoService (CursoRepository repo) {
        this.repo = repo;
    }

    public List<Curso> listarTodos(){
        return repo.findAll();
    }

    public Optional<Curso> buscarPorId(Long id){
        return repo.findById(id);
    }
    public Curso guardarCurso(Curso curso){
        return repo.save(curso);
    }
    public void eliminarCurso(Long id){
        repo.deleteById(id);
    }
}
