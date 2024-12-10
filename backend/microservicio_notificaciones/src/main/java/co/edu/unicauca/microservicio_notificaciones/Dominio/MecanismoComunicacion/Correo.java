package co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion;

public class Correo implements MecanismoComunicacion {
    @Override
    public boolean enviarNotificacion(String mensaje, String receptor) {
        boolean bandera = true;
        System.out.println("Enviando notificacion por correo electronico");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Receptor: " + receptor);
        return bandera;
    }
    
}
