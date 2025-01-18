package com.personal.Foro.controller;

import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

@PostMapping
    public ResponseEntity<String> RegistrarTopico(@RequestBody @Valid DatosRegistrarTopico datos){
String probando="hola mundo";
    return ResponseEntity.ok(probando);

}

}
