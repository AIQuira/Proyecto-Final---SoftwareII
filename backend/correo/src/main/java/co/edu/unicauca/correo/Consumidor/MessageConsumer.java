package co.edu.unicauca.correo.Consumidor;

import org.springframework.stereotype.Service;

import co.edu.unicauca.correo.DTOs.ArticuloDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "temacorreo")
    public void receiveMessage(ArticuloDTO objArticuloCreado) {
        System.out.println("Datos del articulo");
        System.out.println("Enviando correo electrónico");
        System.out.println("Titulo: "+objArticuloCreado.getTitulo());
        System.out.println("Descripcion: "+objArticuloCreado.getDescripcion());
        System.out.println("Resumen: "+objArticuloCreado.getResumen());
        System.out.println("Keyword: "+objArticuloCreado.getKeyword());
        
    }
}
