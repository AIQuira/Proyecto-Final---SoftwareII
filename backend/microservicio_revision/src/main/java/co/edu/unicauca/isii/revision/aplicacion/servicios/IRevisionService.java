package co.edu.unicauca.isii.revision.aplicacion.servicios;

import java.util.List;

import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisionDTO;
import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisorConArticulos.ArticuloDTO;

public interface IRevisionService {

    public RevisionDTO guardarRevision(RevisionDTO revision);
    public List<RevisionDTO> listarRevisiones();
    public List<ArticuloDTO> listarArticulosDeRevisor(Integer idRevisor);
}
