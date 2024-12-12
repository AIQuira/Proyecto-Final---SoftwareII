package co.edu.unicauca.isii.revision.infraestructura.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.isii.revision.aplicacion.servicios.IRevisionService;
import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisionDTO;
import co.edu.unicauca.isii.revision.infraestructura.fachada.DTO.RevisorConArticulos.ArticuloDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RevisionRestController {

    @Autowired
    private IRevisionService revisionService;

    @PostMapping("/revision")
    public RevisionDTO crearRevision(@RequestBody RevisionDTO revision) {
        return this.revisionService.guardarRevision(revision);
    }

    @GetMapping("/revision")
    public List<RevisionDTO> listarRevisiones() {
        return this.revisionService.listarRevisiones();
    }

    @GetMapping("/revision/articulos/{idRevisor}")
    public List<ArticuloDTO> listarArticulosDeRevisor(@PathVariable Integer idRevisor) {
        return this.revisionService.listarArticulosDeRevisor(idRevisor);
    }

    /*@PutMapping("/revision/calificar/{id}")
    public String calificarArticulo(@PathVariable Integer id, @RequestBody int calificacion) {
        boolean resultado = this.revisionService.calificarArticulo(id, calificacion);
        return resultado ? "Calificación aplicada con éxito" : "No se pudo aplicar la calificación";
    }*/
}
