package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionRol extends JFrame {
	public SeleccionRol() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(167, 11, 66, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(144, 193, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ELIGE TU ROL");
		lblNewLabel_1.setBounds(161, 68, 86, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("GAME MASTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(144, 93, 129, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("JUGADOR");
		btnNewButton_1_1.setBounds(144, 134, 129, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("VOLVER");
		btnNewButton_1_2.setBounds(10, 281, 86, 23);
		getContentPane().add(btnNewButton_1_2);
	}
}
