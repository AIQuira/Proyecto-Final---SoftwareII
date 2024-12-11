package co.edu.unicauca.microservicio_notificaciones.microservicio_notificaciones.Infrastructure.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ArticuloDTO {
    private String titulo;
    private String descripcion;
    private String resumen;
    private String keyword;
    private int tipoMecanismoComunicacion;
    	
    public ArticuloDTO(){

    }
}
