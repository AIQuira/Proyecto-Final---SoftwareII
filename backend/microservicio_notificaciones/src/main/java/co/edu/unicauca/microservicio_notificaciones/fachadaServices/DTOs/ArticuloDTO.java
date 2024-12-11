package co.edu.unicauca.microservicio_notificaciones.fachadaServices.DTOs;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@Getter
@Setter
public class ArticuloDTO {
    private String titulo;
    private String descripcion;
    private String resumen;
    private String keyword;
    private String tipoMecanismoComunicacion;
    	
    public ArticuloDTO(){

    }
}
