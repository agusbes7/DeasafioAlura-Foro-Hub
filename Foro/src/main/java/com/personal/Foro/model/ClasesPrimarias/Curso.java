package com.personal.Foro.model.ClasesPrimarias;

import com.personal.Foro.model.Enums.Tematica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
private List<Tematica> temas=new ArrayList<>(3);


public Curso(String nombre,List<Tematica> tematica){
        this.nombre=nombre;
this.temas=tematica;}

}

