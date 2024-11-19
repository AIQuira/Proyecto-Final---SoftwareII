package edu.co.unicauca.revisor.dataAccess.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.co.unicauca.revisor.dataAccess.model.RevisorEntity;

@Repository
public class RevisorRepository {

    private ArrayList<RevisorEntity> revisorList;

    public RevisorRepository() {
        this.revisorList = new ArrayList<>();
        cargarRevisor();
    }

    public List<RevisorEntity> findAll() {
        System.out.println("Revisores encontrados");
        return this.revisorList;
    }

    public RevisorEntity findById(Integer id) {
        for (RevisorEntity revisor : revisorList) {
            if (revisor.getId().equals(id)) {
                System.out.println("Revisor encontrado");
                return revisor;
            }
        }
        System.out.println("Revisor no encontrado");
        return null;
    }

    public RevisorEntity save(RevisorEntity revisor) {
        revisorList.add(revisor);
        System.out.println("Revisor guardado");
        return revisor;
    }

    public void delete(Integer id) {
        RevisorEntity revisor = findById(id);
        if (revisor != null) {
            revisorList.remove(revisor);
            System.out.println("Revisor eliminado");
        } else {
            System.out.println("Revisor no encontrado");
        }
    }

    public RevisorEntity update(Integer id, RevisorEntity revisor) {
        RevisorEntity revisorToUpdate = findById(id);
        if (revisorToUpdate != null) {
            revisorToUpdate.setNombre(revisor.getNombre());
            revisorToUpdate.setTelefono(revisor.getTelefono());
            revisorToUpdate.setEmail(revisor.getEmail());
            revisorToUpdate.setTitulo_universitario(revisor.getTitulo_universitario());
            System.out.println("Revisor actualizado");
            return revisorToUpdate;
        } else {
            System.out.println("Revisor no encontrado");
            return null;
        }
    }

    public void calificarTrabajo(Integer idTrabajo, Integer idRevisor, String calificacion) {
        System.out.println("Trabajo calificado");
        if(calificacion.equals("APROBADO")){
            System.out.println("Trabajo aprobado");
        }
        else{
            System.out.println("Trabajo rechazado");
        }
    }

    public void cargarRevisor() {
        RevisorEntity revisor1 = new RevisorEntity(1, "Juan Perez", 1234567, "juanperez@gmail.com", "Ingeniero ambiental");
        RevisorEntity revisor2 = new RevisorEntity(2, "Pedro Toledo", 1234567, "pedrotoledo@gmail.com", "Ingeniero civil");
        RevisorEntity revisor3 = new RevisorEntity(3, "Maria Lopez", 1234567, "marialopez@gmail.com", "Ingeniera biomedica");
        RevisorEntity revisor4 = new RevisorEntity(4, "Luisa Martinez", 1234567, "luisamartinez@gmail.com", "Bioquimica");
        save(revisor1);
        save(revisor2);
        save(revisor3);
        save(revisor4);
    }
}
