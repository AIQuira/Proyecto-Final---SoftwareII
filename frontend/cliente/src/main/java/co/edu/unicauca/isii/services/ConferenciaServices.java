/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.isii.services;

import co.edu.unicauca.mvc.modelos.Conferencia;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author anais
 */
public class ConferenciaServices {
    private String endPoint;
    private Client client;
    
    public ConferenciaServices () {
        this.endPoint = "http://localhost:2702/api/conferences";
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Conferencia registrarConferencia(Conferencia objConferenciaRegistrar) {
        Conferencia objConferencia = null;
        WebTarget target = this.client.target(this.endPoint);
        Entity<Conferencia> data = Entity.entity(objConferenciaRegistrar, MediaType.APPLICATION_JSON_TYPE);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objConferencia = objPeticion.post(data, Conferencia.class);
        return objConferencia;
    }
    
    public Conferencia consultarConferencia(Integer id) {
        Conferencia objConferencia = null;
        WebTarget target = client.target(this.endPoint).path(String.valueOf(id));
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objConferencia = objPeticion.get(Conferencia.class);
        return objConferencia;
    }
    
    public List<Conferencia> listarConferencias() {
        List<Conferencia> listaConferencias = null;
        WebTarget target = this.client.target(this.endPoint);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        listaConferencias = objPeticion.get(new GenericType<List<Conferencia>>() {});
        return listaConferencias;
    }
    
    public Conferencia actualizarConferencia (Conferencia objConferenciaActualizar, Integer id) {
        Conferencia objConferencia = null;
        WebTarget target = this.client.target(this.endPoint+"/"+id);
        Entity<Conferencia> data = Entity.entity(objConferenciaActualizar, MediaType.APPLICATION_JSON_TYPE);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objConferencia = objPeticion.put(data, Conferencia.class);
        return objConferencia;
    }
    
    public Boolean eliminarConferencia (Integer id) {
        Boolean bandera = false;
        WebTarget target = this.client.target(this.endPoint+"/"+id);
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        bandera = objPeticion.delete(Boolean.class);
        return bandera;
    }
}
