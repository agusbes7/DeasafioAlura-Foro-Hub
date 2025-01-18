package com.personal.Foro.model.Repository;

import com.personal.Foro.model.ClasesPrimarias.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository  extends JpaRepository<Topico,Long> {
}
