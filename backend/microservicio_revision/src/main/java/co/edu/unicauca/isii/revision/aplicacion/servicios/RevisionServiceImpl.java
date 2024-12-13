package co.edu.unicauca.isii.revision.aplicacion.servicios;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import co.edu.unicauca.isii.revision.dominio.modelo.RevisionEntity;
import co.edu.unicauca.isii.revision.dominio.puerto.RevisionRepositoryPort;
import co.edu.unicauca.isii.revision.dominio.puerto.RevisionServicePort;

@Service
public class RevisionServiceImpl implements RevisionServicePort {

    private final RevisionRepositoryPort revisionRepository;

    public RevisionServiceImpl(RevisionRepositoryPort revisionRepository) {
        this.revisionRepository = revisionRepository;
    }

    @Override
    public RevisionEntity crearRevision(RevisionEntity revision) {
        return revisionRepository.guardarRevision(revision);
    }

    @Override
    public ArrayList<RevisionEntity> obtenerRevisiones() {
        return revisionRepository.listarRevisiones();
    }

    @Override
    public RevisionEntity buscarRevisionPorId(Integer id) {
        return revisionRepository.buscarPorId(id);
    }

    @Override
    public boolean eliminarRevision(Integer id) {
        return revisionRepository.eliminarRevision(id);
    }
}
