package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion;

public class Correo implements MecanismoComunicacion {

    @Override
    public boolean enviarNotificacion(String mensaje, String datosReceptor) {
        boolean bandera = true;
        System.out.println("Enviando notificacion por correo electronico");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Datos del receptor: " + datosReceptor);
        return bandera;
    }
    
}
