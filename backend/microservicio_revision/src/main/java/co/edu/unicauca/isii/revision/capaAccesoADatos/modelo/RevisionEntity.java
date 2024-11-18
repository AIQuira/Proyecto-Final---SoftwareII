package co.edu.unicauca.isii.revision.capaAccesoADatos.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RevisionEntity {
    private Integer id;
    private Integer articuloId;
    private Integer revisorId;
    private Estado estado;
    private Integer calificacionTitulo;
    private Integer calificacionDescripcion;
    private Integer calificacionResumen;
    private Integer calificacionKeyword;
    private String comentarios;

    public RevisionEntity() {
        
    }
}
