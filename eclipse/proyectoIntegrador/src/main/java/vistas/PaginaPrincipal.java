package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;

public class PaginaPrincipal extends JFrame {
	private JLabel logo;
	public PaginaPrincipal() {
		getContentPane().setLayout(null);
		
		logo = new JLabel();
		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.setBounds(439, 524, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 524, 128, 23);
		getContentPane().add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBounds(754, 10, 211, 539);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		Border bordeRojo = BorderFactory.createLineBorder(new Color(247,178,44), 2);
		panel_1.setBorder(bordeRojo);
		
		JButton btnNewButton_1 = new JButton("CREAR PERSONAJE");
		btnNewButton_1.setBounds(10, 510, 191, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PERSONAJE 1");
		btnNewButton_2.setBounds(10, 58, 191, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PERSONAJE 2");
		btnNewButton_3.setBounds(10, 92, 191, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("VER PARTIDAS");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(29, 11, 151, 23);
		panel_1.add(btnNewButton_2_1);
		
		JLabel personaje = new JLabel();
		ImageIcon orco = new ImageIcon("src/main/resources/dance.gif");
		personaje.setIcon(orco);
		personaje.setBounds(350, 150, 300, 300);
		getContentPane().add(personaje);
		
		JLabel lblNewLabel = new JLabel("PepeElDelMadrid");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(427, 479, 167, 14);
		getContentPane().add(lblNewLabel);
	
	}
	public void hacerVisible(){
		setVisible(true);
	}
	public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(20, 20, 200, 145);
		getContentPane().add(logo);
	}
}
