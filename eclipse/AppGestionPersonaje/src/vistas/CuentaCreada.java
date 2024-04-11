package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CuentaCreada extends JFrame {
	public CuentaCreada() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECK VERDE");
		lblNewLabel.setBounds(167, 11, 80, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(138, 140, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("¡LISTO!");
		lblNewLabel_1.setBounds(177, 79, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SE HA CREADO TU CUENTA");
		lblNewLabel_1_1.setBounds(138, 104, 152, 14);
		getContentPane().add(lblNewLabel_1_1);
	}
}
