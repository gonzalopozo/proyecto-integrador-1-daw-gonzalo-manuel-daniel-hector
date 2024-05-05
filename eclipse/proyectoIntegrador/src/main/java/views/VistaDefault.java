package views;

import javax.swing.*;

import java.awt.*;

import control.MoverseListener;


public abstract class VistaDefault extends JFrame {
    JLabel logo = new JLabel();
    JButton volver;
    JButton continuar;

    final static ImageIcon imagenLogo = new ImageIcon("src/main/resources/logoTitulo.png");

    public VistaDefault() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Black Temple");
	    setResizable(false);

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
	    Image logoIcono = miPantalla.getImage("src/main/resources/logoIcono.png");
	    setIconImage(logoIcono);
    }

    public void hacerVisible(){
		setVisible(true);
	}

    public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(170, 30, 250, 182);
		getContentPane().add(logo);
	}

    public void setListenerBotonVolver (MoverseListener listener) {
        volver.addActionListener(listener);
    }

    public void setListenerBotonContinuar (MoverseListener listener) {
        continuar.addActionListener(listener);
    }
}
