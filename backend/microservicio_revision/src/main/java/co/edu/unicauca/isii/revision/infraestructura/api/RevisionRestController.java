package co.edu.unicauca.isii.revision.infraestructura.api;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.isii.revision.dominio.modelo.RevisionEntity;
import co.edu.unicauca.isii.revision.dominio.puerto.RevisionServicePort;

@RestController
@RequestMapping("/api/revisiones")
public class RevisionRestController {

    private final RevisionServicePort revisionService;

    public RevisionRestController(RevisionServicePort revisionService) {
        this.revisionService = revisionService;
    }

    @PostMapping
    public RevisionEntity guardarRevision(@RequestBody RevisionEntity revision) {
        return revisionService.crearRevision(revision);
    }

    @GetMapping
    public List<RevisionEntity> listarRevisiones() {
        return revisionService.obtenerRevisiones();
    }

    @GetMapping("/{id}")
    public RevisionEntity buscarRevisionPorId(@PathVariable Integer id) {
        return revisionService.buscarRevisionPorId(id);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarRevision(@PathVariable Integer id) {
        return revisionService.eliminarRevision(id);
    }
}

