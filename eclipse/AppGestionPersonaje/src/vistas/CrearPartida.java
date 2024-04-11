package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearPartida extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public CrearPartida() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(167, 11, 66, 61);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(161, 104, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(161, 153, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("CREAR PARTIDA");
		btnNewButton.setBounds(138, 184, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE PARTIDA");
		lblNewLabel_1.setBounds(161, 83, 100, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AMBIENTACIÓN");
		lblNewLabel_2.setBounds(161, 135, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("CREAR PARTIDA");
		lblNewLabel_4.setBounds(167, 59, 94, 14);
		getContentPane().add(lblNewLabel_4);
	}
}
