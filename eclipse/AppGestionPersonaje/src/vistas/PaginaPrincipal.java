package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JInternalFrame;

public class PaginaPrincipal extends JFrame {
	public PaginaPrincipal() {
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 11, 311, 207);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(10, 11, 41, 42);
		panel.add(lblNewLabel);
		
		JLabel lblImagenPersonaje = new JLabel("IMAGEN PERSONAJE");
		lblImagenPersonaje.setBounds(110, 28, 95, 136);
		panel.add(lblImagenPersonaje);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE PERSONAJE");
		lblNewLabel_1.setBounds(95, 182, 131, 14);
		panel.add(lblNewLabel_1);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(41, 11, 245, 185);
		panel.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton_4 = new JButton("PARTIDA 1");
		btnNewButton_4.setBounds(61, 11, 89, 23);
		internalFrame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("PARTIDA 2");
		btnNewButton_4_1.setBounds(61, 45, 89, 23);
		internalFrame.getContentPane().add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("PARTIDA 3");
		btnNewButton_4_1_1.setBounds(61, 78, 89, 23);
		internalFrame.getContentPane().add(btnNewButton_4_1_1);
		
		JButton btnNewButton_5 = new JButton("ENTRAR AL MUNDO");
		btnNewButton_5.setBounds(86, 121, 133, 23);
		internalFrame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("VOLVER");
		btnNewButton_6.setBounds(0, 121, 71, 23);
		internalFrame.getContentPane().add(btnNewButton_6);
		internalFrame.setVisible(true);
		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.setBounds(125, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 227, 89, 23);
		getContentPane().add(btnVolver);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(327, 11, 97, 240);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("CREAR PERSONAJE");
		btnNewButton_1.setBounds(0, 206, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PERSONAJE 1");
		btnNewButton_2.setBounds(0, 11, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PERSONAJE 2");
		btnNewButton_3.setBounds(0, 45, 89, 23);
		panel_1.add(btnNewButton_3);
	}
}
