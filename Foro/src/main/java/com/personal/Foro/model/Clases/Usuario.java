package com.personal.Foro.model.Clases;


import com.personal.Foro.model.Dto.DatosUsuarios;
import com.personal.Foro.model.Enums.Roles;
import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name ="usuarios" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    //implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String usuario;
    private  String correo;
    private  String clave;
    private Roles rol;



    public Usuario(DatosUsuarios datos){
        this.correo=datos.correo();
        this.usuario=datos.usuario();
        this.clave= datos.clave();
this.rol=Roles.CLIENTE;}

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return clave;
//    }
//
//    @Override
//    public String getUsername() {
//        return usuario;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//
//    }

    //  private List<Rol> permisos= new ArrayList<>();
}