package co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO;

import java.util.List;

import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloConConferenciasDTO {
    private ArticuloDTO objArticuloDTO;
    private List<ConferenceDTO> conferencias;
}
