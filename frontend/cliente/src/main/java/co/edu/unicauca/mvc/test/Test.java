package co.edu.unicauca.mvc.test;

import co.edu.unicauca.isii.services.ArticuloServices;
import co.edu.unicauca.isii.services.RevisionServices;
import co.edu.unicauca.mvc.vistas.GUIOpciones;
import javax.swing.UIManager;

public class Test {

    public static void main(String[] args) {
        // Configurar LookAndFeel
        seleccionarLookAndField();
        
        ArticuloServices servicioArticulo = new ArticuloServices();
        RevisionServices servicioRevision = new RevisionServices();
        
        // Crear e inicializar la interfaz de usuario en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIOpciones gui = new GUIOpciones(servicioArticulo,servicioRevision); // Crea una instancia de GUIOpciones
                gui.setVisible(true); // Hace visible la ventana
            }
        });
    }
    
    private static void seleccionarLookAndField() {
        for(UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception ex) {
                    ex.printStackTrace(); // Agrega un trazo de pila para depurar si hay problemas de configuración
                }
            }
        }
    }
}
