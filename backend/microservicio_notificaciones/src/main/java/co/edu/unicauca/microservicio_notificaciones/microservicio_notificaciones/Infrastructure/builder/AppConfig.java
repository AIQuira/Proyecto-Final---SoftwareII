package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Infrastructure.builder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Domain.builder.Builder;

@Configuration
public class AppConfig {
    @Bean
    public Builder builder(){
        return new Builder();
    }
}
