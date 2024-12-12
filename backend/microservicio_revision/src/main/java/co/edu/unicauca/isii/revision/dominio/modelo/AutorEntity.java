package co.edu.unicauca.isii.revision.dominio.modelo;

//import java.util.List;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter

/**
 * @class Autor
 * @brief Representa un autor que puede enviar artículos para revisión.
 */
public class AutorEntity extends Persona{
    
    //private List<ArticuloEntity> listaArticulos;

    /**
     * @brief Constructor de la clase Autor.
     * @param cedula Número de identificación del autor.
     * @param nombre Nombre del autor.
     * @param correo Correo electrónico del autor.
     * @param password Contraseña del autor.
     * @param telefono Número de teléfono del autor.
     * @param rol ID del rol del autor.
     */
    public AutorEntity(int cedula, String nombre, String correo, String password, Long telefono, int rol) {
        super(cedula, nombre, correo, password, telefono, rol);
    }

    /**
     * @brief Obtiene la lista de artículos enviados por el autor.
     * @return Lista de artículos.
     */
    /*public List<ArticuloEntity> getListaArticulos() {
        return listaArticulos;
    }*/

    /**
     * @brief Establece la lista de artículos enviados por el autor.
     * @param listaArticulos Lista de artículos a establecer.
     */
    /*public void setListaArticulos(List<ArticuloEntity> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }*/
    
}
