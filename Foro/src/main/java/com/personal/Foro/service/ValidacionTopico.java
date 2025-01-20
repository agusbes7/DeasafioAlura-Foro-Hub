package com.personal.Foro.service;

import com.personal.Foro.model.Clases.Curso;
import com.personal.Foro.model.Clases.Usuario;
import com.personal.Foro.model.Repository.CursoRepository;
import com.personal.Foro.model.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidacionTopico {
    @Autowired
    private UsuarioRepository usuarioRepository;
@Autowired
private CursoRepository cursoRepository;
    public void validarIdYNombreUsuario(Long id, String nombreUsuario) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!usuario.getUsuario().equals(nombreUsuario)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID y el nombre de usuario no corresponden entre si");
        }}

    public  void validarCurso(String nombre){
 Curso aux=cursoRepository.findByNombre(nombre)
         .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));
    }
}


