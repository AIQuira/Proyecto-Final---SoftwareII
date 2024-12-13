package co.edu.unicauca.mvc.modelos;

import java.util.Date;

public class Conferencia {
    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;  
    private String tema;
    private String descripcion;
    private Organizador organizador;
    
    public Conferencia(){
        
    }

    public Conferencia(int idConferencia, String nombre, String lugar, String tema, String descripcion, String contacto, Date fechaInicio, Date fechaFin, float costoInscripcion, Organizador organizador, String ponente) {
        this.id = idConferencia;
        this.nombre = nombre;
        this.tema = tema;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.organizador = organizador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }

}
