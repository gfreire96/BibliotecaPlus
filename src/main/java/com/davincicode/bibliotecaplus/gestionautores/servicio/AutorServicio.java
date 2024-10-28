package com.davincicode.bibliotecaplus.gestionautores.servicio;

import com.davincicode.bibliotecaplus.gestionautores.repositorio.BDAutores;
import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;
import java.util.List;

public class AutorServicio {
    private BDAutores baseDatosAutores;/*Este atributo será utilizado para gestionar la información de los autores. */

    public AutorServicio() {
        this.baseDatosAutores = new BDAutores();/*inicializamos el atributo en el constructor, para que */
    }

    public void agregarAutores(Autor autor)  {
        baseDatosAutores.agregarAutor(autor);
    }

    public List<Autor> findAutorByNacionalidad(String nacionalidad)  {
        return baseDatosAutores.obtenerAutoresPorNacionalidad(nacionalidad);
    }

}
