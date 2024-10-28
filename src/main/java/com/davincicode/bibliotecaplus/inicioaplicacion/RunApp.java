package com.davincicode.bibliotecaplus.inicioaplicacion;

import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
import com.davincicode.bibliotecaplus.interfaz.bibliotecario.MenuBibliotecario;
import com.davincicode.bibliotecaplus.interfaz.socio.MenuSocio;

import javax.swing.*;
/**Clase desde la cual corre la aplicación*/
public class RunApp {
    public static void main(String[] args) {
        //Llamamos a la función que muestra el título de nuestra aplicación
        mostrarTituloAplicacion();

        // Inicializo un arreglo de tipo String con los valores de los roles que permite la aplicación
        String[] opciones = inicializarArregloOpcionesRoles();

        int seleccion = seleccionarRol(opciones);

        // Validar la selección
        validarSeleccionYMostrarMenuCorrespondiente(seleccion);
    }

    /**Generamos métodos publicos y estáticos para poder llamarlos desde el contexto estático del main
     *
     * los métodos con la palabra reservada static indican que pertenecen a la clase y no a una instancia específica de la clase
     * de esta manera podemos llamar a los métodos directamente desde el contexto estático, sin tener que instanciar un objeto
     * */

    public static void mostrarTituloAplicacion(){
       JOptionPane.showMessageDialog(null, "Bienvenido a BibliotecaPlus", "BibliotecaPlus", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String[]  inicializarArregloOpcionesRoles(){
        return new String[]{"Bibliotecario", "Socio"};
    }

    public static int seleccionarRol(String[] opciones){
        return JOptionPane.showOptionDialog(null, "Seleccione su rol:", "Selección de Rol",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

    public static void validarSeleccionYMostrarMenuCorrespondiente(int seleccion){
        if (seleccion == -1) {
            System.exit(0); // Si el usuario cierra la ventana
        }
        if (seleccion == 0) { // selección para el rol de Bibliotecario
            /**cargamos la vista para el bibliotecario*/
            MenuBibliotecario menuBibliotecario = new MenuBibliotecario();//creamos el menú para el bibliotecario
            menuBibliotecario.mostrarMenu();
        } else if (seleccion == 1) { // selección para el rol de Socio
            /**cargamos la vista para el socio*/
            MenuSocio menuSocio = new MenuSocio();
            menuSocio.mostrarMenu();
        }
    }

}
