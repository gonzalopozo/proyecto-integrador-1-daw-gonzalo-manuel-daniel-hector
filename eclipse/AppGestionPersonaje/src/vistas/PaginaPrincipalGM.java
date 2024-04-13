package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class PaginaPrincipalGM extends JFrame {
	public PaginaPrincipalGM() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(164, 11, 66, 61);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("CONTINUAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(144, 93, 129, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("NUEVA PARTIDA");
		btnNewButton_1_1.setBounds(144, 143, 129, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("VOLVER");
		btnNewButton_1_2.setBounds(10, 281, 86, 23);
		getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("VOLVER");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(10, 227, 129, 23);
		getContentPane().add(btnNewButton_1_1_1);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(86, 35, 250, 181);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("PARTIDA 1");
		btnNewButton.setBounds(10, 25, 215, 23);
		internalFrame.getContentPane().add(btnNewButton);
		
		JButton btnPartida = new JButton("PARTIDA 2");
		btnPartida.setBounds(10, 59, 215, 23);
		internalFrame.getContentPane().add(btnPartida);
		
		JButton btnNewButton_2 = new JButton("ENTRAR AL MUNDO");
		btnNewButton_2.setBounds(88, 117, 136, 23);
		internalFrame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("VOLVER");
		btnNewButton_3.setBounds(0, 117, 71, 23);
		internalFrame.getContentPane().add(btnNewButton_3);
		internalFrame.setVisible(true);
	}
}
