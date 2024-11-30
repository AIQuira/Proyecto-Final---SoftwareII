package co.edu.unicauca.mvc.modelos;

import java.util.Date;

public class Conferencia {
    private int idConferencia;
    private String nombre;
    private String lugar;
    private String tema;
    private String descripcion;
    private String contacto;
    private Date fechaInicio;
    private Date fechaFin;   
    private float costoInscripcion;
    private String ponente;
    private Organizador organizador;
    
    public Conferencia(){
        
    }

    public Conferencia(int idConferencia, String nombre, String lugar, String tema, String descripcion, String contacto, Date fechaInicio, Date fechaFin, float costoInscripcion, Organizador organizador, String ponente) {
        this.idConferencia = idConferencia;
        this.nombre = nombre;
        this.lugar = lugar;
        this.tema = tema;
        this.descripcion = descripcion;
        this.contacto = contacto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoInscripcion = costoInscripcion;
        this.organizador = organizador;
        this.ponente = ponente;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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


    public float getCostoInscripcion() {
        return costoInscripcion;
    }

    public void setCostoInscripcion(float costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
    }
    
     public String getPonente() {
        return ponente;
    }

    public void setPonente(String ponente) {
        this.ponente = ponente;
    }
    
    @Override
    public String toString()
    {
        return this.nombre;
    }

}
