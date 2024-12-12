package co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisorConArticulos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloDTO {
    private int idArticulo;
    private String estado;
    private String titulo;
    private String descripcion;
    private String resumen;
    private String keyword;
    private Integer calificacionTitulo;
    private Integer calificacionDescripcion;
    private Integer calificacionResumen;
    private Integer calificacionKeyword;

    public ArticuloDTO(){

    }
    
    // Constructor sin calificaciones (para cuando el autor envía el artículo inicialmente)
    public ArticuloDTO(String titulo, String descripcion, String resumen, String keyword) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.keyword = keyword;
    }
}
