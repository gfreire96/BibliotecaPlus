package com.davincicode.bibliotecaplus.gestionlibros.servicio;

import com.davincicode.bibliotecaplus.gestionlibros.modelo.Libro;
import com.davincicode.bibliotecaplus.gestionlibros.repositorio.BDLibros;
import java.util.List;

public class LibroServicio {
    private BDLibros datosLibros;

    public LibroServicio() {
        this.datosLibros = new BDLibros();
    }
    
    public List<Libro> getLibros() {
        return datosLibros.getLibros(); 
    }
    
    // Método para obtener un libro por ID
    public Libro obtenerPorId(Long id) {
        return datosLibros.obtenerPorId(id); // Llama al método de BDLibros
    }

    
    public boolean renovarFechaDeDevolucion(Long libroId, int diasExtension) {
        Libro libro = datosLibros.obtenerPorId(libroId);
        if (libro != null) {
            String fechaStr = String.format("%06d", libro.getFechaDeDevolucion());
            int dia = Integer.parseInt(fechaStr.substring(0, 2));
            int mes = Integer.parseInt(fechaStr.substring(2, 4));
            int anio = Integer.parseInt(fechaStr.substring(4, 6));

            dia += diasExtension;

            int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            while (true) {
                if (dia > diasPorMes[mes - 1]) {
                    dia -= diasPorMes[mes - 1];
                    mes++;
                    if (mes > 12) {
                        mes = 1;
                        anio++;
                    }
                } else {
                    break; // Fin del ajuste
                }
            }

            String nuevaFechaStr = String.format("%02d%02d%02d", dia, mes, anio);
            libro.setFechaDeDevolucion(Integer.parseInt(nuevaFechaStr));
            datosLibros.actualizar(libro);
            return true; // Renovación exitosa
        }
        return false; // Libro no encontrado
    }
}
