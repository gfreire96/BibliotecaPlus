package com.davincicode.bibliotecaplus.gestionautores.repositorio;

import com.davincicode.bibliotecaplus.gestionautores.modelo.Autor;

import java.util.List;

/**contrato que cualquier clase que implemente esta interface debe cumplir -
 * Esto se puede entender como que cualquier clase que utilice AutorRepository, tendrá acceso a los métodos
 * obtenerAutoresPorNacionalidad y agregarAutor
 * */

public interface AutorRepository {

    List<Autor> obtenerAutoresPorNacionalidad(String nacionalidad) ;
    void  agregarAutor(Autor autor);
}
