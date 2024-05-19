package views;

import javax.swing.*;
import java.awt.*;

/**
 * clase que va a extender de la de vista default
 */
public class CrearCuenta extends VistaDefault {

	// se definen todas las variables que se van a utilizar en la vista.
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNumExpediente;
	private JTextField txtEstudios;
	private JLabel lblCrearCuenta;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblNExpediente;
	private JLabel lblEstudios;
	private JCheckBox checkBoxTerminos;

	/**
	 * Constructor de la vista, asignando los métodos necesarios.
	 */
	public CrearCuenta() {
		super();
		setSize(700, 600);
		setLocationRelativeTo(null);
		inicializarComponentes();
		asignarLogo(IMAGEN_LOGO);
	}

	/**
	 * Método el cual se va a encargar de inicializar todos los componentes que van
	 * a aparecer en la vista.
	 */
	private void inicializarComponentes() {

		// Creación textfield nombre
		getContentPane().setLayout(null);
		txtNombre = new JTextField();
		txtNombre.setBounds(242, 295, 200, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		// Creación textfield apellido
		txtApellido = new JTextField();
		txtApellido.setBounds(242, 340, 200, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		// Creación etiqueta de crear cuenta
		lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setFont(new Font("Arial", Font.BOLD, 18));
		lblCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER); // Esto establece que se centre de manera
																		// horizontal
		lblCrearCuenta.setForeground(new Color(247, 178, 44));
		lblCrearCuenta.setBounds(242, 241, 200, 14);
		getContentPane().add(lblCrearCuenta);

		// Creación etiqueta apellido
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setForeground(new Color(247, 178, 44));
		lblApellido.setBounds(242, 323, 86, 14);
		getContentPane().add(lblApellido);

		// Creación botón continuar
		continuar = new JButton("CONTINUAR");
		continuar.setBounds(280, 513, 124, 23);
		getContentPane().add(continuar);

		// Creación etiqueta nombre
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(247, 178, 44));
		lblNombre.setBounds(242, 278, 86, 14);
		getContentPane().add(lblNombre);

		// Creación etiqueta nº expediente
		lblNExpediente = new JLabel("Nº EXPEDIENTE");
		lblNExpediente.setForeground(new Color(247, 178, 44));
		lblNExpediente.setBounds(242, 368, 116, 14);
		getContentPane().add(lblNExpediente);

		// Creación textfield nº expediente
		txtNumExpediente = new JTextField();
		txtNumExpediente.setBounds(242, 385, 200, 20);
		getContentPane().add(txtNumExpediente);
		txtNumExpediente.setColumns(10);

		// Creación etiqueta estudios
		lblEstudios = new JLabel("ESTUDIOS");
		lblEstudios.setForeground(new Color(247, 178, 44));
		lblEstudios.setBounds(242, 413, 86, 14);
		getContentPane().add(lblEstudios);

		// Creación textfield estudios
		txtEstudios = new JTextField();
		txtEstudios.setBounds(242, 430, 200, 20);
		getContentPane().add(txtEstudios);
		txtEstudios.setColumns(10);

		// Creación checkbox de términos y condiciones
		checkBoxTerminos = new JCheckBox("TÉRMINOS Y CONDICIONES");
		checkBoxTerminos.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxTerminos.setBounds(235, 474, 214, 29);
		getContentPane().add(checkBoxTerminos);

		// Creación botón de volver
		volver = new JButton("VOLVER");
		volver.setBounds(10, 527, 104, 23);
		getContentPane().add(volver);
	}

	// Se crean los getters y setters

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNumExpediente() {
		return txtNumExpediente;
	}

	public void setTxtNumExpediente(JTextField txtNumExpediente) {
		this.txtNumExpediente = txtNumExpediente;
	}

	public JTextField getTxtEstudios() {
		return txtEstudios;
	}

	public void setTxtEstudios(JTextField txtEstudios) {
		this.txtEstudios = txtEstudios;
	}

	public JCheckBox getCheckBoxTerminos() {
		return checkBoxTerminos;
	}

	public void setCheckBoxTerminos(JCheckBox checkBoxTerminos) {
		this.checkBoxTerminos = checkBoxTerminos;
	}
}
