/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.mvc.modelos;

/**
 *
 * @author anais
 */
public class Revision {
    private Integer id;
    private Integer articuloId;
    private Integer revisorId;
    private String estado;
    private Integer calificacionTitulo;
    private Integer calificacionDescripcion;
    private Integer calificacionResumen;
    private Integer calificacionKeyword;
    private String comentarios;

    public Revision() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
    }

    public Integer getRevisorId() {
        return revisorId;
    }

    public void setRevisorId(Integer revisorId) {
        this.revisorId = revisorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
