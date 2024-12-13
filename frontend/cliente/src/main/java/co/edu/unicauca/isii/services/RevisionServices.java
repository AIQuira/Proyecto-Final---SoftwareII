package co.edu.unicauca.isii.services;

import co.edu.unicauca.mvc.modelos.Articulo;
import co.edu.unicauca.mvc.modelos.Revision;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author earea
 */

/**
 * Servicio para manejar las acciones específicas del revisor sobre los artículos.
 */
public class RevisionServices {
    private String endPoint;
    private Client client;

    public RevisionServices() {
        this.endPoint = "http://localhost:2110/api/revisiones";
        this.client = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Revision registrarRevision(Revision objRevisionRegistrar){
        Revision objRevision = null;
        WebTarget target = this.client.target(this.endPoint);
        Entity<Revision> data = Entity.entity(objRevisionRegistrar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        objRevision = objPeticion.post(data, Revision.class);
        return objRevision;
    }
    
    public List<Revision> listarRevisiones (){
        List<Revision> listaRevisiones = null;
        WebTarget target = this.client.target(this.endPoint);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        listaRevisiones = objPeticion.get(new GenericType<List<Revision>>() {});
        return listaRevisiones;
    }
    
    public List<Articulo> listarArticulosRevisor (int idRevisor){
        List<Articulo> listaArticulos = null;
        WebTarget target = this.client.target(this.endPoint+"/articulos/"+idRevisor);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
        listaArticulos = objPeticion.get(new GenericType<List<Articulo>>() {});
        return listaArticulos;
    }

    // Método para calificar un artículo
    public boolean calificarArticulo(Integer id, int calificacion) {
        WebTarget target = client.target(this.endPoint).path("calificar").path(String.valueOf(id));
        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);
        Entity<Integer> calificacionEntity = Entity.entity(calificacion, MediaType.APPLICATION_JSON);
        try {
            objPeticion.put(calificacionEntity);
            return true;
        } catch (Exception e) {
            System.err.println("Error al calificar el artículo: " + e.getMessage());
            return false;
        }
    }
}
