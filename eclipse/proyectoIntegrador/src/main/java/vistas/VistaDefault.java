package views;

import javax.swing.*;

import control.MoverseListener;


public abstract class VistaDefault extends JFrame {
    private JLabel logo;
    private JButton volver;
    private JButton continuar;

    public void hacerVisible(){
		setVisible(true);
	}

    public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(200, 50, 200, 145);
		getContentPane().add(logo);
	}

    public void setListenerBotonVolver (MoverseListener listener) {
        volver.addActionListener(listener);
    }

    public void setListenerBotonContinuar (MoverseListener listener) {
        continuar.addActionListener(listener);
    }
}
