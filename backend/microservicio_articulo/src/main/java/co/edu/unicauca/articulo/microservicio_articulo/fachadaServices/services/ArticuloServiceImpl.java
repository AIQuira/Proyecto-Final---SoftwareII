package co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.articulo.microservicio_articulo.capaAccesoDatos.repositories.ArticuloRepository;
import co.edu.unicauca.articulo.microservicio_articulo.dominio.ArticuloEntity;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ArticuloConConferenciasDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ConferenceDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.rabbit.MessageProducer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArticuloServiceImpl implements IArticuloService{
    private ArticuloRepository servicioAccesoBaseDatos;
	private ConferenciasService servicioConsumirObtencionConferencias;
	private ModelMapper modelMapper;
	private final MessageProducer producer;


	@Override
	public List<ArticuloDTO> findAll() {

		List<ArticuloEntity> articulosEntity = this.servicioAccesoBaseDatos.findAll();
		List<ArticuloDTO> articulosDTO = this.modelMapper.map(articulosEntity, new TypeToken<List<ArticuloDTO>>() {
		}.getType());
		return articulosDTO;
	}

	@Override
	public ArticuloDTO findById(Integer id) {
		ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
		ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
		return articuloDTO;
	}

	@Override
	public ArticuloDTO save(ArticuloDTO articulo) {
		ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
		ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.save(articuloEntity);
		ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
		producer.sendMessage(articuloDTO,1);
		return articuloDTO;
	}

	@Override
	public ArticuloDTO update(Integer id, ArticuloDTO articulo) {
		ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
		ArticuloEntity articuloEntityActualizado = this.servicioAccesoBaseDatos.update(id, articuloEntity);
		ArticuloDTO articuloDTO = this.modelMapper.map(articuloEntityActualizado, ArticuloDTO.class);
		return articuloDTO;
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);
	}

	@Override
	public List<ConferenceDTO> ListarConferenciasDeArticulo(Integer idArticulo) {
		//invocación sincrona de servicio web que permite obtener los conferencias del articulo	
		List<ConferenceDTO> listaConferenciasDelArticulo;
		listaConferenciasDelArticulo=this.servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
		return listaConferenciasDelArticulo;
	}

	@Override
	public ArticuloConConferenciasDTO listarDatosArticuloConSusConferencias(Integer idArticulo) {
		List<ConferenceDTO> listaLibrosDelArticulo;
		listaLibrosDelArticulo=this.servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
		ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(idArticulo);
		ArticuloDTO objArticuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);		
		ArticuloConConferenciasDTO objArticulo= new ArticuloConConferenciasDTO(objArticuloDTO, listaLibrosDelArticulo);
		
		return objArticulo;
	}

	@Override
	public List<ArticuloDTO> listarArticulosDeRevisor(Integer idRevisor) {
		List<ArticuloEntity> articulosEntity = this.servicioAccesoBaseDatos.listarArticulosDeRevisor(idRevisor);
		List<ArticuloDTO> articulosDTO = this.modelMapper.map(articulosEntity, new TypeToken<List<ArticuloDTO>>() {
		}.getType());
		return articulosDTO;
	}
}
