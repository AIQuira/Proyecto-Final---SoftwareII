package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.Builder;
import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.MecanismoComunicacion.MecanismoComunicacion;
import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Infrastructure.DTOs.ArticuloDTO;



@Service
public class MessageConsumer {
    
    private final Builder builder;

    @Autowired
    public MessageConsumer(Builder builder) {
        this.builder = builder;
    }

    @RabbitListener(queues = "temacorreo")
    public void receiveMessage(ArticuloDTO objArticuloCreado) {
        String mensaje = "Se ha creado un nuevo articulo con los siguientes datos: \n"
                + "Titulo: " + objArticuloCreado.getTitulo() + "\n"
                + "Descripcion: " + objArticuloCreado.getDescripcion() + "\n"
                + "Resumen: " + objArticuloCreado.getResumen() + "\n"
                + "Keyword: " + objArticuloCreado.getKeyword();

        String receptor = "";
        int tipoMecanismo =  1;
        //Generar el mecanismo de comunicacion
        MecanismoComunicacion mecanismoComunicacion = builder.generarMecanismoComunicacion(tipoMecanismo);
        mecanismoComunicacion.enviarNotificacion(mensaje, receptor);
    }
}
