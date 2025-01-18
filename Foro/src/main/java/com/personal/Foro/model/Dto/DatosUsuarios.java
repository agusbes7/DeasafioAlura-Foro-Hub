package com.personal.Foro.model.Dto;

import jakarta.validation.constraints.NotBlank;

public record DatosUsuarios(
        @NotBlank
        String usuario,
        @NotBlank
        String clave,
        @NotBlank
        String correo) {
}
