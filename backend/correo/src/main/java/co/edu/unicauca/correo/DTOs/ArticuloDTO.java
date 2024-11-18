package co.edu.unicauca.correo.DTOs;

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
    	
    public ArticuloDTO(){

    }
}
