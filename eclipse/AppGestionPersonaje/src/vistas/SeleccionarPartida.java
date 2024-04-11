package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarPartida extends JFrame {
	public SeleccionarPartida() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(167, 11, 66, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ENTRAR A PARTIDA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(91, 190, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("SELECCIONAR PARTIDA");
		lblNewLabel_4.setBounds(167, 59, 128, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("PARTIDA #1");
		btnNewButton_1.setBounds(167, 87, 107, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PARTIDA #2");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(167, 121, 107, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("PARTIDA #3");
		btnNewButton_1_2.setBounds(167, 155, 107, 23);
		getContentPane().add(btnNewButton_1_2);
		
		JButton btnUnirseAPartida = new JButton("UNIRSE A PARTIDA");
		btnUnirseAPartida.setBounds(235, 190, 136, 31);
		getContentPane().add(btnUnirseAPartida);
	}
}
