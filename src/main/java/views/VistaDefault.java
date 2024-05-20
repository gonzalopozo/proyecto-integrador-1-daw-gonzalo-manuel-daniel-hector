package views;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

/**
 * clase padre de la que extenderán todas las demás, la cual extiende a su vez
 * de el JFrame
 */
public abstract class VistaDefault extends JFrame {

    // se definen todas las variables que se van a utilizar en la vista.
    JLabel logo = new JLabel();
    JButton volver;
    JButton continuar;

    // constante de la imagen del logo
    final static ImageIcon IMAGEN_LOGO = new ImageIcon("src/main/resources/logoTitulo.png");

    /**
     * Constructor de la vista, asignando los métodos necesarios.
     */
    public VistaDefault() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Black Temple");
        setResizable(false);
        // herramienta para poner el icono a la ventana
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image logoIcono = miPantalla.getImage("src/main/resources/logoIcono.png");
        setIconImage(logoIcono);
    }

    /**
     * Método creado para hacer visible la vista
     */
    public void hacerVisible() {
        setVisible(true);
    }

    /**
     * Método que asigna la imagen del logo
     */
    public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
        logo.setBounds(((getWidth() / 2) - 130), 30, 250, 182);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(logo);
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
