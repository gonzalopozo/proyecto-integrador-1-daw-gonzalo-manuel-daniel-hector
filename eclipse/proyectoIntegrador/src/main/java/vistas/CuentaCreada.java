package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CuentaCreada extends JFrame {
	public CuentaCreada() {
		
		getContentPane().setLayout(null);
		
		setSize(500,400);
		
		JLabel check = new JLabel();
		ImageIcon imgCheck = new ImageIcon("src/main/resources/iconoCheck.png");
		check.setIcon(imgCheck);
		check.setBounds(168, 11, 222, 222);
		getContentPane().add(check);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(174, 294, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("¡LISTO!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(199, 233, 85, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SE HA CREADO TU CUENTA");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(136, 258, 212, 14);
		getContentPane().add(lblNewLabel_1_1);
		

	}
	public void hacerVisible(){
		setVisible(true);
	}
}
