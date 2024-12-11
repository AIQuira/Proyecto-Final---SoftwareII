package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain;

import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.observer.Observer;

public class Organizador implements Observer {

    private String nombre;
    private String correo;

    public Organizador(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void update(String message) {
        System.out.println(correo + "\nEstimado " + nombre + ". Se ha enviado un nuevo articulo a una conferencia.");
    }
    
}
