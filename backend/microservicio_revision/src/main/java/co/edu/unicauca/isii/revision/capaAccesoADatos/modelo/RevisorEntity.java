package co.edu.unicauca.isii.revision.capaAccesoADatos.modelo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/**
 * @class Revisor
 * @brief Representa un revisor que puede calificar artículos.
 */
public class RevisorEntity extends Persona {

    private String tituloUniversitario;

    /**
     * @brief Constructor de la clase Revisor.
     * @param cedula Número de identificación del revisor.
     * @param nombre Nombre del revisor.
     * @param correo Correo electrónico del revisor.
     * @param password Contraseña del revisor.
     * @param telefono Número de teléfono del revisor.
     * @param rol ID del rol del revisor.
     * @param tituloUniversitario Título académico del revisor.
     */
    public RevisorEntity(int cedula, String nombre, String correo, String password, Long telefono, int rol, String tituloUniversitario) {
        super(cedula, nombre, correo, password, telefono, rol);
        this.tituloUniversitario = tituloUniversitario;
    }

    /**
     * @brief Califica los atributos de un artículo.
     * @param articulo El artículo a calificar.
     * @param calTitulo Calificación para el título.
     * @param calDescripcion Calificación para la descripción.
     * @param calResumen Calificación para el resumen.
     * @param calKeyword Calificación para las palabras clave.
     */
    /*public void calificarArticulo(ArticuloEntity articulo, Integer calTitulo, Integer calDescripcion, Integer calResumen, Integer calKeyword) {
        articulo.setCalificacionTitulo(calTitulo);
        articulo.setCalificacionDescripcion(calDescripcion);
        articulo.setCalificacionResumen(calResumen);
        articulo.setCalificacionKeyword(calKeyword);
    }*/
}
