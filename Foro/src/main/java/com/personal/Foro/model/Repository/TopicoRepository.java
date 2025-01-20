package com.personal.Foro.model.Repository;

import com.personal.Foro.model.Clases.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository  extends JpaRepository<Topico,Long> {

    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}
