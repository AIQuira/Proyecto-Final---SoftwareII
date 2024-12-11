package co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;

@Service
public class MessageProducer {
    private final AmqpTemplate amqpTemplate;
    private final String exchange = "myExchange";
    private final String routingKey = "routingKey";

    public MessageProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(ArticuloDTO objArticuloCreado) {
        amqpTemplate.convertAndSend(exchange, routingKey, objArticuloCreado);
        System.out.println("Datos del articulo enviado a la cola");
    }

    public void sendNotification(String message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Notificación enviada a la cola");
    }
}
