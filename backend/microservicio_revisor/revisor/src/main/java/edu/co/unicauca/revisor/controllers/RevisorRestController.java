package edu.co.unicauca.revisor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.revisor.facadeServices.DTO.RevisorDTO;
import edu.co.unicauca.revisor.facadeServices.services.IRevisorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/revisor/")
public class RevisorRestController {

    @Autowired
    private IRevisorService revisorService;

    @GetMapping("/revisores")
    public List<RevisorDTO> listarRevisores() {
        return revisorService.findAll();
    }

    @GetMapping("/{id}")
    public RevisorDTO buscarRevisor(@PathVariable Integer id) {
        return revisorService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarRevisor(@PathVariable Integer id) {
        revisorService.delete(id);
    }

    @PutMapping("/{id}")
    public RevisorDTO actualizarRevisor(@PathVariable Integer id, @RequestBody RevisorDTO revisor) {
        return revisorService.update(id, revisor);
    }



}
