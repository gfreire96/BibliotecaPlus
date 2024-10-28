package com.davincicode.bibliotecaplus.gestionautores.repositorio;
import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**Clase que simula ser una base de datos que guarda diferentes datos de autores/escritores
 * En este caso las clases guardan los datos en memoria
 * */
public class BDAutores implements AutorRepository {
    private List<Autor> autores;


    public BDAutores() {
        this.autores = new ArrayList<>();
        inicializarListaAutores();
    }

    private void inicializarListaAutores() {
        autores.add(new Autor("Julio", "Cortázar", "Argentina"));
        autores.add(new Autor("Roberto ", "Arlt", "Argentina"));
        autores.add(new Autor("Herman ", "Hesse", "Alemania"));
    }

    @Override
    public List<Autor> obtenerAutoresPorNacionalidad(String nacionalidad)  {
        if(nacionalidad == null){
            JOptionPane.showMessageDialog(null, "Ingrese el dato de la nacionalidad", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        List<Autor> autoresFiltradosPorNacionalidad = new ArrayList<>();
        for(Autor autor : autores){
            if(nacionalidad.equalsIgnoreCase(autor.getNacionalidad())){
                autoresFiltradosPorNacionalidad.add(autor);
            }
        }
        if(autoresFiltradosPorNacionalidad.isEmpty()){
            JOptionPane.showMessageDialog(null, "No existem autores de esa nacionalidad", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return autoresFiltradosPorNacionalidad;
    }

    @Override
    public void agregarAutor(Autor autor) {
        if( autor == null){
            JOptionPane.showMessageDialog(null, "Ingrese los datos del autor", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        if( autores.contains(autor)){
            JOptionPane.showMessageDialog(null, "El autor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        autores.add(autor);
    }


}
