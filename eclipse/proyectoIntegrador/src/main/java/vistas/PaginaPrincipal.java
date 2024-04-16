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
import javax.swing.JRadioButton;

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
		btnNewButton_2.setBounds(0, 58, 211, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PERSONAJE 2");
		btnNewButton_3.setBounds(0, 92, 211, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("VER PARTIDAS");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_1.setBounds(29, 11, 151, 23);
		panel_1.add(btnNewButton_2_1);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(79, 150, 245, 185);
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
		
		JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
		internalFrame_1.setBounds(350, 11, 398, 307);
		getContentPane().add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		
		JButton btnNewButton_6_1 = new JButton("VOLVER");
		btnNewButton_6_1.setBounds(10, 243, 123, 23);
		internalFrame_1.getContentPane().add(btnNewButton_6_1);
		
		JButton btnNewButton_6_2 = new JButton("VER ESTADÍSTICAS");
		btnNewButton_6_2.setBounds(200, 243, 172, 23);
		internalFrame_1.getContentPane().add(btnNewButton_6_2);
		
		JLabel lblPersonaje = new JLabel("PERSONAJE");
		lblPersonaje.setBounds(65, 11, 87, 14);
		internalFrame_1.getContentPane().add(lblPersonaje);
		
		JLabel lblPartida = new JLabel("PARTIDA");
		lblPartida.setBounds(190, 11, 87, 14);
		internalFrame_1.getContentPane().add(lblPartida);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fabio Coentrao");
		rdbtnNewRadioButton.setBounds(40, 31, 123, 23);
		internalFrame_1.getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("si");
		lblNewLabel_1.setBounds(200, 36, 87, 14);
		internalFrame_1.getContentPane().add(lblNewLabel_1);
		internalFrame_1.setVisible(true);
	
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
