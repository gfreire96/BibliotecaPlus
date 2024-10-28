package com.davincicode.bibliotecaplus.interfaz.bibliotecario;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;

import javax.swing.*;
import java.util.List;

public class MenuBibliotecarioPrueba {
    private LibroServicio libroServicio;

    public MenuBibliotecarioPrueba() {
        libroServicio = new LibroServicio(); // Inicializa el servicio de libros
    }

    public void mostrarMenu() {
        String[] funcionalidades = {"Ver todos los libros", "Buscar libro por ID", "Renovar fecha de devolución", "Salir"};

        int funcionSeleccionada = mostrarMsjeSeleccionFuncionalidad(funcionalidades);

        switch (funcionSeleccionada) {
            case -1:
                System.exit(0);
            case 0:
                verTodosLosLibros(); // Muestra todos los libros
                break;
            case 1:
                buscarLibroPorID(); // Busca un libro por ID
                break;
            case 2:
                renovarFechaDeDevolucion(); // Renueva la fecha de devolución
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private int mostrarMsjeSeleccionFuncionalidad(String[] funcionalidades) {
        return JOptionPane.showOptionDialog(null, "Seleccione una funcionalidad:", "Funciones Bibliotecario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, funcionalidades, funcionalidades[0]);
    }

    private void verTodosLosLibros() {
        List<Libro> listaLibros = libroServicio.getLibros(); // Método que deberás implementar en LibroServicio
        StringBuilder librosDetalles = new StringBuilder("Libros disponibles:\n");
        
        for (Libro libro : listaLibros) {
            librosDetalles.append("ID: ").append(libro.getId())
                    .append(", Título: ").append(libro.getTitulo())
                    .append(", Autor: ").append(libro.getAutor())
                    .append(", Prestado: ").append(libro.esPrestado())
                    .append(", Fecha de Devolución: ").append(libro.getFechaDeDevolucion()).append("\n");
        }

        JOptionPane.showMessageDialog(null, librosDetalles.toString(), "Listado de Libros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarLibroPorID() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del libro:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            Long id = Long.parseLong(idStr);
            Libro libroEncontrado = libroServicio.obtenerPorId(id); // Asumiendo que ya implementaste este método
            if (libroEncontrado != null) {
                String detalles = "ID: " + libroEncontrado.getId() +
                                  ", Título: " + libroEncontrado.getTitulo() +
                                  ", Autor: " + libroEncontrado.getAutor() +
                                  ", Prestado: " + libroEncontrado.esPrestado() +
                                  ", Fecha de Devolución: " + libroEncontrado.getFechaDeDevolucion();
                JOptionPane.showMessageDialog(null, detalles, "Detalles del Libro", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Libro no encontrado.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void renovarFechaDeDevolucion() {
        String idStr = JOptionPane.showInputDialog("Ingrese el ID del libro:");
        if (idStr != null && !idStr.trim().isEmpty()) {
            Long id = Long.parseLong(idStr);
            String diasStr = JOptionPane.showInputDialog("Ingrese el número de días de extensión:");
            int diasExtension = Integer.parseInt(diasStr);

            boolean exito = libroServicio.renovarFechaDeDevolucion(id, diasExtension); // Asumiendo que ya implementaste este método
            if (exito) {
                JOptionPane.showMessageDialog(null, "Fecha de devolución renovada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo renovar la fecha de devolución. Libro no encontrado.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}

