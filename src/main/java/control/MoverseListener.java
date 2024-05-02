/**
 * 
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import model.AccesoBD;
import views.*;

public class MoverseListener implements ActionListener {

	private VistaDefault vistaActual;
	private VistaDefault vistaDestino;

	// private int intentosRestantes=3;
	
	public MoverseListener(VistaDefault vistaActual, VistaDefault vistaDestino) {	
		this.vistaActual = vistaActual;
		this.vistaDestino = vistaDestino;
	}
	
	public void actionPerformed(ActionEvent e) {
		// String usuarioVista = vista.getUsuario().getText();
		// String claveVista = String.valueOf(vista.getClave().getPassword());
		// String claveBD="";

		// AccesoBDLogin accesobd = new AccesoBDLogin();
		// Connection conexion = accesobd.getConexion();
		
		// claveBD = accesobd.hacerLogin(conexion, usuarioVista);
		
		// if (claveBD.equals(claveVista)) {
		// 	//acceso conseguido
		// 	vista.getLblIntentos().setText("Acceso conseguido!");
		// }
		// else {
		// 	//acceso denegado
		// 	intentosRestantes--;
		// 	vista.getLblIntentos().setText("Intentos restantes: "+intentosRestantes);
		// }
		
		// if (intentosRestantes == 0) {
		// 	vista.dispose();
		// }

		vistaActual.dispose();

		vistaDestino.setVisible(true);
		
	}

}
