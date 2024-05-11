package views;

import javax.swing.*;
import java.awt.*;

public class CrearCuentaDos extends VistaDefault {
	private JTextField textField;
	private JPasswordField txtContrasena;
	private JPasswordField txtRepetirContrasena;
	private JLabel lblCrearCuenta;
	private JLabel lblContrasena;
	private JLabel lblUsuario;
	private JLabel lblRepetirContrasena;

	public CrearCuentaDos() {
		super();
		setSize(700,600);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	private void inicializarComponentes(){
		getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBounds(241, 310, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(241, 365, 200, 20);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		
		continuar = new JButton("CREAR CUENTA");
		continuar.setBounds(265, 450, 153, 31);
		getContentPane().add(continuar);
		
		lblCrearCuenta = new JLabel("CREAR CUENTA");
		lblCrearCuenta.setFont(new Font("Arial", Font.BOLD, 18));
		lblCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearCuenta.setBounds(241, 249, 202, 14);
		getContentPane().add(lblCrearCuenta);
		
		lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setBounds(241, 348, 146, 14);
		getContentPane().add(lblContrasena);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(241, 293, 145, 14);
		getContentPane().add(lblUsuario);
		
		lblRepetirContrasena = new JLabel("REPETIR CONTRASEÑA");
		lblRepetirContrasena.setBounds(241, 393, 267, 14);
		getContentPane().add(lblRepetirContrasena);
		
		txtRepetirContrasena = new JPasswordField();
		txtRepetirContrasena.setColumns(10);
		txtRepetirContrasena.setBounds(241, 418, 200, 20);
		getContentPane().add(txtRepetirContrasena);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 527, 95, 23);
		getContentPane().add(volver);
	}

	
}
