package co.unicauca.conferencia.core.services;

import java.util.List;
import co.unicauca.conferencia.core.fachadaServices.DTO.ConferenceDTO;

/**
 * Interface de los servicios de la conferencia
 */
public interface IConferenceService {

    public List<ConferenceDTO> findAll();
    public ConferenceDTO findById(Integer id);
    public ConferenceDTO findByName(String nombre);
    public ConferenceDTO findByDate(String fecha);
    public ConferenceDTO save(ConferenceDTO conference);
    public ConferenceDTO update(Integer id, ConferenceDTO conference);
    public boolean delete(Integer id);    
}
