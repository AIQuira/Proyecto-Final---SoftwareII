package co.edu.unicauca.correo;

import co.edu.unicauca.correo.DTOs.ArticuloDTO;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.awaitility.Awaitility.await;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class MessageConsumerIntegrationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testReceiveMessage() {
        // Crear un ArticuloDTO de prueba
        ArticuloDTO articulo = new ArticuloDTO();
        articulo.setTitulo("Test Titulo");
        articulo.setDescripcion("Test Descripcion");
        articulo.setResumen("Test Resumen");
        articulo.setKeyword("Test Keyword");

        // Enviar el mensaje a la cola "temacorreo"
        rabbitTemplate.convertAndSend("temacorreo", articulo);

        // Esperar unos segundos para garantizar que el consumidor procese el mensaje
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() -> {
            // Aquí podrías implementar lógica para verificar si el consumidor procesó el mensaje,
            // por ejemplo, con logs o persistiendo un cambio en una base de datos simulada.
            System.out.println("Mensaje enviado correctamente. Verifica logs para salida esperada.");
        });
    }
}
