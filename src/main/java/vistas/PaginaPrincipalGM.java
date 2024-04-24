package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.Color;

public class PaginaPrincipalGM extends JFrame {
	private JLabel logo;
	public PaginaPrincipalGM() {
		getContentPane().setBackground(new Color(25, 69, 122));
		getContentPane().setLayout(null);
		
		logo = new JLabel();
		
		JButton btnNewButton_1 = new JButton("CONTINUAR");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(247, 178, 44));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(408, 314, 184, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("NUEVA PARTIDA");
		btnNewButton_1_1.setBounds(408, 364, 184, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("VOLVER");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(10, 530, 105, 23);
		getContentPane().add(btnNewButton_1_1_1);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(582, 62, 321, 243);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("PARTIDA 1");
		btnNewButton.setBounds(45, 71, 215, 23);
		internalFrame.getContentPane().add(btnNewButton);
		
		JButton btnPartida = new JButton("PARTIDA 2");
		btnPartida.setBounds(45, 105, 215, 23);
		internalFrame.getContentPane().add(btnPartida);
		
		JButton btnNewButton_2 = new JButton("ENTRAR AL MUNDO");
		btnNewButton_2.setBounds(116, 179, 179, 23);
		internalFrame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VOLVER");
		btnNewButton_3.setBounds(10, 179, 96, 23);
		internalFrame.getContentPane().add(btnNewButton_3);
		internalFrame.setVisible(true);
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
