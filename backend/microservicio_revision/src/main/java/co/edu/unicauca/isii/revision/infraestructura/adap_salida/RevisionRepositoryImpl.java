package co.edu.unicauca.isii.revision.infraestructura.adap_salida;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.isii.revision.dominio.modelo.RevisionEntity;
import co.edu.unicauca.isii.revision.dominio.puerto.RevisionRepositoryPort;

@Repository
public class RevisionRepositoryImpl implements RevisionRepositoryPort {

    private ArrayList<RevisionEntity> listaRevisiones = new ArrayList<>();

    @Override
    public RevisionEntity guardarRevision(RevisionEntity revision) {
        listaRevisiones.add(revision);
        return revision;
    }

    @Override
    public ArrayList<RevisionEntity> listarRevisiones() {
        return new ArrayList<>(listaRevisiones);
    }

    @Override
    public RevisionEntity buscarPorId(Integer id) {
        return listaRevisiones.stream()
                .filter(revision -> revision.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean eliminarRevision(Integer id) {
        return listaRevisiones.removeIf(revision -> revision.getId().equals(id));
    }
}

