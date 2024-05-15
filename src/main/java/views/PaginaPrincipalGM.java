package views;

import javax.swing.*;
import java.awt.*;

public class PaginaPrincipalGM extends VistaDefault {
	// private JButton continuar;
	private JButton btnNuevaPartida;
	// private JButton volver;
	private JButton btnPartida1;
	private JButton btnPartida2;
	private JButton btnEntrarMundo;
	private JButton btnVolverInternalFrame;
	private JButton botonContinuar2;

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
		
		continuarDos = new JButton("NUEVA PARTIDA");
		continuarDos.setBounds(408, 364, 184, 23);
		getContentPane().add(continuarDos);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 530, 105, 23);
		getContentPane().add(volver);

		// botonContinuar2 = new JButton ("NUEVA PARTIDA");
		// continuar.setForeground(Color.BLACK);
		// continuar.setBackground(new Color(247, 178, 44));
		// continuar.setBounds(408, 314, 184, 23);
		// getContentPane().add(botonContinuar2);


		
		
	}
}
