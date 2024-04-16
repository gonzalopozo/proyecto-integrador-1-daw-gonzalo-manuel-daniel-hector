package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class CrearPartida extends JFrame {
	private JTextField textField;
	private JLabel logo;
	public CrearPartida() {
		getContentPane().setLayout(null);
		
		logo = new JLabel();
		
		textField = new JTextField();
		textField.setBounds(400, 310, 200, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("CREAR PARTIDA");
		btnNewButton.setBounds(419, 390, 162, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE PARTIDA");
		lblNewLabel_1.setBounds(400, 292, 186, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AMBIENTACIÓN");
		lblNewLabel_2.setBounds(440, 341, 186, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("CREAR PARTIDA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(400, 263, 200, 14);
		getContentPane().add(lblNewLabel_4);
		
		String [] nombres = {"Estepas de Tong Long", "Suramar", "Cementerio de Dragones", "Zul`Drak", "Sueño Esmeralda", "Argus"};
		JComboBox comboBox = new JComboBox(nombres);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Estepas de Tong Long", "Suramar", "Cementerio de Dragones", "Zul`Drak", "Sueño Esmeralda", "Argus"}));
		comboBox.setBounds(400, 358, 200, 22);
		getContentPane().add(comboBox);
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
