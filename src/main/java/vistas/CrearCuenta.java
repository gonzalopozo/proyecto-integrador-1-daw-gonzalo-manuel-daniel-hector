package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CrearCuenta extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel logo;
	public CrearCuenta() {
		getContentPane().setBackground(new Color(25,69,122));
		getContentPane().setLayout(null);
		
		logo = new JLabel();
		
		textField = new JTextField();
		textField.setBounds(400, 296, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(400, 341, 200, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CREAR CUENTA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(247, 178, 44));
		lblNewLabel_1.setBounds(400, 241, 200, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO");
		lblNewLabel_2.setForeground(new Color(247, 178, 44));
		lblNewLabel_2.setBounds(399, 329, 86, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("CONTINUAR");
		btnNewButton_1.setBounds(438, 513, 124, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("NOMBRE");
		lblNewLabel_3.setForeground(new Color(247, 178, 44));
		lblNewLabel_3.setBounds(399, 282, 86, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nº EXPEDIENTE");
		lblNewLabel_4.setForeground(new Color(247, 178, 44));
		lblNewLabel_4.setBounds(399, 371, 116, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(400, 383, 200, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ESTUDIOS");
		lblNewLabel_5.setForeground(new Color(247, 178, 44));
		lblNewLabel_5.setBounds(399, 416, 86, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(400, 430, 200, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("TÉRMINOS Y CONDICIONES");
		chckbxNewCheckBox.setBounds(400, 466, 252, 23);
		getContentPane().add(chckbxNewCheckBox);
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
