package edu.co.unicauca.revisor.facadeServices.mapper;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {
    @Bean
    public ModelMapper modelMap() {
        return new ModelMapper();
    }

}
