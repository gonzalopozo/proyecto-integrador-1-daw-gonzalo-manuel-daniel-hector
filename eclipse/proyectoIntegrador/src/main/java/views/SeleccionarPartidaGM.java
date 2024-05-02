package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarPartidaGM extends VistaDefault {
	private JLabel lblSeleccionarPartida;
	private JButton btnPartida1;
	private JButton btnPartida2;
	private JButton btnPartida3;
	private JButton btnEditarPartida;

	public SeleccionarPartidaGM() {
		super();
		setSize(600,400);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		
		
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
		
		continuar = new JButton("UNIRSE A PARTIDA");
		continuar.setBounds(188, 264, 223, 31);
		getContentPane().add(continuar);
		
		volver = new JButton("VOLVER");
		
		volver.setBounds(10, 319, 223, 31);
		getContentPane().add(volver);
		
		btnEditarPartida = new JButton("EDITAR PARTIDA");
		btnEditarPartida.setBounds(351, 323, 223, 31);
		getContentPane().add(btnEditarPartida);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(406, 123, 17, 64);
		getContentPane().add(scrollBar);
	}
}
