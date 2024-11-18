package co.edu.unicauca.articulo.microservicio_articulo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloConConferenciasDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ConferenceDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.services.IArticuloService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ArticuloRestController {
    @Autowired
    private IArticuloService articuloService;

    @GetMapping("/articulos")
    public List<ArticuloDTO> listarArticulos() {
        return articuloService.findAll();
    }

    @GetMapping("/articulos/conferencias/{idArticulo}")
    public List<ConferenceDTO> listarArticuloConSusConferencias(@PathVariable Integer idArticulo) {
        return articuloService.ListarConferenciasDeArticulo(idArticulo);
    }

    @GetMapping("/articulos/articulosyconferencias/{idArticulo}")
    public ArticuloConConferenciasDTO listarDatosArticuloConSusConferencias(@PathVariable Integer idArticulo) {
        return articuloService.listarDatosArticuloConSusConferencias(idArticulo);
    }

    @GetMapping("/articulos/{id}")
    public ArticuloDTO consultarArticulo(@PathVariable Integer id) {
        ArticuloDTO objArticulo = null;
        objArticulo = articuloService.findById(id);
        return objArticulo;
    }

    @PostMapping("/articulos")
    public ArticuloDTO crearArticulo(@RequestBody ArticuloDTO articulo) {
        ArticuloDTO objArticulo = null;
        objArticulo = articuloService.save(articulo);
        return objArticulo;
    }

    @PutMapping("/articulos/{id}")
    public ArticuloDTO actualizarArticulo(@RequestBody ArticuloDTO articulo, @PathVariable Integer id) {
        ArticuloDTO objArticulo = null;
        ArticuloDTO articuloActual = articuloService.findById(id);
        if (articuloActual != null) {
            objArticulo = articuloService.update(id, articulo);
        }
        return objArticulo;
    }

    @DeleteMapping("/articulos/{id}")
    public Boolean eliminarArticulo(@PathVariable Integer id) {
        Boolean bandera = false;
        ArticuloDTO articuloActual = articuloService.findById(id);
        if (articuloActual != null) {
            bandera = articuloService.delete(id);
        }
        return bandera;
    }

    @GetMapping("/articulos/revisor/{idRevisor}")
    public List<ArticuloDTO> listarArticulosPorRevisor(@PathVariable Integer idRevisor) {
        return articuloService.listarArticulosDeRevisor(idRevisor);
    }
}
