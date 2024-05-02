package views;

import javax.swing.*;
import java.awt.*;

public class CrearCuenta extends VistaDefault {
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


	public CrearCuenta() {
		super();
		setSize(700,600);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	private void inicializarComponentes(){
		txtNombre = new JTextField();
		txtNombre.setBounds(242, 295, 200, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(242, 340, 200, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setFont(new Font("Arial", Font.BOLD, 18));
		lblCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearCuenta.setForeground(new Color(247, 178, 44));
		lblCrearCuenta.setBounds(242, 241, 200, 14);
		getContentPane().add(lblCrearCuenta);
		
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setForeground(new Color(247, 178, 44));
		lblApellido.setBounds(242, 323, 86, 14);
		getContentPane().add(lblApellido);
		
		continuar = new JButton("CONTINUAR");
		continuar.setBounds(280, 513, 124, 23);
		getContentPane().add(continuar);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(247, 178, 44));
		lblNombre.setBounds(242, 278, 86, 14);
		getContentPane().add(lblNombre);
		
		lblNExpediente = new JLabel("Nº EXPEDIENTE");
		lblNExpediente.setForeground(new Color(247, 178, 44));
		lblNExpediente.setBounds(242, 368, 116, 14);
		getContentPane().add(lblNExpediente);
		
		txtNumExpediente = new JTextField();
		txtNumExpediente.setBounds(242, 385, 200, 20);
		getContentPane().add(txtNumExpediente);
		txtNumExpediente.setColumns(10);
		
		lblEstudios = new JLabel("ESTUDIOS");
		lblEstudios.setForeground(new Color(247, 178, 44));
		lblEstudios.setBounds(242, 413, 86, 14);
		getContentPane().add(lblEstudios);
		
		txtEstudios = new JTextField();
		txtEstudios.setBounds(242, 430, 200, 20);
		getContentPane().add(txtEstudios);
		txtEstudios.setColumns(10);
		
		checkBoxTerminos = new JCheckBox("TÉRMINOS Y CONDICIONES");
		checkBoxTerminos.setHorizontalAlignment(SwingConstants.CENTER);
		checkBoxTerminos.setBounds(242, 466, 200, 23);
		getContentPane().add(checkBoxTerminos);
	}
}
