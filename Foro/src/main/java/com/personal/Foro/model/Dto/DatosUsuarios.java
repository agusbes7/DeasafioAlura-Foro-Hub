package com.personal.Foro.model.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuarios(
        @NotNull(message = "Este campo no puede estar en blanco")
        Long id,
        @NotBlank(message ="Necesitas autorizacion para eliminar un topico" )
        String usuario
        ){}
