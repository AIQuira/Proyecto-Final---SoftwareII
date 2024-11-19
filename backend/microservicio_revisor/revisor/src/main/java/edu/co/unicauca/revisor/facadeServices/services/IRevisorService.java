package edu.co.unicauca.revisor.facadeServices.services;

import java.util.List;

import edu.co.unicauca.revisor.facadeServices.DTO.RevisorDTO;

public interface IRevisorService {

    public List<RevisorDTO> findAll();
    public RevisorDTO findById(Integer id);
    public RevisorDTO save(RevisorDTO revisor);
    public RevisorDTO update(Integer id, RevisorDTO revisor);
    public void delete(Integer id);
}
