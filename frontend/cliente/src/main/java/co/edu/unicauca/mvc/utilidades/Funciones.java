package co.edu.unicauca.mvc.utilidades;

import co.edu.unicauca.mvc.vistas.postular.panelCrearConferencia;
import javax.swing.JOptionPane;

public class Funciones {

    public static boolean isNumeric(String str) {
        return str.matches("\\d+"); // Para números enteros positivos
    }
    
    public static boolean verificarCampo(String campo) {
        if (campo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(campo);
            return false; // Campo vacío
        }
        return true; // Campo válido
    }
}
