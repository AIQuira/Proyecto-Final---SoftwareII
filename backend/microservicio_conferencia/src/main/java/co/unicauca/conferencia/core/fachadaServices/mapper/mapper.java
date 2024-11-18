package co.unicauca.conferencia.core.fachadaServices.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que permite mapear los objetos de la capa de acceso a datos con los objetos de la capa de servicios
 */
@Configuration
public class mapper {

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
}
