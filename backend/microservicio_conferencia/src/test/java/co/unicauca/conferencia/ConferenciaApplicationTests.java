package co.unicauca.conferencia;
import co.unicauca.conferencia.core.controlador.ConferenceRestController;
import co.unicauca.conferencia.core.fachadaServices.DTO.ConferenceDTO;
import co.unicauca.conferencia.core.services.IConferenceService;
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

@WebMvcTest(ConferenceRestController.class)
class ConferenceRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IConferenceService conferenceService;

    @Test
    void getConferences() throws Exception {
        // Crear datos de prueba
        ConferenceDTO conference1 = new ConferenceDTO();
        conference1.setNombre("Conferencia 1");
        conference1.setFecha("2024-01-01");

        ConferenceDTO conference2 = new ConferenceDTO();
        conference2.setNombre("Conferencia 2");
        conference2.setFecha("2024-02-01");

        List<ConferenceDTO> conferences = Arrays.asList(conference1, conference2);

        // Configurar comportamiento del servicio simulado
        given(conferenceService.findAll()).willReturn(conferences);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/conferences")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Conferencia 1"))
                .andExpect(jsonPath("$[1].nombre").value("Conferencia 2"));
    }

    @Test
    void getConferenceById() throws Exception {
        // Crear datos de prueba
        ConferenceDTO conference = new ConferenceDTO();
        conference.setNombre("Conferencia de Prueba");
        conference.setFecha("2024-01-01");

        // Configurar comportamiento del servicio simulado
        given(conferenceService.findById(1)).willReturn(conference);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/conferences/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Conferencia de Prueba"))
                .andExpect(jsonPath("$.fecha").value("2024-01-01"));
    }

    @Test
    void eliminarConferencia() throws Exception {
        // Configurar comportamiento del servicio simulado
        given(conferenceService.delete(1)).willReturn(true);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(delete("/api/conferences/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void actualizarConferencia() throws Exception {
        // Crear datos de entrada y respuesta
        ConferenceDTO conferencia = new ConferenceDTO();
        conferencia.setNombre("Conferencia Actualizada");
        conferencia.setFecha("2024-03-01");

        given(conferenceService.update(Mockito.eq(1), Mockito.any(ConferenceDTO.class))).willReturn(conferencia);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(put("/api/conferences/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Conferencia Actualizada\",\"fecha\":\"2024-03-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Conferencia Actualizada"))
                .andExpect(jsonPath("$.fecha").value("2024-03-01"));
    }
}
