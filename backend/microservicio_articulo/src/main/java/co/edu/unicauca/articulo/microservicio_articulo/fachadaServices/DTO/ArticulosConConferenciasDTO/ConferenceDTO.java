package co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceDTO {
    private Integer id;
    private String nombre;
    private String lugar;
    private Date fecha;
    private String tema;
    private String descripcion;
    private String contacto;

    public ConferenceDTO()
    {

    }
}
