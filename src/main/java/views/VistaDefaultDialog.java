package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase padre de la que extenderán las demás, extendiendo esta a su vez del
 * JDialog
 */
public abstract class VistaDefaultDialog extends JDialog {

    // se definen todas las variables que se van a utilizar en la vista. Además se
    // crean los votones que van a tener en común todas las vistas
    JLabel logo = new JLabel();
    JButton volver = new JButton("Volver");
    JButton continuar = new JButton("Continuar");

    // Constante de la imagen del logo
    final static ImageIcon IMAGEN_LOGO = new ImageIcon("src/main/resources/logoTitulo.png");

    /**
     * Constructor con referencia al JFrame padre
     */
    public VistaDefaultDialog(JFrame owner) {
        super(owner, true); // Esto asegura que el JDialog sea modal
        setTitle("Black Temple");
        setResizable(false);

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image logoIcono = miPantalla.getImage("src/main/resources/logoIcono.png");
        setIconImage(logoIcono);

    }

    /**
     * Método que se encarga de hacer visible el dialogo
     */
    public void hacerVisible() {
        setLocationRelativeTo(getOwner()); // Centrar el dialogo respecto a su owner
        setVisible(true); // Hacer visible el dialogo
    }

    /**
     * Método que se encarga de asignar el logo
     */
    public void asignarLogo(ImageIcon img) {
        logo.setIcon(img); // Asignar la imagen al JLabel
        logo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar la imagen
        add(logo, BorderLayout.CENTER); // Agregar la imagen al panel
    }

    /**
     * Método para volver a la ventana anterior
     */
    public void setListenerBotonVolver(ActionListener listener) {
        volver.addActionListener(listener);
    }

    /**
     * Método para avanzar a la siguiente ventana
     */
    public void setListenerBotonContinuar(ActionListener listener) {
        continuar.addActionListener(listener);
    }
}
