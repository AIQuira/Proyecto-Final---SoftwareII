package co.edu.unicauca.mvc.modelos;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
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
    private List<Revisor> listaRevisores;
    
    private Conferencia objConferencias;

    // Constructor sin calificaciones (para cuando el autor envía el artículo inicialmente) 
    public Articulo(int idArticulo, String titulo, String descripcion, String resumen, String keyword, List<Revisor> listaRevisores) {
        this.idArticulo = idArticulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.resumen = resumen;
        this.keyword = keyword;
        this.listaRevisores = (listaRevisores != null) ? listaRevisores : new ArrayList<>();
    }

   public Articulo()
   {
       
   }

    public Articulo( String titulo, String resumen, String keyword, String estado, String descripcion) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.keyword = keyword;
        this.estado = estado;
        this.descripcion = descripcion;
    }
    

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public void setObjConferencia(Conferencia objConferencia) {
        this.objConferencias = objConferencia;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Conferencia getObjConferencia() {
        return objConferencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCalificacionTitulo() {
        return calificacionTitulo;
    }

    public void setCalificacionTitulo(Integer calificacionTitulo) {
        this.calificacionTitulo = calificacionTitulo;
    }

    public Integer getCalificacionDescripcion() {
        return calificacionDescripcion;
    }

    public void setCalificacionDescripcion(Integer calificacionDescripcion) {
        this.calificacionDescripcion = calificacionDescripcion;
    }

    public Integer getCalificacionResumen() {
        return calificacionResumen;
    }

    public void setCalificacionResumen(Integer calificacionResumen) {
        this.calificacionResumen = calificacionResumen;
    }

    public Integer getCalificacionKeyword() {
        return calificacionKeyword;
    }

    public void setCalificacionKeyword(Integer calificacionKeyword) {
        this.calificacionKeyword = calificacionKeyword;
    }

    public List<Revisor> getListaRevisores() {
        return listaRevisores;
    }

    public void setListaRevisores(List<Revisor> listaRevisores) {
        this.listaRevisores = listaRevisores;
    }

}
