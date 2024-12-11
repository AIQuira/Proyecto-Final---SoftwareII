package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder;

import org.springframework.stereotype.Service;

import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion.Correo;
import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion.MecanismoComunicacion;
import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion.SMS;

@Service
public class Builder {

    public Builder() {
    }

    public String getNombreMecanismo(int tipoMecanismo) {
        String mecanismo = "";
        switch (tipoMecanismo) {
            case 1:
                mecanismo = "SMS";
                break;
            case 2:
                mecanismo = "Correo";
                break;
            default:
                mecanismo = "WhatsApp";
                break;
        }
        return mecanismo;
    }

    public MecanismoComunicacion generarMecanismoComunicacion(int tipoMecanismo) {
        MecanismoComunicacion mecanismo = null;
        switch (tipoMecanismo) {
            case 1:
                mecanismo = new Correo();
                break;
            case 2:
                mecanismo = new SMS();
                break;
            default:
                break;
        }
        return mecanismo;
    }
    
}
