package com.personal.Foro.controller;

import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

@PostMapping
    public void RegistrarTopico(@RequestBody @Valid DatosRegistrarTopico datos){
    System.out.println("bienvenido");

}

}
