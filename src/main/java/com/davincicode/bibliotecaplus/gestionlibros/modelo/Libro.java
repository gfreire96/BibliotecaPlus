package com.davincicode.bibliotecaplus.gestionlibros.modelo;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private boolean prestado;
    private int fechaDeDevolucion; // Formato DDMMAA

    public Libro(Long id, String titulo, String autor, int fechaDeDevolucion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo; // Asegúrate de tener este método
    }

    public String getAutor() {
        return autor; // Asegúrate de tener este método
    }

    public int getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(int nuevaFechaDeDevolucion) {
        this.fechaDeDevolucion = nuevaFechaDeDevolucion;
    }
    
    public boolean esPrestado(){
        return prestado;
    }
}

