/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.AccesoBD;
import views.*;

public class MoverseListenerDos implements ActionListener {

	private VistaDefault vistaActual;
	private VistaDefault vistaDestino;

	public MoverseListenerDos(VistaDefault vistaActual, VistaDefault vistaDestino) {	
		this.vistaActual = vistaActual;
		this.vistaDestino = vistaDestino;
	}
	
	public void actionPerformed(ActionEvent e) {

		vistaActual.dispose();

		vistaDestino.setVisible(true);
		
	}

}