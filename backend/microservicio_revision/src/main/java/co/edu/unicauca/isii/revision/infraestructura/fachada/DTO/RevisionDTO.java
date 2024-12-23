package co.edu.unicauca.isii.revision.infraestructura.fachada.DTO;

import co.edu.unicauca.isii.revision.dominio.modelo.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RevisionDTO {
    private Integer id;
    private Integer articuloId;
    private Integer revisorId;
    private Estado estado;
    private Integer calificacionTitulo;
    private Integer calificacionDescripcion;
    private Integer calificacionResumen;
    private Integer calificacionKeyword;
    private String comentarios;

    public RevisionDTO() {
        
    }
}
