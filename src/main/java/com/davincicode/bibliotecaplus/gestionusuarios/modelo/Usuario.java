package com.davincicode.bibliotecaplus.gestionusuarios.modelo;

public class Usuario {
    private String rol;
    private String nombre;
    private String correo;

    public Usuario() {
    }

    public Usuario(String rol, Long id , String nombre, String correo){
        this.rol = rol;
        this.nombre = nombre;
        this.correo = correo;
    }
    public Usuario(String nombre){
        this.nombre = nombre;
    }


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
