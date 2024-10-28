package com.davincicode.bibliotecaplus;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.modelo.Publica;
import com.davincicode.bibliotecaplus.gestionlibros.servicio.LibroServicio;
import com.davincicode.bibliotecaplus.interfaz.bibliotecario.MenuBibliotecarioPrueba; // Importa la clase de menú

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibroServicio libroServicio = new LibroServicio();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Buscar libro por ID");
            System.out.println("3. Renovar fecha de devolución");
            System.out.println("4. Mostrar menú Swing"); // Nueva opción para mostrar el menú Swing
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    List<Libro> libros = libroServicio.getLibros();
                    for (Libro libro : libros) {
                        System.out.println("ID: " + libro.getId() +
                                ", Título: " + libro.getTitulo() +
                                ", Autor: " + libro.getAutor() +
                                ", Fecha de Devolución: " + libro.getFechaDeDevolucion());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el ID del libro a buscar: ");
                    Long idBuscado = scanner.nextLong();
                    Libro libroEncontrado = libroServicio.obtenerPorId(idBuscado);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " +
                                "ID: " + libroEncontrado.getId() +
                                ", Título: " + libroEncontrado.getTitulo() +
                                ", Autor: " + libroEncontrado.getAutor() +
                                ", Fecha de Devolución: " + libroEncontrado.getFechaDeDevolucion());
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del libro: ");
                    Long libroId = scanner.nextLong();
                    System.out.print("Ingrese la cantidad de días de extensión: ");
                    int diasExtension = scanner.nextInt();
                    boolean renovado = libroServicio.renovarFechaDeDevolucion(libroId, diasExtension);
                    if (renovado) {
                        System.out.println("Fecha de devolución renovada.");
                    } else {
                        System.out.println("No se pudo renovar la fecha de devolución.");
                    }
                    break;

                case 4:
                    // Llamada al menú Swing
                    MenuBibliotecarioPrueba menuSwing = new MenuBibliotecarioPrueba();
                    menuSwing.mostrarMenu(); // Llama al método para mostrar el menú
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }
    
        
     
    }
//    public static void main(String[] args) {
//        Publica pepe = new Publica();
//        pepe.edad = 90;
//        pepe.nombre = "Pedro";
//        System.out.println(pepe.toString());
//    }
//}
    



