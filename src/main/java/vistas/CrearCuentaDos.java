package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CrearCuentaDos extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel logo;
	public CrearCuentaDos() {
		
		getContentPane().setLayout(null);
		
		setSize(700,600);
		
		logo = new JLabel();
		
		textField = new JTextField();
		textField.setBounds(241, 310, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 365, 200, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("CONTINUAR");
		btnNewButton.setBounds(280, 450, 124, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("CREAR CUENTA");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(241, 249, 202, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setBounds(241, 348, 146, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("USUARIO");
		lblNewLabel_4.setBounds(241, 293, 145, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_1 = new JLabel("REPETIR CONTRASEÑA");
		lblNewLabel_2_1.setBounds(241, 393, 267, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(241, 410, 200, 20);
		getContentPane().add(textField_2);
	}
	public void hacerVisible(){
		setVisible(true);
	}
	public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
        logo.setBounds(250, 50, 200, 145);
		getContentPane().add(logo);
	}
}
