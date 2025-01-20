package com.personal.Foro.service;

import com.personal.Foro.model.Clases.Curso;
import com.personal.Foro.model.Clases.Topico;
import com.personal.Foro.model.Clases.Usuario;
import com.personal.Foro.model.Repository.CursoRepository;
import com.personal.Foro.model.Repository.TopicoRepository;
import com.personal.Foro.model.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ValidacionTopico {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public void validarIdYNombreUsuario(Long id, String nombreUsuario) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!usuario.getUsuario().equals(nombreUsuario)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID y el nombre de usuario no corresponden entre si");
        }
    }

    public Curso validarCurso(String nombre) {
        return cursoRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));
    }
    public Long validarId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El formato del ID es incorrecto. Se esperaba un número.");
        }
    }

    public void validarUnicidad(String titulo, String mensaje) {
        Optional<Topico> aux = topicoRepository.findByTituloAndMensaje(titulo, mensaje);
        if (aux.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe una problemática con este título y descripción");
        }
    }

}
