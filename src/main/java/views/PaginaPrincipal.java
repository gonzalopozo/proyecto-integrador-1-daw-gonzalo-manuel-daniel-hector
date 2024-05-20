package views;

import javax.swing.*;
import javax.swing.border.*;
import control.*;
import model.AccesoBD;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * clase que va a extender de la de vista default
 */
public class PaginaPrincipal extends VistaDefault {

	// se definen todas las variables que se van a utilizar en la vista.
	private JButton btnJugar;
	private JButton btnCrearPersonaje;
	private JButton btnBorrarPersonaje;
	private JButton btnVerPartidas;
	private JLabel lblPersonaje;
	private JLabel lblNombrePersonaje;
	private ImageIcon imagenPersonaje;
	private JPanel pnlContenedor;
	private JPanel panelPersonajes;
	private ButtonGroup botonesPersonajes;
	private ArrayList<String> nombresPersonajes;

	private static int personajeSeleccionadoId;

	// creación de get y set del id del personaje seleccionado
	public static int getPersonajeSeleccionadoId() {
		return personajeSeleccionadoId;
	}

	public static void setPersonajeSeleccionadoId(int personajeSeleccionadoId) {
		PaginaPrincipal.personajeSeleccionadoId = personajeSeleccionadoId;
	}

	/**
	 * Constructor de la vista, asignando los métodos necesarios.
	 */
	public PaginaPrincipal() {
		super();
		setSize(1000, 600);
		setLocationRelativeTo(null);
		asignarLogo(IMAGEN_LOGO);
		inicializarComponentes();
		setLocationRelativeTo(null);
	}

	/**
	 * Método el cual se va a encargar de inicializar todos los componentes que van
	 * a aparecer en la vista.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		// Creación del botón jugar
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(439, 524, 89, 23);
		getContentPane().add(btnJugar);

		// Creación del botón de volver
		volver = new JButton("VOLVER");
		volver.setBounds(10, 524, 128, 23);
		getContentPane().add(volver);

		// Creación del panel que hará las funciones de contenedor
		pnlContenedor = new JPanel();
		pnlContenedor.setForeground(new Color(255, 255, 255));
		pnlContenedor.setBounds(754, 10, 211, 539);
		getContentPane().add(pnlContenedor);
		pnlContenedor.setLayout(null);
		Border borde = BorderFactory.createLineBorder(new Color(247, 178, 44), 2); // Esto le aplica el borde al panel
																					// del contenedor
		pnlContenedor.setBorder(borde);

		// Creación del botón de crear personaje
		btnCrearPersonaje = new JButton("CREAR PERSONAJE");
		btnCrearPersonaje.setBounds(10, 510, 191, 23);
		pnlContenedor.add(btnCrearPersonaje);

		// Creación del botón de borrar personaje
		btnBorrarPersonaje = new JButton("BORRAR PERSONAJE");
		btnBorrarPersonaje.setBounds(10, 460, 191, 23);
		pnlContenedor.add(btnBorrarPersonaje);

		logo.setBounds(50, 30, 250, 182);

		// Creación del botón de ver partidas
		btnVerPartidas = new JButton("VER PARTIDAS");
		btnVerPartidas.setBounds(29, 11, 151, 23);
		pnlContenedor.add(btnVerPartidas);

		// Creación del buttongroup de botones Personajes
		botonesPersonajes = new ButtonGroup();
		// Creación del panel de personajes
		panelPersonajes = new JPanel();
		panelPersonajes.setBounds(20, 44, 167, 442);
		pnlContenedor.add(panelPersonajes);

		// Creación de la etiqueta del personaje
		lblPersonaje = new JLabel();
		lblPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaje.setBounds(342, 150, 300, 300);
		getContentPane().add(lblPersonaje);

		// Creación de la etiqueta del nombre del personaje
		lblNombrePersonaje = new JLabel();
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombrePersonaje.setBounds(410, 450, 164, 81);
		getContentPane().add(lblNombrePersonaje);

		// Creacion de acceso a la base de datos
		AccesoBD acceso = new AccesoBD();
		// Se crea la conexión
		Connection c = acceso.getConexion();
		// Creación del arraylist de nombres de personajes que almacenará lo que
		// devuelva la base de datos.
		ArrayList<String> nombresPersonajesArray = null;
		try {
			nombresPersonajesArray = acceso.devolverPersonajesMiembro(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			acceso.cerrarConexion(c);
		}

		// Bucle para recorrer el arraylist de los nombres de los personajes
		for (String nombrePersonaje : nombresPersonajesArray) {
			System.out.println(nombrePersonaje);
			agregarBotonPersonaje(nombrePersonaje);
		}

	}

	// Creación de getters y setters

	public JPanel getPanelPersonajes() {
		return panelPersonajes;
	}

	public void setPanelPersonajes(JPanel panelPersonajes) {
		this.panelPersonajes = panelPersonajes;
	}

	public ButtonGroup getBotonesPersonajes() {
		return botonesPersonajes;
	}

	public JLabel getLblNombrePersonaje() {
		return lblNombrePersonaje;
	}

	public void setLblNombrePersonaje(JLabel lblNombrePersonaje) {
		this.lblNombrePersonaje = lblNombrePersonaje;
	}

	public void setBotonesPersonajes(ButtonGroup botonesPersonajes) {
		this.botonesPersonajes = botonesPersonajes;
	}

	public void setListenerBotonJugar(JugarPaginaPrincipalListener paginaPrincipalUnirsePartida) {
		btnJugar.addActionListener(paginaPrincipalUnirsePartida);
	}

	public void setListenerBotonCrearPersonaje(MoverseListener listener) {
		btnCrearPersonaje.addActionListener(listener);
	}

	public void setListenerBotonVerPartidas(DetallesPersonajesListener listener) {
		btnVerPartidas.addActionListener(listener);
	}

	public void setListenerBotonBorrarPersonaje(BorrarPersonajeListener listener) {
		btnBorrarPersonaje.addActionListener(listener);
	}

	/**
	 * Método encargado de crear los togglebutton de los personajes
	 */
	public void agregarBotonPersonaje(String p) {
		JToggleButton nuevoBotonPersonaje = new JToggleButton(p);
		botonesPersonajes.add(nuevoBotonPersonaje);
		panelPersonajes.add(nuevoBotonPersonaje);

		nuevoBotonPersonaje.addItemListener(new PersonajeSeleccionadoListener(this));

		panelPersonajes.revalidate();
		panelPersonajes.repaint();

	}

	/**
	 * Método que se encarga de cambiar la imagen del personaje en función de este.
	 */
	public void cambiarImagenPersonaje(String rutaImagen) {
		imagenPersonaje = new ImageIcon(rutaImagen);
		lblPersonaje.setIcon(imagenPersonaje);

		lblPersonaje.revalidate();
		lblPersonaje.repaint();
	}

	public JLabel getLblPersonaje() {
		return lblPersonaje;
	}

	public void setLblPersonaje(JLabel lblPersonaje) {
		this.lblPersonaje = lblPersonaje;
	}

	public ArrayList<String> getNombresPersonajes() {
		return nombresPersonajes;
	}

	public void setNombresPersonajes(ArrayList<String> nombresPersonajes) {
		this.nombresPersonajes = nombresPersonajes;
	}

	/**
	 * Método que limpia los botones de los personajes para que no se dupliquen al
	 * acceder
	 */
	public void limpiarPantalla() {
		for (Component c : panelPersonajes.getComponents()) {
			if (c instanceof JToggleButton) {
				botonesPersonajes.remove((AbstractButton) c);
				panelPersonajes.remove(c);

			}
		}

	}

	/**
	 * Método que limpia tanto el texto como la imagen de la vista
	 */
	public void limpiarTextoImagen() {
		lblNombrePersonaje.setText("");
		lblPersonaje.setIcon(null);

		panelPersonajes.revalidate();
		panelPersonajes.repaint();
	}

	/**
	 * Método que comprueba que el botón del personaje está seleccionado
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
	 * Método que elimina el botón del personaje al eliminarlo
	 */
	public void removeBotonPersonaje(String nombrePersonaje) {
		for (Enumeration<AbstractButton> buttons = botonesPersonajes.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.getText().equals(nombrePersonaje)) {
				System.out.println("Elimina del buttongroup");
				botonesPersonajes.remove(button);
				panelPersonajes.remove(button);
				break;
			}
		}

		panelPersonajes.revalidate();
		panelPersonajes.repaint();
	}

}