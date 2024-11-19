package edu.co.unicauca.revisor.facadeServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RevisorDTO {
    private Integer id;
    private String nombre;
    private Integer telefono;
    private String email;
    private String titulo_universitario;
}
