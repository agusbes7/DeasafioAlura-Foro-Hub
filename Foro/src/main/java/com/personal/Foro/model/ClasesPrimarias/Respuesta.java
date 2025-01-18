package com.personal.Foro.model.ClasesPrimarias;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Respuestas")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private  String mensaje;
//    @ManyToOne
//    @JoinColumn(name = "idTopico", nullable = false)
//    private  Usuario autor;
// @ManyToOne
//   @JoinColumn(name = "idTopico", nullable = false)
//    private Topico topico; // Relación con el tópico al que pertenece la respuesta
//
//  @ManyToOne
//    @JoinColumn(name = "idRespuestaPadre", nullable = true)
//    private Respuesta respuestaPadre;


}


