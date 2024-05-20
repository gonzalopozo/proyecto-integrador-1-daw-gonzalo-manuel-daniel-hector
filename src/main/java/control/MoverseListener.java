/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.*;

/**
 * Listener para moverse entre las distinas ventanas.
 */
public class MoverseListener implements ActionListener {

	// Se definen las variables necesarias
	private VistaDefault vistaActual;
	private VistaDefault vistaDestino;

	/**
	 * Constructor que define las vistas necesarias
	 */
	public MoverseListener(VistaDefault vistaActual, VistaDefault vistaDestino) {
		this.vistaActual = vistaActual;
		this.vistaDestino = vistaDestino;
	}

	/**
	 * Método del actionPerformed que cierra la ventana actual, y abre la siguiente
	 */
	public void actionPerformed(ActionEvent e) {

		vistaActual.dispose();

		vistaDestino.setVisible(true);

	}

}
