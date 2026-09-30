package com.example.demo.controller;

import com.example.demo.clases.Centro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    @GetMapping("/saludo")
    public String saludar(
                    @RequestParam(defaultValue = "Mundo") String nombre){
        return "Hola,"+nombre+" bienvenido a Spring boot";
    }
    @GetMapping("/info")
    public Centro info(Centro centro){
        return centro;
    }


}
