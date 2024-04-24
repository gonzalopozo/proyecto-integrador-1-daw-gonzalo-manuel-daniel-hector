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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class CrearPersonaje extends JFrame {
	public CrearPersonaje() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CREAR PERSONAJE");
		btnNewButton.setBounds(778, 515, 200, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(9, 515, 150, 23);
		getContentPane().add(btnVolver);
		
		JLabel logoAlianza = new JLabel();
		ImageIcon imgAlianza = new ImageIcon("src/main/resources/alianzaIcono.png");
		logoAlianza.setIcon(imgAlianza);
		logoAlianza.setBounds(9, 10, 98, 98);
		getContentPane().add(logoAlianza);
		
		JLabel logoHorda = new JLabel();
		ImageIcon imgHorda = new ImageIcon("src/main/resources/hordaIcono.png");
		logoHorda.setIcon(imgHorda);
		logoHorda.setBounds(880, 10, 98, 98);
		getContentPane().add(logoHorda);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setBounds(488, 11, 20, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMujer = new JRadioButton("");
		rdbtnMujer.setBounds(555, 11, 20, 23);
		getContentPane().add(rdbtnMujer);
		
		JLabel iconoHombre = new JLabel();
		ImageIcon imgHombre = new ImageIcon("src/main/resources/iconoHombre.png");
		iconoHombre.setIcon(imgHombre);
		iconoHombre.setBounds(468, 10, 98, 98);
		getContentPane().add(iconoHombre);
		
		JLabel iconoMujer = new JLabel();
		ImageIcon imgMujer = new ImageIcon("src/main/resources/iconoMujer.png");
		iconoMujer.setIcon(imgMujer);
		iconoMujer.setBounds(532, 10, 98, 98);
		getContentPane().add(iconoMujer);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("RAZA 1");
		rdbtnNewRadioButton_1.setBounds(17, 156, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("RAZA 2");
		rdbtnNewRadioButton_1_1.setBounds(17, 182, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("RAZA 3");
		rdbtnNewRadioButton_1_2.setBounds(17, 208, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("RAZA 4");
		rdbtnNewRadioButton_1_3.setBounds(17, 234, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_3);
		
		JRadioButton rdbtnNewRadioButton_1_4 = new JRadioButton("RAZA 5");
		rdbtnNewRadioButton_1_4.setBounds(17, 260, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4);
		
		JRadioButton rdbtnNewRadioButton_1_4_1 = new JRadioButton("RAZA 6");
		rdbtnNewRadioButton_1_4_1.setBounds(884, 156, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_1);
		
		JRadioButton rdbtnNewRadioButton_1_4_2 = new JRadioButton("RAZA 7");
		rdbtnNewRadioButton_1_4_2.setBounds(884, 182, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_2);
		
		JRadioButton rdbtnNewRadioButton_1_4_3 = new JRadioButton("RAZA 8");
		rdbtnNewRadioButton_1_4_3.setBounds(884, 208, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_3);
		
		JRadioButton rdbtnNewRadioButton_1_4_4 = new JRadioButton("RAZA 9");
		rdbtnNewRadioButton_1_4_4.setBounds(884, 234, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_4);
		
		JRadioButton rdbtnNewRadioButton_1_4_5 = new JRadioButton("RAZA 10");
		rdbtnNewRadioButton_1_4_5.setBounds(884, 260, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_5);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(426, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("");
		rdbtnNewRadioButton_2_1.setBounds(449, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_1);
		
		JRadioButton rdbtnNewRadioButton_2_2 = new JRadioButton("");
		rdbtnNewRadioButton_2_2.setBounds(472, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_2);
		
		JRadioButton rdbtnNewRadioButton_2_3 = new JRadioButton("");
		rdbtnNewRadioButton_2_3.setBounds(495, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_3);
		
		JRadioButton rdbtnNewRadioButton_2_4 = new JRadioButton("");
		rdbtnNewRadioButton_2_4.setBounds(518, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_4);
		
		JRadioButton rdbtnNewRadioButton_2_5 = new JRadioButton("");
		rdbtnNewRadioButton_2_5.setBounds(535, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_5);
		
		JRadioButton rdbtnNewRadioButton_2_6 = new JRadioButton("");
		rdbtnNewRadioButton_2_6.setBounds(558, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_6);
		
		JRadioButton rdbtnNewRadioButton_2_7 = new JRadioButton("");
		rdbtnNewRadioButton_2_7.setBounds(581, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_7);
		
		JRadioButton rdbtnNewRadioButton_2_8 = new JRadioButton("");
		rdbtnNewRadioButton_2_8.setBounds(604, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_8);
		
		JRadioButton rdbtnNewRadioButton_2_9 = new JRadioButton("");
		rdbtnNewRadioButton_2_9.setBounds(629, 515, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_9);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE PERSONAJE");
		lblNewLabel_2.setBounds(426, 120, 200, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel personaje = new JLabel();
		ImageIcon orco = new ImageIcon("src/main/resources/imagenOrco.png");
		personaje.setIcon(orco);
		personaje.setBounds(350, 150, 300, 300);
		getContentPane().add(personaje);
	}
	public void hacerVisible(){
		setVisible(true);
	}
}
