package edu.co.unicauca.revisor;

import edu.co.unicauca.revisor.controllers.RevisorRestController;
import edu.co.unicauca.revisor.facadeServices.DTO.RevisorDTO;
import edu.co.unicauca.revisor.facadeServices.services.IRevisorService;
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

@WebMvcTest(RevisorRestController.class)
class RevisorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IRevisorService revisorService;

    @Test
    void listarRevisores() throws Exception {
        // Crear datos de prueba
        RevisorDTO revisor1 = new RevisorDTO();
        revisor1.setNombre("Revisor 1");

        RevisorDTO revisor2 = new RevisorDTO();
        revisor2.setNombre("Revisor 2");

        List<RevisorDTO> revisores = Arrays.asList(revisor1, revisor2);

        // Configurar comportamiento del servicio simulado
        given(revisorService.findAll()).willReturn(revisores);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/revisor/revisores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Revisor 1"))
                .andExpect(jsonPath("$[1].nombre").value("Revisor 2"));
    }

    @Test
    void buscarRevisor() throws Exception {
        // Crear datos de prueba
        RevisorDTO revisor = new RevisorDTO();
        revisor.setNombre("Revisor de Prueba");

        // Configurar comportamiento del servicio simulado
        given(revisorService.findById(1)).willReturn(revisor);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(get("/api/revisor/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Revisor de Prueba"));
    }

    @Test
    void eliminarRevisor() throws Exception {
        // Configurar comportamiento del servicio simulado
        Mockito.doNothing().when(revisorService).delete(1);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(delete("/api/revisor/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void actualizarRevisor() throws Exception {
        // Crear datos de entrada y respuesta
        RevisorDTO revisor = new RevisorDTO();
        revisor.setNombre("Revisor Actualizado");

        given(revisorService.update(Mockito.eq(1), Mockito.any(RevisorDTO.class))).willReturn(revisor);

        // Realizar la solicitud y verificar los resultados
        mockMvc.perform(put("/api/revisor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Revisor Actualizado\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Revisor Actualizado"));
    }
}

