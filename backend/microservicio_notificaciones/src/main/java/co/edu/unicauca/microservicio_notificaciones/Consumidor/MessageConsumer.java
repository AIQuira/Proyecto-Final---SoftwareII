package co.edu.unicauca.microservicio_notificaciones.Consumidor;

import org.springframework.stereotype.Service;

import co.edu.unicauca.microservicio_notificaciones.Dominio.Builder.Builder;
import co.edu.unicauca.microservicio_notificaciones.Dominio.MecanismoComunicacion.MecanismoComunicacion;
import co.edu.unicauca.microservicio_notificaciones.fachadaServices.DTOs.ArticuloDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MessageConsumer {

    private final Builder builder;

    @Autowired
    public MessageConsumer(Builder builder) {
        this.builder = builder;
    }

    @RabbitListener(queues = "temacorreo")
    public void receiveMessage(ArticuloDTO objArticuloCreado) {
        System.out.println("Datos del articulo");
        System.out.println("Titulo: "+objArticuloCreado.getTitulo());
        System.out.println("Descripcion: "+objArticuloCreado.getDescripcion());
        System.out.println("Resumen: "+objArticuloCreado.getResumen());
        System.out.println("Keyword: "+objArticuloCreado.getKeyword());
        
        String mensaje = "Se ha creado un nuevo articulo con los siguientes datos: \n"
                + "Titulo: " + objArticuloCreado.getTitulo() + "\n"
                + "Descripcion: " + objArticuloCreado.getDescripcion() + "\n"
                + "Resumen: " + objArticuloCreado.getResumen() + "\n"
                + "Keyword: " + objArticuloCreado.getKeyword();

        String receptor = "";
        int tipoMecanismo = objArticuloCreado.getTipoMecanismoComunicacion();
        //Generar el mecanismo de comunicacion
        MecanismoComunicacion mecanismoComunicacion = builder.generarMecanismoComunicacion(tipoMecanismo);
        mecanismoComunicacion.enviarNotificacion(mensaje, tipoMecanismo);
    }
}
