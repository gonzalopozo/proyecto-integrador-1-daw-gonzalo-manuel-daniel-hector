package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que representa la vista de la página principal del juego.
 */
public class PaginaPrincipalGM extends VistaDefault {
	private JButton btnNuevaPartida;

	/**
	 * PaginaPrincipalGM Constructor que inicializa la vista de la página principal
	 * del juego del Game Master.
	 */
	public PaginaPrincipalGM() {
		super();
		setSize(600, 400);
		asignarLogo(IMAGEN_LOGO); // Asignación del logo.
		logo.setBounds(((getWidth() / 2) - 130), 30, 250, 182); // Posición del logo.
		inicializarComponentes();
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		continuar = new JButton("CONTINUAR"); // Botón para continuar con la partida guardada.
		continuar.setForeground(Color.BLACK); // Color de la letra del botón.
		continuar.setBackground(new Color(247, 178, 44));
		continuar.setBounds(200, 244, 184, 23);
		getContentPane().add(continuar); // Botón para continuar con la partida guardada.
		getContentPane().setLayout(null);

		btnNuevaPartida = new JButton("NUEVA PARTIDA"); // Botón para crear una nueva partida.
		btnNuevaPartida.setBounds(200, 294, 184, 23);
		getContentPane().add(btnNuevaPartida);

		volver = new JButton("VOLVER"); // Botón para volver a la pantalla de inicio de sesión.
		volver.setBounds(10, 330, 105, 23);
		getContentPane().add(volver);

	}

	/**
	 * Método que asigna un listener al botón de nueva partida.
	 * 
	 * @param listener ActionListener que se asignará al botón.
	 */
	public void setListenerBotonCrearPartida(ActionListener listener) {
		btnNuevaPartida.addActionListener(listener);
	}
}
