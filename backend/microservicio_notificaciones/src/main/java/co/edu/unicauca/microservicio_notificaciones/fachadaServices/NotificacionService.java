package main.java.co.edu.unicauca.microservicio_notificaciones.fachadaServices;

import main.java.co.edu.unicauca.microservicio_notificaciones.fachadaServices.DTOs.ArticuloDTO;
import main.java.co.edu.unicauca.microservicio_notificaciones.fachadaServices.subject;

@Service
public class NotificacionService extends subject{

    public void notifyOrganizadores(String message){
        this.notifyObservers("Organizadores: "+ message);
    }

    public void notifyAutores(String message){
        this.notifyObservers("Autores: "+ message);
    }

    public void notifyRevisores(String message){
        this.notifyObservers("Revisores: "+ message);
    }
    
}
