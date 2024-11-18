package co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.ArticulosConConferenciasDTO.ConferenceDTO;
import reactor.core.publisher.Mono;

@Service
public class ConferenciasService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<ConferenceDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        String url = "ttp://localhost:8085/api/conferencias/articulo/" + idArticulo;

        Mono<ConferenceDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenceDTO[].class);

        ConferenceDTO[] conferenciasArray = response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}
