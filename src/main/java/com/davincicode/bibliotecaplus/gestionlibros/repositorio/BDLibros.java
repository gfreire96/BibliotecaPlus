package com.davincicode.bibliotecaplus.gestionlibros.repositorio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class BDLibros {
    private List<Libro> libros; // Hacer más declarativo EJ: "listaLibro"

    public BDLibros() {
        libros = new ArrayList<>();
        // Ejemplo de libros
        libros.add(new Libro(1L, "El Quijote", "Cervantes", 230423));
        libros.add(new Libro(2L, "1984", "Orwell", 150424));
    }

    public List<Libro> getLibros() {
        return libros; // Método para obtener la lista de libros
    }    
    
    public Libro obtenerPorId(Long id) { // Hacer más claro, ...
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i); // Obtenemos el libro en la posición i
            if (libro.getId().equals(id)) {
                return libro; // Retorna el libro encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public void actualizar(Libro libroActualizado) { 
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i); // Obtenemos el libro en la posición i
            if (libro.getId().equals(libroActualizado.getId())) {
                libros.set(i, libroActualizado); // Actualiza el libro
                return; // Salimos después de actualizar
            }
        }
    }
}

