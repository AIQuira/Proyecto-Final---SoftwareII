package co.edu.unicauca.microservicio_notificaciones.Dominio.Builder;

import co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion.MecanismoComunicacion;
import co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion.Correo;
import co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion.SMS;

public class Builder {
    public Builder() {

    }

    public String getNombreMecanismo(int tipoMecanismo) {
        String mecanismo = "";
        switch (tipoMecanismo) {
            case 1: 
                mecanismo = "Correo";
                break;
            case 2: 
                mecanismo = "SMS";
                break;
            case 3: 
                mecanismo = "Whatsapp";
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
        }
        return mecanismo;
    }

}
