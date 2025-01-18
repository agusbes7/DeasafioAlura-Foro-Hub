package com.personal.Foro.model.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosRegistrarTopico(
        @NotNull
        @JsonAlias("Identificador de usuario") Long id,
@NotBlank
@JsonAlias("Nombre de usuario") String usuario,
@NotBlank
        String titulo,
@NotBlank
        String mensaje,
@NotBlank
String curso,
List<String> archivos){}
