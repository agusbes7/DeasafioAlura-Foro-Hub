package com.personal.Foro.model.Clases;

import com.personal.Foro.model.Enums.Tematica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


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
public Curso(){}

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getTemas() {
                return temas;
        }

        public void setTemas(String temas) {
                this.temas = temas;
        }
}

