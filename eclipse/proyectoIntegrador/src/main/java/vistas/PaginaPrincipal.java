package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
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
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(754, 10, 211, 539);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("CREAR PERSONAJE");
		btnNewButton_1.setBounds(0, 510, 211, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PERSONAJE 1");
		btnNewButton_2.setBounds(0, 11, 211, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PERSONAJE 2");
		btnNewButton_3.setBounds(0, 45, 211, 23);
		panel_1.add(btnNewButton_3);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(283, 102, 245, 185);
		getContentPane().add(internalFrame);
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
		
		JLabel personaje = new JLabel();
		ImageIcon orco = new ImageIcon("src/main/resources/imagenOrco.png");
		personaje.setIcon(orco);
		personaje.setBounds(350, 150, 300, 300);
		getContentPane().add(personaje);
		
		JLabel lblNewLabel = new JLabel("PepeElDelMadrid");
		lblNewLabel.setBounds(427, 479, 167, 14);
		getContentPane().add(lblNewLabel);
	
	}
	public void hacerVisible(){
		setVisible(true);
	}
	public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(10, -60, 350, 350);
		getContentPane().add(logo);
	}
}
