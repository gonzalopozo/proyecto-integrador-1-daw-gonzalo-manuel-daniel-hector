package views;

import javax.swing.*;
import java.awt.*;

public class PaginaPrincipalGM extends VistaDefault {
	private JButton continuar;
	private JButton btnNuevaPartida;
	private JButton volver;
	private JButton btnPartida1;
	private JButton btnPartida2;
	private JButton btnEntrarMundo;
	private JButton btnVolverInternalFrame;

	public PaginaPrincipalGM() {
		super();
		setSize(1000,600);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}
	
	public void inicializarComponentes(){
		continuar = new JButton("CONTINUAR");
		continuar.setForeground(Color.BLACK);
		continuar.setBackground(new Color(247, 178, 44));
		continuar.setBounds(408, 314, 184, 23);
		getContentPane().add(continuar);
		
		btnNuevaPartida = new JButton("NUEVA PARTIDA");
		btnNuevaPartida.setBounds(408, 364, 184, 23);
		getContentPane().add(btnNuevaPartida);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 530, 105, 23);
		getContentPane().add(volver);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(582, 62, 321, 243);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		btnPartida1 = new JButton("PARTIDA 1");
		btnPartida1.setBounds(45, 71, 215, 23);
		internalFrame.getContentPane().add(btnPartida1);
		
		btnPartida2 = new JButton("PARTIDA 2");
		btnPartida2.setBounds(45, 105, 215, 23);
		internalFrame.getContentPane().add(btnPartida2);
		
		btnEntrarMundo = new JButton("ENTRAR AL MUNDO");
		btnEntrarMundo.setBounds(116, 179, 179, 23);
		internalFrame.getContentPane().add(btnEntrarMundo);
		
		btnVolverInternalFrame = new JButton("VOLVER");
		btnVolverInternalFrame.setBounds(10, 179, 96, 23);
		internalFrame.getContentPane().add(btnVolverInternalFrame);
		internalFrame.setVisible(true);
	}
}
