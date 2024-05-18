package views;

import javax.swing.*;

import control.PartidaSeleccionadaListener;
import model.AccesoBD;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.Component;
import java.awt.event.ActionEvent;

public class SeleccionarPartidaGM extends VistaDefault {
	private JLabel lblSeleccionarPartida;
	// private JButton btnPartida1;
	// private JButton btnPartida2;
	// private JButton btnPartida3;
	private JButton btnEditarPartida;
	private ButtonGroup botonesPartidas;	
	private JPanel panelPartidas;
	private ArrayList<String> nombresPartidas;


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
		
		// btnPartida1 = new JButton("PARTIDA #1");
		// btnPartida1.setBounds(188, 111, 208, 23);
		// getContentPane().add(btnPartida1);
		
		// btnPartida2 = new JButton("PARTIDA #2");
		// btnPartida2.setBounds(188, 148, 208, 23);
		// getContentPane().add(btnPartida2);
		
		// btnPartida3 = new JButton("PARTIDA #3");
		// btnPartida3.setBounds(188, 182, 208, 23);
		// getContentPane().add(btnPartida3);
		
		continuar = new JButton("UNIRSE A PARTIDA");
		continuar.setBounds(188, 264, 223, 31);
		getContentPane().add(continuar);
		
		volver = new JButton("VOLVER");
		
		volver.setBounds(10, 319, 223, 31);
		getContentPane().add(volver);
		
		btnEditarPartida = new JButton("EDITAR PARTIDA");
		btnEditarPartida.setBounds(351, 323, 223, 31);
		getContentPane().add(btnEditarPartida);


		botonesPartidas = new ButtonGroup();
		
		// JScrollBar scrollBar = new JScrollBar();
		// scrollBar.setBounds(406, 123, 17, 64);
		// getContentPane().add(scrollBar);

		panelPartidas = new JPanel();
		panelPartidas.setBounds(188, 111, 208, 250);
		getContentPane().add(panelPartidas);


		AccesoBD acceso = new AccesoBD();
		Connection c = acceso.getConexion();
		ArrayList <String> nombresPartidasArray = null;
		
		try {
			nombresPartidasArray = acceso.devolverPartidasNombre(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			acceso.cerrarConexion(c);
		}
		
		//System.out.println(Arrays.toString(nombresPersonajesArray));
		
		// for (String nombrePartida : nombresPartidasArray) {
		// 	System.out.println(nombrePartida);
		// 	agregarBotonPartida(nombrePartida);
		// }	
		if (nombresPartidasArray != null) {
            for (String nombrePartida : nombresPartidasArray) {
                agregarBotonPartida(nombrePartida);
            }
        } else {
            System.out.println("No se encontraron nombres de partidas.");
        }


	}

	public ButtonGroup getBotonesPartidas() {
		return botonesPartidas;
	}

	public void setBotonesPartidas(ButtonGroup botonesPartidas) {
		this.botonesPartidas = botonesPartidas;
	}


	public void agregarBotonPartida(String p) {
		JToggleButton nuevoBotonPartida = new JToggleButton(p);
		botonesPartidas.add(nuevoBotonPartida);
		panelPartidas.add(nuevoBotonPartida);

		nuevoBotonPartida.addItemListener(new PartidaSeleccionadaListener(this));

		// PersonajeSeleccionadoListener itemListener = new PersonajeSeleccionadoListener();

		// nuevoBotonPersonaje.addItemListener();


		panelPartidas.revalidate();
		panelPartidas.repaint();
		
	}


	public void limpiarPartida() {
		for (Component c : panelPartidas.getComponents()) {
			if (c instanceof JToggleButton) {
				botonesPartidas.remove((AbstractButton) c);
				panelPartidas.remove(c);

			}
		}

		panelPartidas.revalidate();
		panelPartidas.repaint();
	}


	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
			
		}

		return null;
	}

	public String getSelectedPartidaNombre() {
		return getSelectedButtonText(botonesPartidas);
	}

}
