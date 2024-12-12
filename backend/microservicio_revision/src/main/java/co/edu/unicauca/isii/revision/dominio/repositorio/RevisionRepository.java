package co.edu.unicauca.isii.revision.dominio.repositorio;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.isii.revision.dominio.modelo.Estado;
import co.edu.unicauca.isii.revision.dominio.modelo.RevisionEntity;

@Repository
public class RevisionRepository {
    
    private ArrayList<RevisionEntity> listaRevisiones;

    public RevisionRepository() {
        this.listaRevisiones = new ArrayList<>();
        cargarRevisiones();
    }

    /**
     * @brief Método para guardar una revisión
     * @param revision
     * @return revisión guardada
     */
    public RevisionEntity guardarRevision(RevisionEntity revision) {
        System.out.println("Invocando a guardar revisión de un artículo");
        RevisionEntity objRevision = null;
        if (this.listaRevisiones.add(revision)) {
            objRevision = revision;
        }
        return objRevision;
    }

    /**
     * @brief Método para listar todas las revisiones
     * @return lista de revisiones
     */
    public ArrayList<RevisionEntity> listarRevisiones() {
        System.out.println("Invocando a listar revisiones");
        return this.listaRevisiones;
    }

    /**
     * @brief Método para buscar una revisión por ID
     * @param id
     * @return revisión encontrada o null si no encuentra la revisión
     */
    public RevisionEntity buscarPorId(Integer id) {
        System.out.println("Invocando a buscar revisión por ID");
        for (RevisionEntity revision : this.listaRevisiones) {
            if (revision.getId().equals(id)) {
                return revision;
            }
        }
        return null; // Retorna null si no encuentra la revisión
    }

    /**
     * @brief Método para buscar una revisión por ID del artículo
     */
    private void cargarRevisiones() {
        RevisionEntity revision1 = new RevisionEntity(1, 1, 1, Estado.RECIBIDO, 0, 0, 0, 0, "Revisión inicial");
        this.listaRevisiones.add(revision1);

        RevisionEntity revision2 = new RevisionEntity(2, 2, 2, Estado.RECIBIDO, 0, 0, 0, 0, "Revisión inicial");
        this.listaRevisiones.add(revision2);

        RevisionEntity revision3 = new RevisionEntity(3, 3, 1, Estado.RECIBIDO, 0, 0, 0, 0, "Revisión inicial");
        this.listaRevisiones.add(revision3);
    }
}
