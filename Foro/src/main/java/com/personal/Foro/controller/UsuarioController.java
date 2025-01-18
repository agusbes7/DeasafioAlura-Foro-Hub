package com.personal.Foro.controller;

import com.personal.Foro.model.Clases.Usuario;
import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import com.personal.Foro.model.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarios;
    @GetMapping
    public Usuario obtenerUsuario(){
        return usuarios.getReferenceById(Long.valueOf(1));
    }
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world from Europe!";
    }
}