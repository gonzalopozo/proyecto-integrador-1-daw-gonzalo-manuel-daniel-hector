package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.Font;

public class SeleccionRol extends JFrame {
	private JLabel logo;
	public SeleccionRol() {
		getContentPane().setLayout(null);
		
		setSize(400,230);
		
		logo = new JLabel();
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(104, 118, 175, 30);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ELIGE TU ROL");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 18, 384, 14);
		getContentPane().add(lblNewLabel_1);
		
		JToggleButton customButton = new JToggleButton("JUGADOR");
		customButton.setBounds(122, 83, 140, 23);
		getContentPane().add(customButton);
        /*
		customButton.setFocusPainted(false); // Quitar el contorno al tener el foco
        customButton.setContentAreaFilled(false); // Quitar el área pintada
        customButton.setBorderPainted(true); // Mostrar el borde
        customButton.setOpaque(true); // Hacer el botón opaco
        */
        
        JToggleButton customButton2 = new JToggleButton("GAME MASTER");
		customButton2.setBounds(122, 55, 140, 23);
		getContentPane().add(customButton2);
        /*customButton.setFocusPainted(false); // Quitar el contorno al tener el foco
        customButton.setContentAreaFilled(false); // Quitar el área pintada
        customButton.setBorderPainted(true); // Mostrar el borde
        customButton.setOpaque(true); // Hacer el botón opaco
        */
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(customButton);
        buttonGroup.add(customButton2);
		
		/*JButton btnNewButton_1_1 = new JButton("JUGADOR");
		btnNewButton_1_1.setBounds(408, 361, 157, 23);
		getContentPane().add(btnNewButton_1_1);*/
		
		JButton btnNewButton_1_2 = new JButton("VOLVER");
		btnNewButton_1_2.setBounds(10, 163, 111, 23);
		getContentPane().add(btnNewButton_1_2);
	}
	public void hacerVisible(){
		setVisible(true);
	}
	public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(375, -10, 350, 350);
		getContentPane().add(logo);
	}
}
