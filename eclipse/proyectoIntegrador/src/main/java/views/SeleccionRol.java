package views;

import javax.swing.*;
import java.awt.*;

public class SeleccionRol extends VistaDefault {
	private JLabel lblRol;
	private JToggleButton toggleBtnJugador;
	private JToggleButton toggleBtnGameMaster;
	private ButtonGroup btnGroupRoles;

	public SeleccionRol() {
		super();
		setSize(400,230);
		inicializarComponentes();
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		continuar = new JButton("CONTINUAR");
		continuar.setBounds(104, 118, 175, 30);
		getContentPane().add(continuar);
		getContentPane().setLayout(null);
		
		lblRol = new JLabel("ELIGE TU ROL");
		lblRol.setFont(new Font("Arial", Font.BOLD, 18));
		lblRol.setHorizontalAlignment(SwingConstants.CENTER);
		lblRol.setBounds(0, 18, 384, 14);
		getContentPane().add(lblRol);
		
		toggleBtnJugador = new JToggleButton("JUGADOR");
		toggleBtnJugador.setBounds(122, 83, 140, 23);
		getContentPane().add(toggleBtnJugador);
        /*
		toggleBtnJugador.setFocusPainted(false); // Quitar el contorno al tener el foco
        toggleBtnJugador.setContentAreaFilled(false); // Quitar el área pintada
        toggleBtnJugador.setBorderPainted(true); // Mostrar el borde
        toggleBtnJugador.setOpaque(true); // Hacer el botón opaco
        */
        
        toggleBtnGameMaster = new JToggleButton("GAME MASTER");
		toggleBtnGameMaster.setBounds(122, 49, 140, 23);
		getContentPane().add(toggleBtnGameMaster);
        /*toggleBtnGameMaster.setFocusPainted(false); // Quitar el contorno al tener el foco
        toggleBtnGameMaster.setContentAreaFilled(false); // Quitar el área pintada
        toggleBtnGameMaster.setBorderPainted(true); // Mostrar el borde
        toggleBtnGameMaster.setOpaque(true); // Hacer el botón opaco
        */
        
        btnGroupRoles = new ButtonGroup();
        btnGroupRoles.add(toggleBtnJugador);
        btnGroupRoles.add(toggleBtnGameMaster);
		
		/*JButton btnNewButton_1_1 = new JButton("JUGADOR");
		btnNewButton_1_1.setBounds(408, 361, 157, 23);
		getContentPane().add(btnNewButton_1_1);*/
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 163, 111, 23);
		getContentPane().add(volver);
	}
	
}
