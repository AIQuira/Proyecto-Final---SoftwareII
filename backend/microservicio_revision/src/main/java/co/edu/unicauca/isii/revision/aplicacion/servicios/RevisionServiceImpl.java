package co.edu.unicauca.isii.revision.aplicacion.servicios;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.isii.revision.dominio.modelo.RevisionEntity;
import co.edu.unicauca.isii.revision.dominio.repositorio.RevisionRepository;
import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisionDTO;
import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisorConArticulos.ArticuloDTO;

@Service
public class RevisionServiceImpl implements IRevisionService {

    private RevisionRepository revisionRepository;
    private ArticuloService servicioConsumirObtencionArticulo; // Servicio para interactuar con el microservicio de artículos
    private ModelMapper modelMapper;

    public RevisionServiceImpl(RevisionRepository revisionRepository, ArticuloService servicioConsumirObtencionArticulo, ModelMapper modelMapper) {
        this.revisionRepository = revisionRepository;
        this.servicioConsumirObtencionArticulo = servicioConsumirObtencionArticulo;
        this.modelMapper = modelMapper;
    }

    @Override
    public RevisionDTO guardarRevision(RevisionDTO revision) {
        RevisionEntity revisionEntity = this.modelMapper.map(revision, RevisionEntity.class);
        RevisionEntity objRevisionEntity = this.revisionRepository.guardarRevision(revisionEntity);
        calificarArticulo(revision);
        return this.modelMapper.map(objRevisionEntity, RevisionDTO.class);
    }

    @Override
    public List<RevisionDTO> listarRevisiones() {
        List<RevisionEntity> listaRevisiones = this.revisionRepository.listarRevisiones();
        return this.modelMapper.map(listaRevisiones, new TypeToken<List<RevisionDTO>>() {}.getType());
    }

    @Override
    public List<ArticuloDTO> listarArticulosDeRevisor(Integer idRevisor) {
        List<ArticuloDTO> listaArticulos = this.servicioConsumirObtencionArticulo.listarArticulosDeRevisor(idRevisor);
        return listaArticulos;
    }

    public RevisionDTO calificarArticulo (RevisionDTO revision) {
        System.out.println("Invocando a calificar un artículo");

        ArticuloDTO articulo = servicioConsumirObtencionArticulo.consultarArticuloDTO(revision.getArticuloId());
        if (articulo == null) {
            throw new IllegalArgumentException("El artículo con ID " + revision.getArticuloId() + " no existe.");
        }

        articulo.setEstado(revision.getEstado().toString());
        articulo.setCalificacionTitulo(revision.getCalificacionTitulo());
        articulo.setCalificacionDescripcion(revision.getCalificacionDescripcion());
        articulo.setCalificacionResumen(revision.getCalificacionResumen());
        articulo.setCalificacionKeyword(revision.getCalificacionKeyword());

        try {
            this.servicioConsumirObtencionArticulo.actualizarArticuloDTO(articulo, articulo.getIdArticulo());
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el artículo con ID " + articulo.getIdArticulo(), e);
        }

        return revision;
    }
}
