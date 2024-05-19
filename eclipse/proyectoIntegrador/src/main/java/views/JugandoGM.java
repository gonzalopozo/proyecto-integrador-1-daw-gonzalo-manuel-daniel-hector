package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;

import components.*;
import control.*;
import java.awt.Font;

/**
 * Vista de la pantalla de juego para el GM (Game Master) en la que se pueden
 * subir niveles a los personajes de la partida.
 */
public class JugandoGM extends VistaDefault {
	private BackgroundPanel fondo;
	private JPanel panelSeleccionPersonaje;
	private JPanel panelBotonSubirNivel;
	private JPanel panelOutputSubidaNivel;
	private JComboBox<String> personajesPartidaComboBox;
	private JTextArea outputSubidaNivelTextArea;
	private JLabel labelInfo;

	public JugandoGM() { // Constructor de la clase JugandoGM
		super();
		setSize(1280, 720);
		inicializarComponentes();
		asignarLogo(IMAGEN_LOGO);
		logo.setBounds(((getWidth() / 2) - 130), 70, 250, 182);
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {

		fondo = new BackgroundPanel("src/main/resources/fondoGM.jpeg"); // Se crea un panel con una imagen de fondo

		// getContentPane().setLayout(new BorderLayout());
		// getContentPane().add(fondo);

		fondo.setLayout(null);

		this.setContentPane(fondo);

		volver = new JButton("SALIR"); // Se crea un botón con el texto "SALIR"
		volver.setBounds(20, 630, 200, 40); // Se establece la posición y el tamaño del botón
		fondo.add(volver); // Se añade el botón al panel de fondo

		panelSeleccionPersonaje = new JPanel(); // Se crea un panel para la selección de personaje
		panelSeleccionPersonaje.setBounds(340, 295, 271, 110);
		fondo.add(panelSeleccionPersonaje); // Se añade el panel al panel de fondo
		Border borde = BorderFactory.createLineBorder(new Color(247, 178, 44), 2);
		panelSeleccionPersonaje.setBorder(borde);
		panelSeleccionPersonaje.setLayout(null);

		personajesPartidaComboBox = new JComboBox<String>(); // Se crea un ComboBox para la selección de personaje
		personajesPartidaComboBox.setBounds(10, 50, 251, 40);
		panelSeleccionPersonaje.add(personajesPartidaComboBox); // Se añade el ComboBox al panel de selección de
																// personaje

		labelInfo = new JLabel("¡Selecciona un personaje!"); // Se crea un label con el texto "¡Selecciona un
																// personaje!"
		labelInfo.setFont(new Font("Arial", Font.BOLD, 18));
		labelInfo.setHorizontalAlignment(SwingConstants.CENTER); // Se establece la alineación del texto
		labelInfo.setBounds(10, 11, 251, 28);
		panelSeleccionPersonaje.add(labelInfo); // Se añade el label al panel de selección de personaje

		panelBotonSubirNivel = new JPanel();
		panelBotonSubirNivel.setLayout(null);
		panelBotonSubirNivel.setBounds(340, 415, 271, 80);
		fondo.add(panelBotonSubirNivel);
		panelBotonSubirNivel.setBorder(borde); // Se añade un borde al panel de subida de nivel del personaje

		continuar = new JButton("¡Subir nivel del personaje!"); // Se crea un botón con el texto "¡Subir nivel del
																// personaje!"
		continuar.setBounds(10, 17, 251, 45);
		panelBotonSubirNivel.add(continuar); // Se añade el botón al panel de subida de nivel del personaje

		panelOutputSubidaNivel = new JPanel();
		panelOutputSubidaNivel.setLayout(null);
		panelOutputSubidaNivel.setBounds(648, 295, 290, 200);
		fondo.add(panelOutputSubidaNivel);
		panelOutputSubidaNivel.setBorder(borde);

		outputSubidaNivelTextArea = new JTextArea();
		outputSubidaNivelTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
		outputSubidaNivelTextArea.setEditable(false);
		outputSubidaNivelTextArea.setWrapStyleWord(true); // Se establece el salto de línea automático
		outputSubidaNivelTextArea.setBounds(10, 11, 270, 178);
		panelOutputSubidaNivel.add(outputSubidaNivelTextArea);

		// fondo.setLayout(new FlowLayout());
	}

	/**
	 * @return the personajesPartidaComboBox
	 */
	public JComboBox<String> getPersonajesPartidaComboBox() {
		return personajesPartidaComboBox;
	}

	/**
	 * @param personajesPartidaComboBox the personajesPartidaComboBox to set
	 */
	public void setPersonajesPartidaComboBoxModel(DefaultComboBoxModel<String> personajesPartidaComboBoxModel) {
		personajesPartidaComboBox.setModel(personajesPartidaComboBoxModel);
	}

	/**
	 * @return the outputSubidaNivelTextArea
	 */
	public JTextArea getOutputSubidaNivelTextArea() {
		return outputSubidaNivelTextArea;
	}

	/**
	 * @param outputSubidaNivelTextArea the outputSubidaNivelTextArea to set
	 */
	public void setOutputSubidaNivelTextArea(JTextArea outputSubidaNivelTextArea) {
		this.outputSubidaNivelTextArea = outputSubidaNivelTextArea;
	}

}
