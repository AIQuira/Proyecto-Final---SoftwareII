package edu.co.unicauca.revisor.facadeServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.co.unicauca.revisor.dataAccess.model.RevisorEntity;
import edu.co.unicauca.revisor.dataAccess.repositories.RevisorRepository;
import edu.co.unicauca.revisor.facadeServices.DTO.RevisorDTO;

@Service
public class RevisorService implements IRevisorService {

    @Autowired
    private RevisorRepository revisorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RevisorService(RevisorRepository revisorRepository, ModelMapper modelMapper) {
        this.revisorRepository = revisorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RevisorDTO> findAll() {

        List<RevisorEntity> revisorEntity = this.revisorRepository.findAll();
        List<RevisorDTO> revisorDTO = this.modelMapper.map(revisorEntity, new TypeToken<List<RevisorDTO>>() {
        }.getType());
        return revisorDTO;

    }

    @Override
    public RevisorDTO findById(Integer id) {
        RevisorEntity revisorEntity = this.revisorRepository.findById(id);
        if (revisorEntity == null) {
            throw new RuntimeException("Revisor no encontrado con ID: " + id);
        }
        return this.modelMapper.map(revisorEntity, RevisorDTO.class);
    }

    @Override
    public RevisorDTO save(RevisorDTO revisor) {

        RevisorEntity revisorEntity = this.modelMapper.map(revisor, RevisorEntity.class);
        RevisorEntity objRevisorEntity = this.revisorRepository.save(revisorEntity);
        RevisorDTO revisorDTO = this.modelMapper.map(objRevisorEntity, RevisorDTO.class);
        return revisorDTO;

    }

    @Override
    public RevisorDTO update(Integer id, RevisorDTO revisor) {
        RevisorEntity revisorEntity = this.modelMapper.map(revisor, RevisorEntity.class);
        RevisorEntity objRevisorEntity = this.revisorRepository.update(id, revisorEntity);
        if (objRevisorEntity == null) {
            throw new RuntimeException("Revisor no encontrado");
        }
        return this.modelMapper.map(objRevisorEntity, RevisorDTO.class);
    }

    @Override
    public void delete(Integer id) {
        RevisorEntity revisorEntity = this.revisorRepository.findById(id);
        if (revisorEntity == null) {
            throw new RuntimeException("Revisor no encontrado");
        }
        this.revisorRepository.delete(revisorEntity.getId());
    }

}
