package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CuentaCreada extends JFrame {
	public CuentaCreada() {
		getContentPane().setLayout(null);
		
		JLabel check = new JLabel();
		ImageIcon imgCheck = new ImageIcon("src/main/resources/iconoCheck.png");
		check.setIcon(imgCheck);
		check.setBounds(425, 65, 222, 222);
		getContentPane().add(check);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(435, 359, 136, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("¡LISTO!");
		lblNewLabel_1.setBounds(474, 298, 85, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SE HA CREADO TU CUENTA");
		lblNewLabel_1_1.setBounds(413, 323, 212, 14);
		getContentPane().add(lblNewLabel_1_1);
		

	}
	public void hacerVisible(){
		setVisible(true);
	}
}
