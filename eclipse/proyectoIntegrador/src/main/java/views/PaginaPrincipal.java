package views;


import javax.swing.*;
import javax.swing.border.*;

import control.MoverseListener;

import java.awt.*;

public class PaginaPrincipal extends VistaDefault {

	private JButton btnJugar;
	private JButton btnCrearPersonaje;
	private JButton btnVerPartidas;
	private JLabel lblPersonaje;
	private JLabel lblNombrePersonaje;
	private ImageIcon orco;
	private JPanel pnlContenedor;

	public PaginaPrincipal() {
		super();
        setSize(1000, 600);
        setLocationRelativeTo(null);
        inicializarComponentes();
        asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(439, 524, 89, 23);
		getContentPane().add(btnJugar);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 524, 128, 23);
		getContentPane().add(volver);
		
		pnlContenedor = new JPanel();
		pnlContenedor.setForeground(new Color(255, 255, 255));
		pnlContenedor.setBounds(754, 10, 211, 539);
		getContentPane().add(pnlContenedor);
		pnlContenedor.setLayout(null);
		Border bordeRojo = BorderFactory.createLineBorder(new Color(247,178,44), 2);
		pnlContenedor.setBorder(bordeRojo);
		
		btnCrearPersonaje = new JButton("CREAR PERSONAJE");
		btnCrearPersonaje.setBounds(10, 510, 191, 23);
		pnlContenedor.add(btnCrearPersonaje);
		
		//TODO: JToggleButton
		JButton btnNewButton_2 = new JButton("PERSONAJE 1");
		btnNewButton_2.setBounds(10, 58, 191, 23);
		pnlContenedor.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PERSONAJE 2");
		btnNewButton_3.setBounds(10, 92, 191, 23);
		pnlContenedor.add(btnNewButton_3);
		
		btnVerPartidas = new JButton("VER PARTIDAS");
		btnVerPartidas.setBounds(29, 11, 151, 23);
		pnlContenedor.add(btnVerPartidas);
		
		lblPersonaje = new JLabel();
		lblPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		orco = new ImageIcon("src/main/resources/enanoBailongo.gif");
		lblPersonaje.setIcon(orco);
		lblPersonaje.setBounds(342, 150, 300, 300);
		getContentPane().add(lblPersonaje);
		
		lblNombrePersonaje = new JLabel("PepeElDelMadrid");
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombrePersonaje.setBounds(410, 400, 164, 81);
		getContentPane().add(lblNombrePersonaje);
	}

	public void setListenerBotonJugar(MoverseListener listener) {
		btnJugar.addActionListener(listener);
	}

	public void setListenerBotonCrearPersonaje(MoverseListener listener) {
		btnCrearPersonaje.addActionListener(listener);
	}

	public void setListenerBotonVerPartidas(MoverseListener listener) {
		btnVerPartidas.addActionListener(listener);
	}

	//TODO: ACTUALIZAR TABLA VER PARTIDAS (MIEMBRO) AL CLICAR EN EL LISTENER 

	// public void setListenerBotonActualizarTablaPartidas(){
	// 	btnActualizarTablaPartidas(listener);
	// }
}
