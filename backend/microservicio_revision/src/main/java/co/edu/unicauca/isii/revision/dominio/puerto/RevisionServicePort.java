package co.edu.unicauca.isii.revision.dominio.puerto;

import java.util.ArrayList;

import co.edu.unicauca.isii.revision.dominio.modelo.RevisionEntity;

public interface RevisionServicePort {
    RevisionEntity crearRevision(RevisionEntity revision);
    ArrayList<RevisionEntity> obtenerRevisiones();
    RevisionEntity buscarRevisionPorId(Integer id);
    boolean eliminarRevision(Integer id);
}
