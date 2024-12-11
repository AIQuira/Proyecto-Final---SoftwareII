package main.java.co.edu.unicauca.microservicio_notificaciones.Dominio;

import main.java.co.edu.unicauca.microservicio_notificaciones.Dominio.Observer.Observer;

public class Autor implements Observer {
    private String nombre;
    private String email;

    public Autor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Estimado " + nombre + " el articulo " + message + " ha sido publicado");
    }
    
}
