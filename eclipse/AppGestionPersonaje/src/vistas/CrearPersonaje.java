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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class CrearPersonaje extends JFrame {
	public CrearPersonaje() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("CREAR PERSONAJE");
		btnNewButton.setBounds(335, 227, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setBounds(10, 227, 89, 23);
		getContentPane().add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("LOGO ALIANZA");
		lblNewLabel.setBounds(10, 11, 89, 44);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLogoHorda = new JLabel("LOGO HORDA");
		lblLogoHorda.setBounds(335, 11, 89, 44);
		getContentPane().add(lblLogoHorda);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("HOMBRE");
		rdbtnNewRadioButton.setBounds(135, 11, 67, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMujer = new JRadioButton("MUJER");
		rdbtnMujer.setBounds(214, 11, 67, 23);
		getContentPane().add(rdbtnMujer);
		
		JLabel lblNewLabel_1 = new JLabel("SIMBOLO MACHO");
		lblNewLabel_1.setBounds(109, 41, 93, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SIMBOLO HEMBRA");
		lblNewLabel_1_1.setBounds(224, 41, 81, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("RAZA 1");
		rdbtnNewRadioButton_1.setBounds(10, 83, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("RAZA 2");
		rdbtnNewRadioButton_1_1.setBounds(10, 109, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("RAZA 3");
		rdbtnNewRadioButton_1_2.setBounds(10, 135, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("RAZA 4");
		rdbtnNewRadioButton_1_3.setBounds(10, 161, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_3);
		
		JRadioButton rdbtnNewRadioButton_1_4 = new JRadioButton("RAZA 5");
		rdbtnNewRadioButton_1_4.setBounds(10, 187, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4);
		
		JRadioButton rdbtnNewRadioButton_1_4_1 = new JRadioButton("RAZA 6");
		rdbtnNewRadioButton_1_4_1.setBounds(315, 83, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_1);
		
		JRadioButton rdbtnNewRadioButton_1_4_2 = new JRadioButton("RAZA 7");
		rdbtnNewRadioButton_1_4_2.setBounds(315, 109, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_2);
		
		JRadioButton rdbtnNewRadioButton_1_4_3 = new JRadioButton("RAZA 8");
		rdbtnNewRadioButton_1_4_3.setBounds(315, 135, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_3);
		
		JRadioButton rdbtnNewRadioButton_1_4_4 = new JRadioButton("RAZA 9");
		rdbtnNewRadioButton_1_4_4.setBounds(315, 161, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_4);
		
		JRadioButton rdbtnNewRadioButton_1_4_5 = new JRadioButton("RAZA 10");
		rdbtnNewRadioButton_1_4_5.setBounds(315, 187, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1_4_5);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		rdbtnNewRadioButton_2.setBounds(105, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("");
		rdbtnNewRadioButton_2_1.setBounds(128, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_1);
		
		JRadioButton rdbtnNewRadioButton_2_2 = new JRadioButton("");
		rdbtnNewRadioButton_2_2.setBounds(151, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_2);
		
		JRadioButton rdbtnNewRadioButton_2_3 = new JRadioButton("");
		rdbtnNewRadioButton_2_3.setBounds(174, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_3);
		
		JRadioButton rdbtnNewRadioButton_2_4 = new JRadioButton("");
		rdbtnNewRadioButton_2_4.setBounds(197, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_4);
		
		JRadioButton rdbtnNewRadioButton_2_5 = new JRadioButton("");
		rdbtnNewRadioButton_2_5.setBounds(214, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_5);
		
		JRadioButton rdbtnNewRadioButton_2_6 = new JRadioButton("");
		rdbtnNewRadioButton_2_6.setBounds(237, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_6);
		
		JRadioButton rdbtnNewRadioButton_2_7 = new JRadioButton("");
		rdbtnNewRadioButton_2_7.setBounds(260, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_7);
		
		JRadioButton rdbtnNewRadioButton_2_8 = new JRadioButton("");
		rdbtnNewRadioButton_2_8.setBounds(283, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_8);
		
		JRadioButton rdbtnNewRadioButton_2_9 = new JRadioButton("");
		rdbtnNewRadioButton_2_9.setBounds(308, 227, 21, 23);
		getContentPane().add(rdbtnNewRadioButton_2_9);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE PERSONAJE");
		lblNewLabel_2.setBounds(151, 66, 109, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("imagen personaje");
		lblNewLabel_3.setBounds(151, 87, 109, 133);
		getContentPane().add(lblNewLabel_3);
	}
}
