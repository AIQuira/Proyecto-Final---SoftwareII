package co.edu.unicauca.mvc.modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author earea
 */
public class RepositorioPersona {
    private static List<Persona> personas = new ArrayList<>();

    // Agregar una persona
    public static void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    // Buscar una persona por correo
    public static Persona buscarPorCorreo(String correo) {
        for (Persona persona : personas) {
            if (persona.getCorreo().equals(correo)) {
                return persona;
            }
        }
        return null;
    }

    // Autenticar usuario
    public static Persona autenticar(String correo, String password) {
        for (Persona persona : personas) {
            if (persona.getCorreo().equals(correo) && persona.getPassword().equals(password)) {
                return persona;
            }
        }
        return null;
    }
}
