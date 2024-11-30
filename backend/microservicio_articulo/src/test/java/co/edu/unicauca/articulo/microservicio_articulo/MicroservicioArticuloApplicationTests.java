package co.edu.unicauca.articulo.microservicio_articulo;

import co.edu.unicauca.articulo.microservicio_articulo.controlador.ArticuloRestController;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.edu.unicauca.articulo.microservicio_articulo.fachadaServices.services.IArticuloService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArticuloRestController.class)
class ArticuloRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IArticuloService articuloService;

    @Test
    void listarArticulos() throws Exception {
        // Crear datos de prueba
        ArticuloDTO articulo1 = new ArticuloDTO();
        articulo1.setTitulo("Articulo 1");
        articulo1.setDescripcion("Descripcion 1");

        ArticuloDTO articulo2 = new ArticuloDTO();
        articulo2.setTitulo("Articulo 2");
        articulo2.setDescripcion("Descripcion 2");

        List<ArticuloDTO> articulos = Arrays.asList(articulo1, articulo2);

        // Configurar comportamiento del servicio simulado
        given(articuloService.findAll()).willReturn(articulos);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/articulos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Articulo 1"))
                .andExpect(jsonPath("$[1].titulo").value("Articulo 2"));
    }

    @Test
    void consultarArticulo() throws Exception {
        // Crear datos de prueba
        ArticuloDTO articulo = new ArticuloDTO();
        articulo.setTitulo("Articulo de Prueba");
        articulo.setDescripcion("Descripcion de Prueba");

        // Configurar comportamiento del servicio simulado
        given(articuloService.findById(1)).willReturn(articulo);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/articulos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Articulo de Prueba"))
                .andExpect(jsonPath("$.descripcion").value("Descripcion de Prueba"));
    }

    @Test
    void crearArticulo() throws Exception {
        // Crear datos de entrada y respuesta
        ArticuloDTO articulo = new ArticuloDTO();
        articulo.setTitulo("Nuevo Articulo");
        articulo.setDescripcion("Nueva Descripcion");

        given(articuloService.save(Mockito.any(ArticuloDTO.class))).willReturn(articulo);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(post("/api/articulos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"titulo\":\"Nuevo Articulo\",\"descripcion\":\"Nueva Descripcion\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Nuevo Articulo"))
                .andExpect(jsonPath("$.descripcion").value("Nueva Descripcion"));
    }
}
