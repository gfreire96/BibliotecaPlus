package com.davincicode.bibliotecaplus.gestionautores.modelo;

import com.davincicode.bibliotecaplus.gestionusuarios.modelo.Usuario;

public class Autor  extends Usuario {
    private String apellido;
    private String nacionalidad;

    public Autor() {
    }

    public Autor( String nombre, String apellido, String nacionalidad) {
        super(nombre);
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;

    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
