package com.personal.Foro.model.Clases;

import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import com.personal.Foro.model.Enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaDeCreacion;

    @Enumerated(EnumType.STRING)
    @Column
    private Estado estadoTopico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;


    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<Respuesta> respuestas = new ArrayList<>();
//----------------------------------------------------------
public  Topico(DatosRegistrarTopico datos, Usuario autor,Curso vinculo){
this.titulo=datos.titulo();
this.mensaje=datos.mensaje();
this.estadoTopico=Estado.ACTIVO;
// this.respuestas=new ArrayList<>();
DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
this.fechaDeCreacion = LocalDate.now().format(formateador);
this.autor=autor;
this.curso=vinculo;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public Estado getEstadoTopico() {
        return estadoTopico;
    }

    public void setEstadoTopico(Estado estadoTopico) {
        this.estadoTopico = estadoTopico;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaDeCreacion='" + fechaDeCreacion + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
