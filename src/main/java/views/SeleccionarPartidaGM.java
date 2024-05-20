package views;

import javax.swing.*;
import javax.swing.border.Border;

import control.PartidaSeleccionadaListener;
import model.AccesoBD;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

public class SeleccionarPartidaGM extends VistaDefault {
	private JLabel lblSeleccionarPartida;
	// private JButton btnPartida1;
	// private JButton btnPartida2;
	// private JButton btnPartida3;
	private JButton btnEditarPartida;
	private ButtonGroup botonesPartidas;
	private JPanel panelPartidas;
	private ArrayList<String> nombresPartidas;

	private static int partidaSeleccionadaId;
	private static int gameMasterId;

	public static int getGameMasterId() {
		return gameMasterId;
	}

	public static void setGameMasterId(int gameMasterId) {
		SeleccionarPartidaGM.gameMasterId = gameMasterId;
	}

	/**
	 * Constructor de la clase SeleccionarPartidaGM.
	 * Inicializa la interfaz gráfica y los componentes necesarios.
	 */
	public SeleccionarPartidaGM() {
		super();
		setSize(600, 400);
		inicializarComponentes();
		// asignarLogo(IMAGEN_LOGO);
		setLocationRelativeTo(null);
	}

	public ArrayList<String> getNombresPartidas() {
		return nombresPartidas;
	}

	public void setNombresPartidas(ArrayList<String> nombresPartidas) {
		this.nombresPartidas = nombresPartidas;
	}

	/**
	 * Método para inicializar los componentes de la interfaz gráfica.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		lblSeleccionarPartida = new JLabel("SELECCIONAR PARTIDA");
		lblSeleccionarPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarPartida.setBounds(188, 54, 208, 14);
		getContentPane().add(lblSeleccionarPartida);

		continuar = new JButton("INICIAR PARTIDA");
		continuar.setBounds(188, 264, 223, 31);
		getContentPane().add(continuar);

		volver = new JButton("VOLVER");

		volver.setBounds(10, 319, 223, 31);
		getContentPane().add(volver);

		btnEditarPartida = new JButton("EDITAR PARTIDA");
		btnEditarPartida.setBounds(351, 323, 223, 31);
		getContentPane().add(btnEditarPartida);

		botonesPartidas = new ButtonGroup();

		panelPartidas = new JPanel();
		panelPartidas.setBounds(155, 79, 273, 175);
		getContentPane().add(panelPartidas);
		Border borde = BorderFactory.createLineBorder(new Color(247, 178, 44), 2);
		panelPartidas.setBorder(borde);
		panelPartidas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		AccesoBD acceso = new AccesoBD();
		Connection c = acceso.getConexion();
		ArrayList<String> nombresPartidasArray = null;

		try {
			nombresPartidasArray = acceso.devolverPartidasNombre(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			acceso.cerrarConexion(c);
		}

		for (String nombrePartida : nombresPartidasArray) {
			agregarBotonPartida(nombrePartida);
		}

	}

	/**
	 * Método para limpiar la pantalla de los botones de partida.
	 */
	public void limpiarPantalla() {
		for (Component c : panelPartidas.getComponents()) {
			if (c instanceof JToggleButton) {
				botonesPartidas.remove((AbstractButton) c);
				panelPartidas.remove(c);

			}
		}

	}

	public ButtonGroup getBotonesPartidas() {
		return botonesPartidas;
	}

	public void setBotonesPartidas(ButtonGroup botonesPartidas) {
		this.botonesPartidas = botonesPartidas;
	}

	/**
	 * Método para agregar un botón de partida al panel de partidas.
	 * 
	 * @param p El nombre de la partida a agregar como botón.
	 */
	public void agregarBotonPartida(String p) {
		JToggleButton nuevoBotonPartida = new JToggleButton(p);
		botonesPartidas.add(nuevoBotonPartida);
		panelPartidas.add(nuevoBotonPartida);

		nuevoBotonPartida.addItemListener(new PartidaSeleccionadaListener(this));

		panelPartidas.revalidate();
		panelPartidas.repaint();

	}

	/**
	 * Método para limpiar la selección de partida.
	 */
	public void limpiarPartida() {
		for (Component c : panelPartidas.getComponents()) {
			if (c instanceof JToggleButton) {
				botonesPartidas.remove((AbstractButton) c);
				panelPartidas.remove(c);

			}
		}

		panelPartidas.revalidate();
		panelPartidas.repaint();
	}

	/**
	 * Obtiene el texto del botón seleccionado en un grupo de botones.
	 * 
	 * @param buttonGroup El grupo de botones del cual se obtiene el texto del botón
	 *                    seleccionado.
	 * @return El texto del botón seleccionado.
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}

		}

		return null;
	}

	/**
	 * Obtiene el nombre de la partida seleccionada.
	 * 
	 * @return El nombre de la partida seleccionada.
	 */
	public String getSelectedPartidaNombre() {
		return getSelectedButtonText(botonesPartidas);
	}

	/**
	 * Obtiene el ID de la partida seleccionada.
	 * 
	 * @return El ID de la partida seleccionada.
	 */
	public static int getPartidaSeleccionadaId() {
		return partidaSeleccionadaId;
	}

	/**
	 * Establece el ID de la partida seleccionada.
	 * 
	 * @param partidaSeleccionadaId El ID de la partida seleccionada.
	 */
	public static void setPartidaSeleccionadaId(int partidaSeleccionadaId) {
		SeleccionarPartidaGM.partidaSeleccionadaId = partidaSeleccionadaId;
	}

	public void setListenerBotonEditarPartida(ActionListener listener) {
		btnEditarPartida.addActionListener(listener);
	}
}
