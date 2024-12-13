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
    private Date fechaInicio;
    private Date fechaFin;
    private String tema;
    private String descripcion;

    public ConferenceDTO()
    {

    }
}
