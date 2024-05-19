package views;

import javax.swing.*;
import java.awt.*;

/**
 * clase que va a extender de la de vista default
 */
public class CrearCuentaDos extends VistaDefault {

	// se definen todas las variables que se van a utilizar en la vista.
	private JTextField textField;
	private JPasswordField txtContrasena;
	private JPasswordField txtRepetirContrasena;
	private JLabel lblCrearCuenta;
	private JLabel lblContrasena;
	private JLabel lblUsuario;
	private JLabel lblRepetirContrasena;

	private static String nombre;
	private static String apellido;
	private static int numExpediente;
	private static String estudios;

	// Se generan los getters y setters

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(JPasswordField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public JPasswordField getTxtRepetirContrasena() {
		return txtRepetirContrasena;
	}

	public void setTxtRepetirContrasena(JPasswordField txtRepetirContrasena) {
		this.txtRepetirContrasena = txtRepetirContrasena;
	}

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		CrearCuentaDos.nombre = nombre;
	}

	public static String getApellido() {
		return apellido;
	}

	public static void setApellido(String apellido) {
		CrearCuentaDos.apellido = apellido;
	}

	public static int getNumExpediente() {
		return numExpediente;
	}

	public static void setNumExpediente(int numExpediente) {
		CrearCuentaDos.numExpediente = numExpediente;
	}

	public static String getEstudios() {
		return estudios;
	}

	public static void setEstudios(String estudios) {
		CrearCuentaDos.estudios = estudios;
	}

	/**
	 * Constructor de la vista, asignando los métodos necesarios.
	 */
	public CrearCuentaDos() {
		super();
		setSize(700, 600);
		inicializarComponentes();
		asignarLogo(IMAGEN_LOGO);
		setLocationRelativeTo(null);
	}

	/**
	 * Método el cual se va a encargar de inicializar todos los componentes que van
	 * a aparecer en la vista.
	 */
	private void inicializarComponentes() {

		getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBounds(241, 310, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		// Se crea el JPassword para la contraseña
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(241, 365, 200, 20);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);

		// Creación del botón crear cuenta, el cual hará las funciones de continuar
		continuar = new JButton("CREAR CUENTA");
		continuar.setBounds(265, 450, 153, 31);
		getContentPane().add(continuar);

		// Creación de etiqueta de crear cuenta
		lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setFont(new Font("Arial", Font.BOLD, 18));
		lblCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearCuenta.setBounds(241, 249, 202, 14);
		getContentPane().add(lblCrearCuenta);

		// Creación de etiqueta Contraseña
		lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setBounds(241, 348, 146, 14);
		getContentPane().add(lblContrasena);

		// Creación de etiqueta Usuario
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(241, 293, 145, 14);
		getContentPane().add(lblUsuario);

		// Creación de etiqueta repetir contraseña
		lblRepetirContrasena = new JLabel("REPETIR CONTRASEÑA");
		lblRepetirContrasena.setBounds(241, 393, 267, 14);
		getContentPane().add(lblRepetirContrasena);

		// Creación passwordfield para repetir contraseña
		txtRepetirContrasena = new JPasswordField();
		txtRepetirContrasena.setColumns(10);
		txtRepetirContrasena.setBounds(241, 418, 200, 20);
		getContentPane().add(txtRepetirContrasena);

		// Creación botón volver
		volver = new JButton("VOLVER");
		volver.setBounds(10, 527, 95, 23);
		getContentPane().add(volver);
	}

}
