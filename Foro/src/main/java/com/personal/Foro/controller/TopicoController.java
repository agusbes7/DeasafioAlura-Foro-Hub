package com.personal.Foro.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.personal.Foro.model.Clases.Curso;
import com.personal.Foro.model.Clases.Topico;
import com.personal.Foro.model.Clases.Usuario;
import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import com.personal.Foro.model.Dto.DatosRespuestaTopico;
import com.personal.Foro.model.Dto.DatosUsuarios;
import com.personal.Foro.model.Repository.CursoRepository;
import com.personal.Foro.model.Repository.TopicoRepository;
import com.personal.Foro.model.Repository.UsuarioRepository;
import com.personal.Foro.service.ValidacionTopico;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

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
    public ResponseEntity<DatosRespuestaTopico> RegistrarTopico(@RequestBody @Valid DatosRegistrarTopico datos) {
        topico.validarIdYNombreUsuario(datos.id(), datos.usuario());
        Usuario aux = usuario.findByUsuario(datos.usuario());
        Curso tema = topico.validarCurso(datos.curso());
        topico.validarUnicidad(datos.titulo(), datos.mensaje());
        Topico nuevo = new Topico(datos, aux, tema);

        repositorio.save(nuevo);
        DatosRespuestaTopico enviar = new DatosRespuestaTopico(
                nuevo.getTitulo(),
                nuevo.getMensaje(),
                nuevo.getFechaDeCreacion(),
                "Tema: " + nuevo.getCurso().getNombre() + " " + nuevo.getCurso().getTemas(),
                "Autor: " + nuevo.getAutor().getUsuario() + " id: " + nuevo.getAutor().getId(),
                nuevo.getRespuestas());

        return ResponseEntity.ok(enviar);
    }

    @GetMapping
    public ResponseEntity<Page<DatosRespuestaTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion) {
        Page<DatosRespuestaTopico> page = repositorio.findAll(paginacion)
                .map(nuevo -> new DatosRespuestaTopico(

                        nuevo.getTitulo(),
                        nuevo.getMensaje(),
                        nuevo.getFechaDeCreacion(),
                        "Tema: " + nuevo.getCurso().getNombre() + " " + nuevo.getCurso().getTemas(),
                        "Autor: " + nuevo.getAutor().getUsuario() + " id: " + nuevo.getAutor().getId(),
                        nuevo.getRespuestas()));

        return ResponseEntity.ok(page);
    }


@GetMapping("/{id}")
public ResponseEntity mostrarTopico(@PathVariable String id) {

    Topico nuevo = repositorio.findById( topico.validarId(id))
            .orElseThrow(() -> new EntityNotFoundException("Tópico con ID " + id + " no encontrado."));
    DatosRespuestaTopico aux = new DatosRespuestaTopico(

            nuevo.getTitulo(),
            nuevo.getMensaje(),
            nuevo.getFechaDeCreacion(),
            "Tema: " + nuevo.getCurso().getNombre() + " " + nuevo.getCurso().getTemas(),
            "Autor: " + nuevo.getAutor().getUsuario() + " id: " + nuevo.getAutor().getId(),
            nuevo.getRespuestas());
    return ResponseEntity.ok(aux);
}
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable String id,@RequestBody @Valid DatosUsuarios usuario) {}
    @PutMapping("/id")
    public  ResponseEntity actualizarTopico(@PathVariable String idm,DatosUsuario user){}


}
