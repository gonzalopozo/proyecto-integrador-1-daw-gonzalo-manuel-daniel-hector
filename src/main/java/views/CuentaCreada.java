package views;

import javax.swing.*;

/**
 * Vista que muestra un mensaje de que la cuenta se ha creado correctamente
 */
public class CuentaCreada extends VistaDefault {

	private JLabel lblcheck;
	private ImageIcon imgCheck;
	private JLabel lblListo;
	private JLabel lblCuentaCreada;

	// Metodo constructor que inicializa la vista de cuenta creada
	public CuentaCreada() {
		super();
		setSize(500, 400);
		inicializarComponentes();
		setLocationRelativeTo(null);
	}

	// Metodo que inicializa los componentes de la vista
	private void inicializarComponentes() {
		lblcheck = new JLabel();
		lblcheck.setHorizontalAlignment(SwingConstants.CENTER); // Centra la imagen
		imgCheck = new ImageIcon("src/main/resources/iconoCheck.png"); // Ruta de la imagen del check
		getContentPane().setLayout(null); // Layout nulo para poder posicionar los componentes
		lblcheck.setIcon(imgCheck);
		lblcheck.setBounds(131, 11, 222, 222);
		getContentPane().add(lblcheck);

		continuar = new JButton("CONTINUAR"); // Boton para continuar
		continuar.setBounds(174, 294, 136, 31); // Posicion y tamaño del boton
		getContentPane().add(continuar);

		lblListo = new JLabel("¡Listo!"); // Etiqueta que indica que la cuenta se ha creado
		lblListo.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto
		lblListo.setBounds(199, 233, 85, 14);
		getContentPane().add(lblListo);

		lblCuentaCreada = new JLabel("SE HA CREADO TU CUENTA"); // Etiqueta que indica que la cuenta se ha creado
		lblCuentaCreada.setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto
		lblCuentaCreada.setBounds(114, 184, 255, 56);
		getContentPane().add(lblCuentaCreada);
	}
}
