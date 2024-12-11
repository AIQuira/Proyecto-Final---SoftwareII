package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion;

public interface MecanismoComunicacion {
    public boolean enviarNotificacion(String mensaje, String datosReceptor);
}
