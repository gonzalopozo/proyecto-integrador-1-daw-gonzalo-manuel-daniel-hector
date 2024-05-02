package views;

import javax.swing.*;


public class PartidasDisponibles extends VistaDefault {
	private JLabel lblPartidasDisponibles;

	public PartidasDisponibles() {
		super();
		setSize(1000, 600);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	private void inicializarComponentes() {
		continuar = new JButton("ENTRAR A PARTIDA");
		continuar.setBounds(396, 416, 208, 31);
		getContentPane().add(continuar);
		
		lblPartidasDisponibles = new JLabel("PARTIDAS DISPONIBLES");
		lblPartidasDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartidasDisponibles.setBounds(396, 276, 208, 14);
		getContentPane().add(lblPartidasDisponibles);
		
		//TODO: Toggle Button
		JButton btnNewButton_1 = new JButton("PARTIDA #1");
		btnNewButton_1.setBounds(396, 305, 208, 23);
		getContentPane().add(btnNewButton_1);
		
		//Toggle Button
		JButton btnNewButton_1_1 = new JButton("PARTIDA #2");
		btnNewButton_1_1.setBounds(396, 340, 208, 23);
		getContentPane().add(btnNewButton_1_1);
		
		//Toggle Button
		JButton btnNewButton_1_2 = new JButton("PARTIDA #3");
		btnNewButton_1_2.setBounds(396, 374, 208, 23);
		getContentPane().add(btnNewButton_1_2);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 527, 106, 23);
		getContentPane().add(volver);

	}
}
