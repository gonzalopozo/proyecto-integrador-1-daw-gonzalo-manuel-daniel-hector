package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SeleccionRol extends JFrame {
	private JLabel logo;
	public SeleccionRol() {
		getContentPane().setLayout(null);
		
		logo = new JLabel();
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(408, 395, 157, 38);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ELIGE TU ROL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(408, 302, 157, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("GAME MASTER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(408, 327, 157, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("JUGADOR");
		btnNewButton_1_1.setBounds(408, 361, 157, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("VOLVER");
		btnNewButton_1_2.setBounds(10, 528, 111, 23);
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
