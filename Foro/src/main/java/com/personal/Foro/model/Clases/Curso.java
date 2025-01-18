package com.personal.Foro.model.Clases;

import com.personal.Foro.model.Enums.Tematica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {
@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
private    Long id;

private String nombre;
private  String temas;
public Curso(String nombre,List<Tematica> tematica) {
        this.nombre = nombre;
        this.temas = Tematica.listaAString(tematica);
}
}

