/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.isii.services;

import java.util.List;

import co.edu.unicauca.mvc.modelos.Articulo;
import co.edu.unicauca.mvc.modelos.Conferencia;
import co.edu.unicauca.mvc.modelos.Revision;
import co.edu.unicauca.mvc.modelos.Revisor;

/**
 *
 * @author anais
 */
public class ServicesFacade {
    
    private ArticuloServices articuloServices;
    private ConferenciaServices conferenciaServices;
    private RevisionServices revisionServices;
    private RevisorServices revisorServices;
    
    public ServicesFacade() {
        this.articuloServices = new ArticuloServices();
        this.conferenciaServices = new ConferenciaServices();
        this.revisionServices = new RevisionServices();
        this.revisorServices = new RevisorServices();
    }

    //Métodos para interactuar con ArticuloService
    public Articulo registraArticulo (Articulo articulo) {
        return articuloServices.registrarArticulo(articulo);
    }

    public Articulo consultarArticulo (Integer id) {
        return articuloServices.consultarArticulo(id);
    }

    public List<Articulo> listarArticulos() {
        return articuloServices.listarArticulos();
    }

    public Articulo actualizarArticulo (Articulo articulo, Integer id) {
        return articuloServices.actualizarArticulo(articulo, id);
    }

    public Boolean eliminarArticulo (Integer id) {
        return articuloServices.eliminarArticulo(id);
    }

    //Métodos para interactuar con ConferenciaService
    public Conferencia registraConferencia (Conferencia conferencia) {
        return conferenciaServices.registrarConferencia(conferencia);
    }

    public Conferencia consultarConferencia (Integer id) {
        return conferenciaServices.consultarConferencia(id);
    }

    public List<Conferencia> listarConferencias() {
        return conferenciaServices.listarConferencias();
    }

    public Conferencia actualizarConferencia (Conferencia conferencia, Integer id) {
        return conferenciaServices.actualizarConferencia(conferencia, id);
    }

    public Boolean eliminarConferencia (Integer id) {
        return conferenciaServices.eliminarConferencia(id);
    }

    //Métodos para interactuar con RevisionService
    public Revision registrarRevision (Revision revision) {
        return revisionServices.registrarRevision(revision);
    }

    public List<Revision> listarRevisiones() {
        return revisionServices.listarRevisiones();
    }

    public List<Articulo> listarArticulosRevisor (int idRevisor) {
        return revisionServices.listarArticulosRevisor(idRevisor);
    }

    public boolean calificarArticulo (Integer id, int calificacion) {
        return revisionServices.calificarArticulo(id, calificacion);
    }

    //Métodos para interactuar con RevisorService
    public Revisor registraRevisor (Revisor revisor) {
        return revisorServices.registrarRevisor(revisor);
    }

    public Revisor consultarRevisor (Integer id) {
        return revisorServices.consultarRevisor(id);
    }

    public List<Revisor> listarRevisores() {
        return revisorServices.listarRevisores();
    }

    public Revisor actualizarRevisor (Revisor revisor, Integer id) {
        return revisorServices.actualizarRevisor(revisor, id);
    }

    public Boolean eliminarRevisor (Integer id) {
        return revisorServices.eliminarRevisor(id);
    }
    
}
