package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumaController {
    @GetMapping("/sumadora")
    public float suma(
            @RequestParam(defaultValue = "Error") float a,
            @RequestParam(defaultValue = "Error") float b){
                return a+b;
    }

}
