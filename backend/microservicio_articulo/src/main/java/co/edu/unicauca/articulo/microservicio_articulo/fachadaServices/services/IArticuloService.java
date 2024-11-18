package co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloConConferenciasDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ConferenceDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;

public interface IArticuloService {
    public List<ArticuloDTO> findAll();

	public ArticuloDTO findById(Integer id);

	public ArticuloDTO save(ArticuloDTO articulo);

	public ArticuloDTO update(Integer id, ArticuloDTO articulo);

	public boolean delete(Integer id);

	public List<ConferenceDTO> ListarConferenciasDeArticulo(Integer idArticulo);

	public ArticuloConConferenciasDTO listarDatosArticuloConSusConferencias(Integer idArticulo) ;

	public List<ArticuloDTO> listarArticulosDeRevisor (Integer idRevisor);
}
