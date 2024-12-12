package co.unicauca.conferencia.core.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.unicauca.conferencia.core.fachadaServices.DTO.ConferenceDTO;
import co.unicauca.conferencia.core.services.IConferenceService;

/**
 * Controlador de conferencias
 * Se encarga de gestionar las peticiones que llegan al servidor
 */
@RestController
@RequestMapping("/api")
public class ConferenceRestController {

    @Autowired
    private IConferenceService ConferenceService;

    @PostMapping("/conferences")
    public ConferenceDTO crearConferencia(@RequestBody ConferenceDTO conferencia) {
        ConferenceDTO objConferencia = null;
        objConferencia = ConferenceService.save(conferencia);
        return objConferencia;
    }

    @GetMapping("/conferences")
    public List<ConferenceDTO> getConferences() {
        return ConferenceService.findAll();
    }

    @GetMapping("/conferences/{id}")
    public ConferenceDTO getConferenceById(@PathVariable Integer id) {
        return ConferenceService.findById(id);
    }

    @GetMapping("/conferences/{nombre}")
    public ConferenceDTO getConferenceByName(@PathVariable String nombre) {
        return ConferenceService.findByName(nombre);
    }

    @GetMapping("/conferences/{fecha}")
    public ConferenceDTO getConferenceByDate(@PathVariable String fecha) {
        return ConferenceService.findByDate(fecha);
    }

    @DeleteMapping("/conferences/{id}")
    public Boolean eliminarConferencia(@PathVariable Integer id) {
        Boolean bandera = false;
        ConferenceDTO conferenciaActual = ConferenceService.findById(id);
        if (conferenciaActual != null) {
            bandera = ConferenceService.delete(id);
        }
        return bandera;
    }

    @PutMapping("/conferences/{id}")
    public ConferenceDTO actualizarConferencia(@RequestBody ConferenceDTO conferencia, @PathVariable Integer id) {
        ConferenceDTO objConferencia = null;
        ConferenceDTO conferenciaActual = ConferenceService.findById(id);
        if (conferenciaActual != null) {
            objConferencia = ConferenceService.update(id, conferencia);
        }
        return objConferencia;
    }

}
