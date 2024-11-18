package co.unicauca.conferencia.core.accesoDatos.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    private Integer id;
    private String nombre;
    private String lugar;
    private Date fecha;
    private String tema;
    private String descripcion;
    private String contacto;

    public ConferenceEntity() {
    }

}
