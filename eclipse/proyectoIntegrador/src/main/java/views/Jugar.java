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

public class Jugar extends VistaDefault {
	private JLabel lblPersonaje;
	private ImageIcon orco;
	private ArrayList<JToggleButton> botonesPersonajes;
	private ArrayList<String> nombresPersonajes;

	public Jugar() {
		super();
        setSize(1000, 600);
        setLocationRelativeTo(null);
        inicializarComponentes();
        asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
	}

	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		volver = new JButton("VOLVER");
		volver.setBounds(10, 524, 128, 23);
		getContentPane().add(volver);
		Border bordeRojo = BorderFactory.createLineBorder(new Color(247,178,44), 2);
		
		botonesPersonajes = new ArrayList<JToggleButton>();
		
		lblPersonaje = new JLabel();
		getContentPane().add(lblPersonaje);
		lblPersonaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaje.setIcon(orco);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 984, 561);
		getContentPane().add(lblNewLabel);
		orco = new ImageIcon("src/main/resources/loadingScreenWow.jpg");
		
		AccesoBD acceso = new AccesoBD();
		Connection c = acceso.getConexion();
		ArrayList <String> nombresPersonajesArray = null;
		try {
			nombresPersonajesArray = acceso.devolverPersonajesMiembro(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	

	public ArrayList<JToggleButton> getBotonesPersonajes() {
		return botonesPersonajes;
	}

	public void setBotonesPersonajes(ArrayList<JToggleButton> botonesPersonajes) {
		this.botonesPersonajes = botonesPersonajes;
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
