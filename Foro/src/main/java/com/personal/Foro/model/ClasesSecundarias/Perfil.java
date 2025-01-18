package com.personal.Foro.model.ClasesSecundarias;

import com.personal.Foro.model.Enums.Roles;

public class Perfil {
    private String idTopico;
    private Roles rol;

    public String getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(String idTopico) {
        this.idTopico = idTopico;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
