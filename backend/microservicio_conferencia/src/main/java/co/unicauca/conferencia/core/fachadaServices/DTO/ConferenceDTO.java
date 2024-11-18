package co.unicauca.conferencia.core.fachadaServices.DTO;

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
    private String lugar;
    private String fecha;
    private String tema;
    private String descripcion;
    private String contacto;

    public ConferenceDTO() {
    }
}
