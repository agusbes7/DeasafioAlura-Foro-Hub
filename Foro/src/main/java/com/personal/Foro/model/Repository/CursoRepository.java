package com.personal.Foro.model.Repository;

import com.personal.Foro.model.Clases.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso,Long> {
Optional<Curso> findByNombre(String nombre);
}
