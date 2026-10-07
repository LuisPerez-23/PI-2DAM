package com.example.demo.runner;

import com.example.demo.model.Estudiante;
import com.example.demo.model.Profesor;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.ProfesorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class InicializadorDatos {
    @Bean
    CommandLineRunner initData(EstudianteRepository repo){
        return args -> {
            Estudiante est1 = new Estudiante("Ana Gomez","ana.gomez@gmail.com",20);
            Estudiante est2= new Estudiante("Carlos Ruiz","carlos.ruiz@gmail.com",22);

            repo.save(est1);
            repo.save(est2);
            System.out.println(">>> Estudiantes guardados.");
            System.out.println(">>> Listado completo:");
            for (Estudiante e: repo.findAll()){
                System.out.println("- " + e.getNombre()
                + " ("+ e.getCorreo() +")");
            }
            System.out.println(">>> Total: " +repo.count());
            repo.findById(1L).ifPresent(
                    e -> System.out.println(">>> El 1 es "+e.getNombre())
            );
            repo.deleteById(2L);
            System.out.println(">>> Tras borrar el 2, quedan "+repo.count());

        };
    }
    @Bean
    CommandLineRunner initData2(ProfesorRepository repo2){
        return args ->{
            Profesor prof1= new Profesor("David Juan","Java",6);
            Profesor prof2= new Profesor("Jaime Barroso","Bootspring",1);
            repo2.save(prof1);
            repo2.save(prof2);
            System.out.println(">>> Profesores guardados.");
            System.out.println(">>> Listado completo");
            for (Profesor p: repo2.findAll()){
                System.out.println("- " + p.getNombre()
                        + " ("+ p.getEspecialidad() +")");
            }
            System.out.println(">>> Total: " +repo2.count());
            repo2.findById(1L).ifPresent(
                    p -> System.out.println(">>> El 1 es "+p.getNombre())
            );

        };
    }

}
