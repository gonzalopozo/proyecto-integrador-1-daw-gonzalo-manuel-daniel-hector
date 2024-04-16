package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CrearCuentaDos extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel logo;
	public CrearCuentaDos() {
		getContentPane().setLayout(null);
		
		logo = new JLabel();
		
		textField = new JTextField();
		textField.setBounds(400, 296, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(400, 351, 200, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(438, 427, 124, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("CREAR CUENTA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(398, 242, 202, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setBounds(400, 332, 146, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("USUARIO");
		lblNewLabel_4.setBounds(400, 280, 145, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("REPETIR CONTRASEÑA");
		lblNewLabel_2_1.setBounds(400, 379, 267, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(400, 396, 200, 20);
		getContentPane().add(textField_2);
	}
	public void hacerVisible(){
		setVisible(true);
	}
	public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(375, -40, 350, 350);
		getContentPane().add(logo);
	}
}
