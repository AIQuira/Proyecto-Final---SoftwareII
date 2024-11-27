package co.unicauca.conferencia.core.accesoDatos.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import co.unicauca.conferencia.core.accesoDatos.model.ConferenceEntity;

import org.springframework.stereotype.Repository;

@Repository
public class ConferenceRepository {

    private ArrayList<ConferenceEntity> listaConferencias;

    public ConferenceRepository() {
        this.listaConferencias = new ArrayList<ConferenceEntity>();
        cargarConferencia();
    }

    /**
     * Constructor que inicializa la lista de conferencias
     */
    public List<ConferenceEntity> findAll() {
        System.out.println("Invocando a Listar Conferencias");
        return this.listaConferencias;
    }

    /**
     * Busca una conferencia por su Id
     * 
     * @param id
     * @return
     */
    public ConferenceEntity findById(Integer id) {
        System.out.println("Invocando a buscar cliente por Id");
        ConferenceEntity objConference = null;

        for (ConferenceEntity conference : listaConferencias) {
            if (conference.getId().equals(id)) {
                objConference = conference;
                break;
            }
        }

        return objConference;
    }

    public ConferenceEntity findByName(String nombre) {
        System.out.println("Invocando a buscar conferencia por nombre");
        ConferenceEntity objConference = null;

        for (ConferenceEntity conference : listaConferencias) {
            if (conference.getNombre().equals(nombre)) {
                objConference = conference;
                break;
            }
        }

        return objConference;
    }

    public ConferenceEntity findByfecha(String fecha) {
        System.out.println("Invocando a buscar conferencia por fecha");
        ConferenceEntity objConference = null;

        for (ConferenceEntity conference : listaConferencias) {
            if (conference.getFecha().equals(fecha)) {
                objConference = conference;
                break;
            }
        }

        return objConference;
    }
    /**
     * Guarda una conferencia
     * 
     * @param conference
     * @return
     */
    public ConferenceEntity save(ConferenceEntity conference) {
        System.out.println("Invocando a guardar Conferencia");
        ConferenceEntity objConference = null;

        if (this.listaConferencias.add(conference)) {
            objConference = conference;
        }

        return objConference;
    }

    /**
     * Modifica una conferencia por su Id
     * 
     * @param id
     * @param conference
     * @return
     */
    public ConferenceEntity update(Integer id, ConferenceEntity conference) {
        System.out.println("Invocando a actualizar Conferencia");
        ConferenceEntity objConference = null;

        for (int i = 0; i < this.listaConferencias.size(); i++) {
            if (this.listaConferencias.get(i).getId() == id) {
                this.listaConferencias.set(i, conference);
                objConference = conference;
                break;
            }
        }
        return objConference;
    }

    /**
     * Elimina una conferencia por su Id
     * 
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar Conferencia");
        boolean bandera = false;

        for (ConferenceEntity conference : listaConferencias) {
            if (conference.getId().equals(id)) {
                bandera = this.listaConferencias.remove(conference);
                break;
            }
        }

        return bandera;
    }

    private void cargarConferencia() {
        ConferenceEntity objCliente1 = new ConferenceEntity(1, "Google Chrome", "Bogota", new Date(), "navegadores web",
                "YYYY", "312745433");
        this.listaConferencias.add(objCliente1);
        ConferenceEntity objCliente2 = new ConferenceEntity(2, "Chat gpt ", "Bogota", new Date(),
                "inteligencia artificial", "YYYY", "354655768");
        this.listaConferencias.add(objCliente2);
        ConferenceEntity objCliente3 = new ConferenceEntity(3, "Bases de Datos", "manizales", new Date(),
                "bases de datos", "YYYY", "38668862");
        this.listaConferencias.add(objCliente3);

    }
}
