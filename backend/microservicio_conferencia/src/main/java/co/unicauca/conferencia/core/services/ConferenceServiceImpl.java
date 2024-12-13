package co.unicauca.conferencia.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import co.unicauca.conferencia.core.accesoDatos.model.ConferenceEntity;
import co.unicauca.conferencia.core.accesoDatos.repositories.ConferenceRepository;
import co.unicauca.conferencia.core.fachadaServices.DTO.ConferenceDTO;

/**
 * Implementación de los servicios de la conferencia
 */
@Service
public class ConferenceServiceImpl implements IConferenceService {

    @Autowired
    private ConferenceRepository servicioAccesoBD;

    @Autowired
    private ModelMapper modelMapper;

    public ConferenceServiceImpl(ConferenceRepository servicioAccesoBD, ModelMapper modelMapper) {
        this.servicioAccesoBD = servicioAccesoBD;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ConferenceDTO> findAll() {

        List<ConferenceEntity> conferencesEntity = this.servicioAccesoBD.findAll();
        List<ConferenceDTO> conferencesDTO = this.modelMapper.map(conferencesEntity,
                new TypeToken<List<ConferenceDTO>>() {
                }.getType());
        return conferencesDTO;

    }

    @Override
    public ConferenceDTO save(ConferenceDTO conference) {

        ConferenceEntity conferenceEntity = this.modelMapper.map(conference, ConferenceEntity.class);
        ConferenceEntity objConferenceEntity = this.servicioAccesoBD.save(conferenceEntity);
        ConferenceDTO conferenceDto = this.modelMapper.map(objConferenceEntity, ConferenceDTO.class);

        return conferenceDto;

    }

    @Override
    public ConferenceDTO findById(Integer id) {

        ConferenceEntity conferenceEntity = this.servicioAccesoBD.findById(id);
        ConferenceDTO conferenceDTO = this.modelMapper.map(conferenceEntity, ConferenceDTO.class);
        return conferenceDTO;

    }

    @Override
    public ConferenceDTO update(Integer id, ConferenceDTO conference) {

        ConferenceEntity conferenceEntity = this.modelMapper.map(conference, ConferenceEntity.class);
        ConferenceEntity objConferenceEntity = this.servicioAccesoBD.update(id, conferenceEntity);
        ConferenceDTO conferenceDto = this.modelMapper.map(objConferenceEntity, ConferenceDTO.class);

        return conferenceDto;

    }

    @Override
    public boolean delete(Integer id) {

        return this.servicioAccesoBD.delete(id);

    }

    @Override
    public ConferenceDTO findByName(String nombre) {
        ConferenceEntity conferenceEntity = this.servicioAccesoBD.findByName(nombre);
        ConferenceDTO conferenceDTO = this.modelMapper.map(conferenceEntity, ConferenceDTO.class);
        return conferenceDTO;
    }

    @Override
    public ConferenceDTO findByDate(String fecha) {
        ConferenceEntity conferenceEntity = this.servicioAccesoBD.findByfecha(fecha);
        ConferenceDTO conferenceDTO = this.modelMapper.map(conferenceEntity, ConferenceDTO.class);
        return conferenceDTO;
    }

}
