package co.edu.unicauca.mvc.utilidades;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class Utilidades {

    // Método para configurar los colores del JOptionPane
    private static void configurarColoresEmergentes() {
        UIManager.put("Panel.background", new ColorUIResource(255, 255, 255)); // Fondo del panel principal (blanco)
        UIManager.put("OptionPane.background", new ColorUIResource(255, 255, 255)); // Fondo del JOptionPane (blanco)
        UIManager.put("Button.background", new ColorUIResource(145, 173, 180)); // Fondo del botón (azul verdoso creo)
        UIManager.put("Button.foreground", new ColorUIResource(255, 255, 255)); // Color del texto del botón (blanco)
        UIManager.put("OptionPane.messageForeground", new ColorUIResource(60, 63, 65)); // Color del texto del mensaje (gris oscuro)
        UIManager.put("OptionPane.messageBackground", new ColorUIResource(255, 255, 255)); // Fondo del mensaje blanco
    }

    public static void mensajeAdvertencia(String mns, String titulo) {
        configurarColoresEmergentes();
        CargarImagenes objCargarImagenes = new CargarImagenes();
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, objCargarImagenes.CargarImagen("/recursos/!Grande.png"));
    }
    
    public static void mensajeInformacion(String mns, String titulo) {
        configurarColoresEmergentes();
        CargarImagenes objCargarImagenes = new CargarImagenes();
        JOptionPane.showMessageDialog(null, mns, titulo, JOptionPane.DEFAULT_OPTION, objCargarImagenes.CargarImagen("/recursos/iGrande.png"));
    }
}
