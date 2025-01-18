package com.personal.Foro.model.ClasesPrimarias;

import com.personal.Foro.model.Dto.DatosRegistrarTopico;
import com.personal.Foro.model.Enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Estado estadoTopico;
    private String curso;
 private Long idUsuario;
private  List<String> url=new ArrayList<>();
//    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
  //  private List<Respuesta> respuestas = new ArrayList<>();
//----------------------------------------------------------

public  Topico(DatosRegistrarTopico datos){
this.titulo=datos.titulo();
this.mensaje=datos.mensaje();
this.estadoTopico=Estado.REVISION;
this.curso=datos.curso();
// this.respuestas=new ArrayList<>();
DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
this.fechaDeCreacion = LocalDate.now().format(formateador);
//this.usuario=datos.usuario()
this.idUsuario=datos.id();
this.url=datos.archivos();
}

}
