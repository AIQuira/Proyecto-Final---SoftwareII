package co.edu.unicauca.isii.revision.fachadaServicios.servicios;

import java.util.List;
import co.edu.unicauca.isii.revision.fachadaServicios.DTO.RevisionDTO;
import co.edu.unicauca.isii.revision.fachadaServicios.DTO.RevisorConArticulos.ArticuloDTO;

public interface IRevisionService {

    public RevisionDTO guardarRevision(RevisionDTO revision);
    public List<RevisionDTO> listarRevisiones();
    public List<ArticuloDTO> listarArticulosDeRevisor(Integer idRevisor);
}
