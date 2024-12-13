package co.unicauca.conferencia.core.fachadaServices.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa la conferencia en la capa de servicios
 */
@Getter @Setter @AllArgsConstructor
public class ConferenceDTO {
    private Integer id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private String tema;
    private String descripcion;

    public ConferenceDTO() {
    }
}
