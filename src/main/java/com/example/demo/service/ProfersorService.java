package com.example.demo.service;

import com.example.demo.model.Profesor;
import com.example.demo.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfersorService {
    private final ProfesorRepository repo;

    public ProfersorService(ProfesorRepository repo) {
        this.repo = repo;
    }
    public List<Profesor>listarTodos(){return repo.findAll();}

    public Optional<Profesor> buscarPorId(Long id){
        return repo.findById(id);
    }
    public Profesor guardarProfesor (Profesor profesor){
        return repo.save(profesor);
    }
    public  void eliminarProfesor(Long id){
        repo.deleteById(id);
    }
}
