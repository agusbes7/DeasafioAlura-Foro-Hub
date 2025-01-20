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
    @Enumerated(EnumType.STRING)
    private Roles rol;

public Usuario(){}

    public Usuario(DatosUsuarios datos){
        this.correo=datos.correo();
        this.usuario=datos.usuario();
        this.clave= datos.clave();
this.rol=Roles.CLIENTE;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", rol=" + rol +
                '}';
    }
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