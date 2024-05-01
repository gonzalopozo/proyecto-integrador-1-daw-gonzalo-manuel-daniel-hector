package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

public class Login extends JFrame {
	private JTextField txtUsuario;
	private JTextField textField_1;
	private JLabel logo;
	public Login() {
		
		getContentPane().setLayout(null);
		
		setSize(600,500);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(192, 247, 200, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 296, 200, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("INICIAR \n SESIÓN");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setForeground(new Color (42, 42, 42));
		btnNewButton.setBackground(new Color(247, 178,44));
		btnNewButton.setBounds(214, 329, 156, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color (247, 178, 44));
		lblNewLabel_1.setBackground(new Color(255, 255, 51));
		lblNewLabel_1.setBounds(192, 226, 100, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASEÑA");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color (247, 178, 44));
		lblNewLabel_2.setBounds(192, 278, 200, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("¿Todavía no tienes cuenta?");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setForeground(new Color (247, 178, 44));
		lblNewLabel_3.setBounds(129, 389, 179, 19);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("CREAR CUENTA");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color (42, 42, 42));
		btnNewButton_1.setBackground(new Color(247, 178,44));
		btnNewButton_1.setBounds(318, 382, 164, 31);
		getContentPane().add(btnNewButton_1);
		
		logo = new JLabel();


        
	}
	
	public void hacerVisible(){
		setVisible(true);
	}
	
	public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
		logo.setBounds(200, 50, 200, 145);
		getContentPane().add(logo);
	}
}
