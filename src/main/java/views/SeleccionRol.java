package views;

import javax.swing.*;
import java.awt.*;

/**
 * La clase SeleccionRol es una subclase de VistaDefault que proporciona una
 * interfaz gráfica
 * para que el usuario elija su rol, ya sea jugador o game master.
 */
public class SeleccionRol extends VistaDefault {
	private JLabel lblRol;
	private JToggleButton toggleBtnJugador;
	private JToggleButton toggleBtnGameMaster;
	private ButtonGroup btnGroupRoles;

	/**
	 * Constructor de la clase SeleccionRol.
	 * Inicializa la interfaz gráfica y los componentes necesarios.
	 */
	public SeleccionRol() {
		super();
		setSize(400, 230);
		inicializarComponentes(); // Inicializar los componentes de la interfaz gráfica
		setLocationRelativeTo(null);
	}

	/**
	 * Método para inicializar los componentes de la interfaz gráfica.
	 */
	public void inicializarComponentes() {
		continuar = new JButton("CONTINUAR"); // Botón para continuar
		continuar.setBounds(104, 118, 175, 30);
		getContentPane().add(continuar);
		getContentPane().setLayout(null);

		lblRol = new JLabel("ELIGE TU ROL"); // Etiqueta para elegir el rol
		lblRol.setFont(new Font("Arial", Font.BOLD, 18));
		lblRol.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto de la etiqueta
		lblRol.setBounds(0, 18, 384, 14);
		getContentPane().add(lblRol); // Añadir la etiqueta a la interfaz gráfica

		toggleBtnJugador = new JToggleButton("JUGADOR"); // Botón para elegir el rol de jugador
		toggleBtnJugador.setBounds(122, 83, 140, 23);
		getContentPane().add(toggleBtnJugador); // Añadir el botón a la interfaz gráfica

		toggleBtnGameMaster = new JToggleButton("GAME MASTER"); // Botón para elegir el rol de game master
		toggleBtnGameMaster.setBounds(122, 49, 140, 23);
		getContentPane().add(toggleBtnGameMaster); // Añadir el botón a la interfaz gráfica

		btnGroupRoles = new ButtonGroup(); // Grupo de botones para elegir el rol
		btnGroupRoles.add(toggleBtnJugador); // Añadir el botón de jugador al grupo
		btnGroupRoles.add(toggleBtnGameMaster); // Añadir el botón de game master al grupo

		volver = new JButton("VOLVER"); // Botón para volver
		volver.setBounds(10, 163, 111, 23);
		getContentPane().add(volver);
	}

	/**
	 * @return the lblRol
	 */
	public JLabel getLblRol() {
		return lblRol;
	}

	/**
	 * @param lblRol the lblRol to set
	 */
	public void setLblRol(JLabel lblRol) {
		this.lblRol = lblRol;
	}

	/**
	 * @return the toggleBtnJugador
	 */
	public JToggleButton getToggleBtnJugador() {
		return toggleBtnJugador;
	}

	/**
	 * @param toggleBtnJugador the toggleBtnJugador to set
	 */
	public void setToggleBtnJugador(JToggleButton toggleBtnJugador) {
		this.toggleBtnJugador = toggleBtnJugador;
	}

	/**
	 * @return the toggleBtnGameMaster
	 */
	public JToggleButton getToggleBtnGameMaster() {
		return toggleBtnGameMaster;
	}

	/**
	 * @param toggleBtnGameMaster the toggleBtnGameMaster to set
	 */
	public void setToggleBtnGameMaster(JToggleButton toggleBtnGameMaster) {
		this.toggleBtnGameMaster = toggleBtnGameMaster;
	}

	/**
	 * @return the btnGroupRoles
	 */
	public ButtonGroup getBtnGroupRoles() {
		return btnGroupRoles;
	}

	/**
	 * @param btnGroupRoles the btnGroupRoles to set
	 */
	public void setBtnGroupRoles(ButtonGroup btnGroupRoles) {
		this.btnGroupRoles = btnGroupRoles;
	}

}
