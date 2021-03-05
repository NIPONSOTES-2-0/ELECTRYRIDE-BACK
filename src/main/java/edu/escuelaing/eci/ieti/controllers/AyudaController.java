package edu.escuelaing.eci.ieti.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AyudaController {
    
    @PostMapping("/ayuda")
    public void form_ayuda(@RequestParam(value="email") String email, @RequestParam(value="nombre") String nombre, @RequestParam(value="informacion") String info){

    }
    
}
