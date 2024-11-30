package co.edu.unicauca.isii.proyecto_api_rest_revision;

import co.edu.unicauca.isii.revision.capaControladores.RevisionRestController;
import co.edu.unicauca.isii.revision.fachadaServicios.DTO.RevisionDTO;
import co.edu.unicauca.isii.revision.fachadaServicios.DTO.RevisorConArticulos.ArticuloDTO;
import co.edu.unicauca.isii.revision.fachadaServicios.servicios.IRevisionService;
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

@WebMvcTest(RevisionRestController.class)
class RevisionRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IRevisionService revisionService;

    @Test
    void listarRevisiones() throws Exception {
        // Crear datos de prueba
        RevisionDTO revision1 = new RevisionDTO();
        revision1.setId(1);
        revision1.setCalificacionDescripcion(1);

        RevisionDTO revision2 = new RevisionDTO();
        revision2.setId(2);
        revision2.setCalificacionDescripcion(2);

        List<RevisionDTO> revisiones = Arrays.asList(revision1, revision2);

        // Configurar comportamiento del servicio simulado
        given(revisionService.listarRevisiones()).willReturn(revisiones);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/revision")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].descripcion").value("Revision 1"))
                .andExpect(jsonPath("$[1].descripcion").value("Revision 2"));
    }

    @Test
    void crearRevision() throws Exception {
        // Crear datos de entrada y respuesta
        RevisionDTO revision = new RevisionDTO();
        revision.setCalificacionDescripcion(1);

        given(revisionService.guardarRevision(Mockito.any(RevisionDTO.class))).willReturn(revision);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(post("/api/revision")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"descripcion\":\"Nueva Revision\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.descripcion").value("Nueva Revision"));
    }

    @Test
    void listarArticulosDeRevisor() throws Exception {
        // Crear datos de prueba
        ArticuloDTO articulo1 = new ArticuloDTO();
        articulo1.setTitulo("Articulo 1");

        ArticuloDTO articulo2 = new ArticuloDTO();
        articulo2.setTitulo("Articulo 2");

        List<ArticuloDTO> articulos = Arrays.asList(articulo1, articulo2);

        // Configurar comportamiento del servicio simulado
        given(revisionService.listarArticulosDeRevisor(1)).willReturn(articulos);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/revision/articulos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Articulo 1"))
                .andExpect(jsonPath("$[1].titulo").value("Articulo 2"));
    }
}
