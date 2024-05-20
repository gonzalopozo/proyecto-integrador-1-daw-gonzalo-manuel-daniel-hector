
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.*;

/**
 * Clase que implementa un ActionListener para cerrar una vista de diálogo.
 * Este ActionListener se utiliza para manejar la acción de cierre de una
 * ventana de diálogo
 * en la interfaz de usuario de la aplicación.
 */
public class CerrarListener implements ActionListener {

	private VistaDefaultDialog vistaCerrar;

	// private int intentosRestantes=3;

	/**
	 * Constructor de la clase que inicializa la vista de diálogo a cerrar.
	 *
	 * @param vistaCerrar La vista de diálogo que se cerrará.
	 */
	public CerrarListener(VistaDefaultDialog vistaCerrar) {
		this.vistaCerrar = vistaCerrar;
	}

	/**
	 * Método que se ejecuta cuando se dispara un evento de acción.
	 * Cierra la vista de diálogo asociada al ActionListener.
	 *
	 * @param e El evento de acción que desencadenó este método.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		vistaCerrar.dispose();
	}

}
