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
import javax.swing.JScrollBar;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;

public class SeleccionarPartida extends JFrame {
	private JLabel logo;
	public SeleccionarPartida() {
		
		getContentPane().setLayout(null);
		setSize(600,400);
		
		logo = new JLabel();
		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(311, 266, 208, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("SELECCIONAR PARTIDA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(188, 54, 208, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("PARTIDA #1");
		btnNewButton_1.setBounds(188, 111, 208, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PARTIDA #2");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(188, 148, 208, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("PARTIDA #3");
		btnNewButton_1_2.setBounds(188, 182, 208, 23);
		getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("VOLVER");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1.setBounds(10, 327, 107, 23);
		getContentPane().add(btnNewButton_1_2_1);
		
		JButton btnIniciarPartida = new JButton("UNIRSE A NUEVA PARTIDA");
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarPartida.setBounds(59, 266, 223, 31);
		getContentPane().add(btnIniciarPartida);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(406, 111, 17, 86);
		getContentPane().add(scrollBar);
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
