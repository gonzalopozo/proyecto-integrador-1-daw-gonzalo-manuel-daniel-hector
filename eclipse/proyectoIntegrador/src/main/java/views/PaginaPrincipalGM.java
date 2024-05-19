package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaginaPrincipalGM extends VistaDefault {
	private JButton btnNuevaPartida;

	public PaginaPrincipalGM() {
		super();
		setSize(1000,600);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}
	
	public void inicializarComponentes(){
		continuar = new JButton("CONTINUAR");
		continuar.setForeground(Color.BLACK);
		continuar.setBackground(new Color(247, 178, 44));
		continuar.setBounds(408, 314, 184, 23);
		getContentPane().add(continuar);
		
		btnNuevaPartida = new JButton("NUEVA PARTIDA");
		btnNuevaPartida.setBounds(408, 364, 184, 23);
		getContentPane().add(btnNuevaPartida);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 530, 105, 23);
		getContentPane().add(volver);

		// botonContinuar2 = new JButton ("NUEVA PARTIDA");
		// continuar.setForeground(Color.BLACK);
		// continuar.setBackground(new Color(247, 178, 44));
		// continuar.setBounds(408, 314, 184, 23);
		// getContentPane().add(botonContinuar2);
	}

	public void setListenerBotonCrearPartida(ActionListener listener) {
		btnNuevaPartida.addActionListener(listener);
	}
}
