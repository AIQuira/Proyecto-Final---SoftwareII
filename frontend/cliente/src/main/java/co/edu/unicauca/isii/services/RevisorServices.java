package co.edu.unicauca.isii.services;

import co.edu.unicauca.mvc.modelos.Revisor;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;
/**
 *
 * @author anais
 */
public class RevisorServices {
    private String endPoint;
    private Client client;
    
    public RevisorServices () {
        this.endPoint = "http://localhost:8085/api/revisor";
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Revisor consultarRevisor(Integer id) {
        Revisor objRevisor = null;
        WebTarget target = client.target(this.endPoint).path(String.valueOf(id));
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objRevisor = objPeticion.get(Revisor.class);
        return objRevisor;
    }
    
    public List<Revisor> listarRevisores() {
        List<Revisor> listaRevisores = null;
        WebTarget target = this.client.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        listaRevisores = objPeticion.get(new GenericType<List<Revisor>>() {});
        return listaRevisores;
    }
    
    public Revisor actualizarRevisor (Revisor objRevisorActualizar, Integer id) {
        Revisor objRevisor = null;
        WebTarget target = this.client.target(this.endPoint+"/"+id);
        Entity<Revisor> data = Entity.entity(objRevisorActualizar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objRevisor = objPeticion.put(data, Revisor.class);
        return objRevisor;
    }
    
    public Boolean eliminarRevisor (Integer id) {
        Boolean bandera = false;
        WebTarget target = this.client.target(this.endPoint+"/"+id);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        bandera = objPeticion.delete(Boolean.class);
        return bandera;
    }
}
