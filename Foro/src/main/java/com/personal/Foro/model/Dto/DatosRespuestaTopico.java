package com.personal.Foro.model.Dto;

import com.personal.Foro.model.Clases.Curso;
import com.personal.Foro.model.Clases.Respuesta;
import com.personal.Foro.model.Clases.Usuario;
import com.personal.Foro.model.Enums.Estado;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public record DatosRespuestaTopico(
Long id,
String titulo,
String mensaje,
String fechaDeCreacion,
String curso,
String autor,
List<Respuesta> respuestas) {

}
