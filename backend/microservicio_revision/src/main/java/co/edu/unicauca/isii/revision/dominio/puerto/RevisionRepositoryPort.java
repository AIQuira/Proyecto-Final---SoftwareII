package co.edu.unicauca.isii.revision.dominio.puerto;

import java.util.ArrayList;
import co.edu.unicauca.isii.revision.dominio.modelo.*;

public interface RevisionRepositoryPort {
    RevisionEntity guardarRevision(RevisionEntity revision);
    ArrayList<RevisionEntity> listarRevisiones();
    RevisionEntity buscarPorId(Integer id);
    boolean eliminarRevision(Integer id);
}

