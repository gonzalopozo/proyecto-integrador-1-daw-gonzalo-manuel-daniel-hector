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
		
		logo = new JLabel();
		
		JButton btnNewButton = new JButton("ENTRAR AL MUNDO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(497, 441, 208, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("SELECCIONAR PARTIDA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(387, 300, 208, 14);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("PARTIDA #1");
		btnNewButton_1.setBounds(387, 328, 208, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PARTIDA #2");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(387, 362, 208, 23);
		getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("PARTIDA #3");
		btnNewButton_1_2.setBounds(387, 396, 208, 23);
		getContentPane().add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("VOLVER");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_1.setBounds(10, 529, 107, 23);
		getContentPane().add(btnNewButton_1_2_1);
		
		JButton btnIniciarPartida = new JButton("UNIRSE A PARTIDA");
		btnIniciarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarPartida.setBounds(260, 441, 208, 31);
		getContentPane().add(btnIniciarPartida);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(625, 328, 17, 86);
		getContentPane().add(scrollBar);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(60, 11, 449, 290);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PARTIDA 45");
		rdbtnNewRadioButton.setBounds(6, 40, 109, 23);
		internalFrame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("PARTIDA 46");
		rdbtnNewRadioButton_1.setBounds(6, 66, 109, 23);
		internalFrame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("PARTIDA 47");
		rdbtnNewRadioButton_2.setBounds(6, 92, 109, 23);
		internalFrame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_2 = new JButton("VOLVER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(6, 226, 109, 23);
		internalFrame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("UNIRSE");
		btnNewButton_3.setBounds(334, 226, 89, 23);
		internalFrame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DETALLES");
		btnNewButton_4.setBounds(168, 226, 122, 23);
		internalFrame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("AMBIENTACIÓN");
		lblNewLabel.setBounds(168, 11, 122, 14);
		internalFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNivelMedio = new JLabel("NIVEL MEDIO");
		lblNivelMedio.setBounds(322, 11, 101, 14);
		internalFrame.getContentPane().add(lblNivelMedio);
		
		JLabel lblNewLabel_1 = new JLabel("PARTIDA");
		lblNewLabel_1.setBounds(24, 11, 71, 14);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JInternalFrame internalFrame_1 = new JInternalFrame("New JInternalFrame");
		internalFrame_1.setBounds(63, 311, 261, 191);
		getContentPane().add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("meter detalles personajes");
		lblNewLabel_2.setBounds(22, 11, 142, 96);
		internalFrame_1.getContentPane().add(lblNewLabel_2);
		internalFrame_1.setVisible(true);
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
