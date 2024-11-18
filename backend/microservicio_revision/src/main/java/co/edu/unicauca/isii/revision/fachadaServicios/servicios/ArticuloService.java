package co.edu.unicauca.isii.revision.fachadaServicios.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import co.edu.unicauca.isii.revision.fachadaServicios.DTO.RevisorConArticulos.ArticuloDTO;
import reactor.core.publisher.Mono;

@Service
public class ArticuloService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public ArticuloDTO consultarArticuloDTO(Integer idArticulo) {
        String url = "http://localhost:2504/api/articulos/" + idArticulo;

        Mono<ArticuloDTO> response = this.webClientBuilder.build()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(ArticuloDTO.class);

        ArticuloDTO articulo = response.block();
        return articulo;
    }

    public ArticuloDTO actualizarArticuloDTO(ArticuloDTO articulo, Integer id) {
        String url = "http://localhost:2504/api/articulos/" + id;

        Mono<ArticuloDTO> response = this.webClientBuilder.build()
            .put()
            .uri(url)
            .body(Mono.just(articulo), ArticuloDTO.class)
            .retrieve()
            .bodyToMono(ArticuloDTO.class);

        ArticuloDTO articuloActualizado = response.block();
        return articuloActualizado;
    }

    public List<ArticuloDTO> listarArticulosDeRevisor(Integer idRevisor) {
        String url = "http://localhost:2504/api/articulos/revisor/" + idRevisor;

        Mono<ArticuloDTO[]> response = this.webClientBuilder.build()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(ArticuloDTO[].class);
        ArticuloDTO[] articulos = response.block();
        return articulos != null ? List.of(articulos) : List.of();
    }
}
