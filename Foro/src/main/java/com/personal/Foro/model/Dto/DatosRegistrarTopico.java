package com.personal.Foro.model.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistrarTopico(
@NotBlank
@JsonAlias("Nombre de usuario") String usuario,

@NotBlank
        String titulo,
@NotBlank
        String mensaje,
@NotBlank
String curso){}