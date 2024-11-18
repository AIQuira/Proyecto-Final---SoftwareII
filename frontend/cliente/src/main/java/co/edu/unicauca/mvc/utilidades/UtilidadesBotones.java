package co.edu.unicauca.mvc.utilidades;

/**
 *
 * @author earea
 */
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class UtilidadesBotones {

    public static void agregarEfectoHover(JButton boton) {
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(new Color(145, 173, 180));  // Color #91adb4
                boton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(new Color(236, 236, 236));  // Color original
                boton.setForeground(Color.BLACK);
            }
        });
    }
}
