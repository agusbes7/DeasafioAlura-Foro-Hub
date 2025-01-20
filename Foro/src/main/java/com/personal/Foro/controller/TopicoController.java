package com.personal.Foro.controller;

import com.personal.Foro.model.Clases.Curso;
import com.personal.Foro.model.Clases.Topico;
import com.personal.Foro.model.Clases.Usuario;
import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import com.personal.Foro.model.Dto.DatosRespuestaTopico;
import com.personal.Foro.model.Repository.CursoRepository;
import com.personal.Foro.model.Repository.TopicoRepository;
import com.personal.Foro.model.Repository.UsuarioRepository;
import com.personal.Foro.service.ValidacionTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
@Autowired
    TopicoRepository repositorio;
@Autowired
    UsuarioRepository usuario;
@Autowired
    ValidacionTopico topico;
@Autowired
    CursoRepository taller;
@PostMapping
    public ResponseEntity<DatosRespuestaTopico> RegistrarTopico(@RequestBody @Valid DatosRegistrarTopico datos){
topico.validarIdYNombreUsuario(datos.id(), datos.usuario());
Usuario aux=usuario.findByUsuario(datos.usuario());
topico.validarCurso(datos.curso());
    Curso  curso=taller.findByNombre(datos.curso()).get();
Topico nuevo= new Topico(datos,aux,curso);

repositorio.save(nuevo);
    DatosRespuestaTopico enviar=new DatosRespuestaTopico(
            nuevo.getId(),
            nuevo.getTitulo(),
            nuevo.getMensaje(),
            nuevo.getFechaDeCreacion(),
"Tema: "+            nuevo.getCurso().getNombre()+" "+nuevo.getCurso().getTemas(),
  "Autor: "+      nuevo.getAutor().getUsuario()+ " id: "+nuevo.getAutor().getId(),
           nuevo.getRespuestas());

    return ResponseEntity.ok(enviar);
}

}
