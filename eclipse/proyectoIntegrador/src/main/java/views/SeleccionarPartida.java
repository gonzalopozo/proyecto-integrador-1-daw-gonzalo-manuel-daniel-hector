package views;

import javax.swing.*;

public class SeleccionarPartida extends VistaDefault {
	private JLabel lblSeleccionarPartida;
	private JButton btnPartida1;
	private JButton btnPartida2;
	private JButton btnPartida3;
	private JButton btnUnirsePartida;
	private JScrollBar scrBarraHorizontal;

	public SeleccionarPartida() {
		super();
		setSize(600,400);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		continuar = new JButton("JUGAR");
		continuar.setBounds(311, 266, 208, 31);
		getContentPane().add(continuar);
		
		lblSeleccionarPartida = new JLabel("SELECCIONAR PARTIDA");
		lblSeleccionarPartida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionarPartida.setBounds(188, 54, 208, 14);
		getContentPane().add(lblSeleccionarPartida);
		
		btnPartida1 = new JButton("PARTIDA #1");
		btnPartida1.setBounds(188, 111, 208, 23);
		getContentPane().add(btnPartida1);
		
		btnPartida2 = new JButton("PARTIDA #2");
		btnPartida2.setBounds(188, 148, 208, 23);
		getContentPane().add(btnPartida2);
		
		btnPartida3 = new JButton("PARTIDA #3");
		btnPartida3.setBounds(188, 182, 208, 23);
		getContentPane().add(btnPartida3);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 327, 107, 23);
		getContentPane().add(volver);
		
		btnUnirsePartida = new JButton("UNIRSE A NUEVA PARTIDA");
		btnUnirsePartida.setBounds(59, 266, 223, 31);
		getContentPane().add(btnUnirsePartida);
		
		scrBarraHorizontal = new JScrollBar();
		scrBarraHorizontal.setBounds(406, 111, 17, 86);
		getContentPane().add(scrBarraHorizontal);
	}
}
