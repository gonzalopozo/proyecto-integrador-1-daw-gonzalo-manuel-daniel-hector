package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartidasDisponibles extends JFrame {
	public PartidasDisponibles() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(167, 11, 66, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ENTRAR A PARTIDA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(153, 198, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("PARTIDAS DISPONIBLES");
		lblNewLabel_4.setBounds(167, 59, 136, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("PARTIDA #1");
		btnNewButton_1.setBounds(167, 88, 107, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PARTIDA #2");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(167, 122, 107, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("PARTIDA #3");
		btnNewButton_1_2.setBounds(167, 156, 107, 23);
		getContentPane().add(btnNewButton_1_2);
	}
}
