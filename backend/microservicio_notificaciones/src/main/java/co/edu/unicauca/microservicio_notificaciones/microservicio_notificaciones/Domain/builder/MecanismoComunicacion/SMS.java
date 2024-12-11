package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion;

public class SMS implements MecanismoComunicacion{

    @Override
    public boolean enviarNotificacion(String mensaje, String datosReceptor) {
        boolean bandera = true;
        System.out.println("Enviando mensaje por SMS");
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Datos del receptor: " + datosReceptor);
        return bandera;
    }
    
}
