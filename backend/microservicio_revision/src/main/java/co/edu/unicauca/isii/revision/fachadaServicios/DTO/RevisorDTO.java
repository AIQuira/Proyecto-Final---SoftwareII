package co.edu.unicauca.isii.revision.fachadaServicios.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RevisorDTO {
    private int cedula;
    private String nombre;
    private String correo;
    private String password;
    private Long telefono;
    private int rol;
    private String tituloUniversitario;

    public RevisorDTO() {
        
    }
}
