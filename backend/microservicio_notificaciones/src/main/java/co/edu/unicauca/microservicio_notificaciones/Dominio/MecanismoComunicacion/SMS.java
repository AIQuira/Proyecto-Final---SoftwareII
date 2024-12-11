package main.java.co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion;

public class SMS implements MecanismoComunicacion {
    @Override
    public boolean enviarNotificacion(String mensaje, String receptor) {
        boolean bandera = true;
        System.out.println("Enviando notificacion al telefono por SMS");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Receptor: " + receptor);
        return bandera;
    }
    
}
