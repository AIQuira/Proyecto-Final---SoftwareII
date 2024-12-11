package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Infrastructure;

import org.springframework.stereotype.Service;

import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.observer.Subject;

@Service
public class NotificationService extends Subject{
    public void notifyAutores (String message){
        this.notifyObservers(message);
    }

    public void notifyOrganizadores (String message){
        this.notifyObservers(message);
    }

    public void notifyRevisores (String message){
        this.notifyObservers(message);
    }
}
