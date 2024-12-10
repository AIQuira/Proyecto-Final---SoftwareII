package co.edu.unicauca.microservicio_notificaciones.fachadaServices.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.microservicio_notificaciones.Dominio.Builder.Builder;

@Configuration
public class AppConfig {
    
    @Bean
    public Builder builder(){
        return new Builder();
    }
}
