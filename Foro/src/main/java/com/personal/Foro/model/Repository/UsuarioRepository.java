package com.personal.Foro.model.Repository;

import com.personal.Foro.model.ClasesPrimarias.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
