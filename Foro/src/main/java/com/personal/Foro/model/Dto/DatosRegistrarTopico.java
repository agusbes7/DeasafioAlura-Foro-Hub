package com.personal.Foro.model.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosRegistrarTopico(
        @NotNull(message = "El id no puede ser nulo")
        @JsonAlias("Identificador de usuario") Long id,
@NotBlank(message = "Necesitas tener un usuario en el sistema para poder registrar topicos")
@JsonAlias("Nombre de usuario") String usuario,
@NotBlank(message = "Este campo no puede estar en blanco")
        String titulo,
@NotBlank(message = "El mensaje no puede estar en blanco, permite describir tu pregunta")
        String mensaje,
@NotBlank(message = "Este campo No puede estar en blanco, debemos asociar tu topico a un curso")
String curso
){

}