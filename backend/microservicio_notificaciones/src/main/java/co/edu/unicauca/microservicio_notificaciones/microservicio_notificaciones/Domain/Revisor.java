package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain;

import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.observer.Observer;

public class Revisor implements Observer{

    private String nombre;
    private String correo;

    public Revisor(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public void update(String message) {
        System.out.println("Revisor: " + nombre + " con correo: " + correo + " ha recibido el mensaje: " + message);
    }

}
