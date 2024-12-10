package co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion;

public interface MecanismoComunicacion {
    public boolean enviarNotificacion(String mensaje, String receptor);
}
