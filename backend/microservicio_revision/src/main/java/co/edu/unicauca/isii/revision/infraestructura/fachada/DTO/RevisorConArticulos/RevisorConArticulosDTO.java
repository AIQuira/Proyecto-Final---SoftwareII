package co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisorConArticulos;

import java.util.List;

import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RevisorConArticulosDTO {
    private RevisorDTO revisor;
    private List<ArticuloDTO> listaArticulos;
}
