package views;


import javax.swing.*;
import javax.swing.border.*;

import control.*;
import model.AccesoBD;
import model.Personaje;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class PaginaPrincipal extends VistaDefault {

	private JButton btnJugar;
	private JButton btnCrearPersonaje;
	private JButton btnVerPartidas;
	private JLabel lblPersonaje;
	private JLabel lblNombrePersonaje;
	private ImageIcon orco;
	private JPanel pnlContenedor;
	private JPanel panelPersonajes;
	private ArrayList<JToggleButton> botonesPersonajes;
	private ArrayList<String> nombresPersonajes;

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

		// if (accesoBD.getCrearpersonaje){
		// toggleBtnJugador = new JToggleButton();
		// toggleBtnJugador.setBounds(122, 83, 140, 23);
		// getContentPane().add(toggleBtnJugador);
		// }

		


//		JToggleButton toogleBtnPersonajeNuevo1 = new JToggleButton("PERSONAJE 1");
//		toogleBtnPersonajeNuevo1.setBounds(10, 58, 191, 23);
//		pnlContenedor.add(toogleBtnPersonajeNuevo1);
//		
//		JToggleButton toogleBtnPersonajeNuevo2 = new JToggleButton("PERSONAJE 2");
//		toogleBtnPersonajeNuevo2.setBounds(10, 92, 191, 23);
//		pnlContenedor.add(toogleBtnPersonajeNuevo2);
		
		btnVerPartidas = new JButton("VER PARTIDAS");
		btnVerPartidas.setBounds(29, 11, 151, 23);
		pnlContenedor.add(btnVerPartidas);
		
		botonesPersonajes = new ArrayList<JToggleButton>();
		
		
		panelPersonajes = new JPanel();
		panelPersonajes.setBounds(20, 44, 167, 442);
		pnlContenedor.add(panelPersonajes);
		
		lblPersonaje = new JLabel();
		getContentPane().add(lblPersonaje);
		lblPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaje.setIcon(orco);
		orco = new ImageIcon("src/main/resources/enanoBailongo.gif");
		
		lblNombrePersonaje = new JLabel("PepeElDelMadrid");
		lblNombrePersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePersonaje.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombrePersonaje.setBounds(410, 400, 164, 81);
		getContentPane().add(lblNombrePersonaje);
		
		AccesoBD acceso = new AccesoBD();
		Connection c = acceso.getConexion();
		ArrayList <String> nombresPersonajesArray = null;
		try {
			nombresPersonajesArray = acceso.devolverPersonajesMiembro(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(Arrays.toString(nombresPersonajesArray));
		
		for (String nombrePersonaje : nombresPersonajesArray) {
			System.out.println(nombrePersonaje);
			agregarBotonPersonaje(nombrePersonaje);
		}
		
	}

	public JPanel getPanelPersonajes() {
		return panelPersonajes;
	}

	public void setPanelPersonajes(JPanel panelPersonajes) {
		this.panelPersonajes = panelPersonajes;
	}

	public ArrayList<JToggleButton> getBotonesPersonajes() {
		return botonesPersonajes;
	}

	public void setBotonesPersonajes(ArrayList<JToggleButton> botonesPersonajes) {
		this.botonesPersonajes = botonesPersonajes;
	}

	public void setListenerBotonJugar(MoverseListener listener) {
		btnJugar.addActionListener(listener);
	}

	public void setListenerBotonCrearPersonaje(MoverseListener listener) {
		btnCrearPersonaje.addActionListener(listener);
	}

	public void setListenerBotonVerPartidas(DetallesPersonajesListener listener) {
		btnVerPartidas.addActionListener(listener);
	}
	
	public void agregarBotonPersonaje(String p) {
		JToggleButton nuevoBotonPersonaje = new JToggleButton(p);
        botonesPersonajes.add(nuevoBotonPersonaje);
        panelPersonajes.add(nuevoBotonPersonaje);

        panelPersonajes.revalidate();
        panelPersonajes.repaint();
        
	}

	public ArrayList<String> getNombresPersonajes() {
		return nombresPersonajes;
	}

	public void setNombresPersonajes(ArrayList<String> nombresPersonajes) {
		this.nombresPersonajes = nombresPersonajes;
	}
	
	public void limpiarPersonajes() {
		
	}
	
}
