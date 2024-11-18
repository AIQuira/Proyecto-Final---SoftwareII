package co.edu.unicauca.isii.revision.capaAccesoADatos.modelo;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class Persona {

    private int cedula;
    private String nombre;
    private String correo;
    private String password;
    private Long telefono;
    private int rol;

    public Persona() {
        // Constructor sin argumentos
    }
}
