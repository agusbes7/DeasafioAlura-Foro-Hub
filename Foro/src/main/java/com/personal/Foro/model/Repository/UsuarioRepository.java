package com.personal.Foro.model.Repository;

import com.personal.Foro.model.Clases.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsuario(String aux);
}
