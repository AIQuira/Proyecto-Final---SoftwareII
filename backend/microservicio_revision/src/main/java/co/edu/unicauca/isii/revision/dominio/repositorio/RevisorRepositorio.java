package co.edu.unicauca.isii.revision.dominio.repositorio;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.isii.revision.dominio.modelo.RevisorEntity;

@Repository
public class RevisorRepositorio {
    
    private ArrayList<RevisorEntity> listaRevisores;

    public RevisorRepositorio() {
        this.listaRevisores = new ArrayList<>();
        cargarRevisores();
    }

    /**
     * @brief Método para grabar revisores
     * @param revisor
     * @return revisor guardado
     */
    private void cargarRevisores() {
        RevisorEntity revisor1 = new RevisorEntity(12345, "Carlos Pérez", "carlosperez@gmail.com", "123456", 3124567890L, 2, "Doctorado en Computación");
        this.listaRevisores.add(revisor1);
        RevisorEntity revisor2 = new RevisorEntity(67890, "Ana Guzman", "anaguzman@gmail.com", "678900", 3154567895L, 2, "Maestria en Ingenieria de Software");
        this.listaRevisores.add(revisor2);
        RevisorEntity revisor3 = new RevisorEntity(11223, "Andres Gonzales", "andresgonzales@gmail.com", "af12345", 3147859652L, 2, "Licenciatura en Ciencias de la Información");
        this.listaRevisores.add(revisor3);
    }
}
