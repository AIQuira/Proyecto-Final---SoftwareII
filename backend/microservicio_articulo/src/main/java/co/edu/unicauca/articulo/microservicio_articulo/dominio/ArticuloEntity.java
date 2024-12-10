package co.edu.unicauca.articulo.microservicio_articulo.dominio;

import java.util.ArrayList;
import java.util.List;

import co.edu.unicauca.articulo.microservicio_articulo.dominio.estados.EstadoBorrador;
import co.edu.unicauca.articulo.microservicio_articulo.dominio.estados.IEstado;
import co.edu.unicauca.articulo.microservicio_articulo.dominio.estados.Resultado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloEntity {
    private int idArticulo;
    private String titulo;
    private String descripcion;
    private String resumen;
    private String keyword;
    private Integer calificacionTitulo;
    private Integer calificacionDescripcion;
    private Integer calificacionResumen;
    private Integer calificacionKeyword;
    private List<RevisorEntity> listaRevisores;
    private IEstado estado = new EstadoBorrador();

    // Constructor sin calificaciones (para cuando el autor envía el artículo inicialmente)
    public ArticuloEntity(int idArticulo, String titulo, String descripcion, String resumen, String keyword, List<RevisorEntity> listaRevisores) {
        this.idArticulo = idArticulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.keyword = keyword;
        this.listaRevisores = (listaRevisores != null) ? listaRevisores : new ArrayList<>();
    }

    public ArticuloEntity() {
    } 

    public Resultado enviarArticulo() {
        return this.estado.enviarArticulo(this);
    }

    public Resultado revisionArticulo() {
        return this.estado.revisionArticulo(this);
    }

    public Resultado requiereRevisionArticulo() {
        return this.estado.requiereRevisionArticulo(this);
    }

    public Resultado aprobarArticulo() {
        return this.estado.aprobarArticulo(this);
    }

    public Resultado rechazarArticulo() {
        return this.estado.rechazarArticulo(this);
    }
}
