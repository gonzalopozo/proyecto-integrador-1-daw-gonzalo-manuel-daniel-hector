package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearCuentaDos extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public CrearCuentaDos() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(167, 11, 66, 61);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(157, 122, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 177, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(137, 253, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("CREAR CUENTA");
		lblNewLabel_1.setBounds(161, 68, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setBounds(157, 152, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("USUARIO");
		lblNewLabel_4.setBounds(158, 97, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("REPETIR CONTRASEÑA");
		lblNewLabel_2_1.setBounds(157, 205, 127, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 222, 86, 20);
		getContentPane().add(textField_2);
	}
}
