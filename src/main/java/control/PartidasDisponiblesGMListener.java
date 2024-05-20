package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccesoBD;
import views.*;

/**
 * Listener para manejar el evento de mostrar las partidas disponibles en la
 * interfaz del GM.
 */
public class PartidasDisponiblesGMListener implements ActionListener {
	private PaginaPrincipalGM paginaPrincipalGM;
	private SeleccionarPartidaGM seleccionarPartidaGM;

	/**
	 * Constructor que inicializa los componentes necesarios.
	 * 
	 * @param paginaPrincipalGM    La página principal del GM.
	 * @param seleccionarPartidaGM La ventana para seleccionar una partida.
	 */
	public PartidasDisponiblesGMListener(PaginaPrincipalGM paginaPrincipalGM,
			SeleccionarPartidaGM seleccionarPartidaGM) {
		this.paginaPrincipalGM = paginaPrincipalGM;
		this.seleccionarPartidaGM = seleccionarPartidaGM;
	}

	/**
	 * Maneja el evento de mostrar las partidas disponibles.
	 * 
	 * @param e El evento de acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		AccesoBD accesobd = new AccesoBD();
		Connection c = accesobd.getConexion();
		try {
			// Obtener los nombres de las partidas disponibles
			ArrayList<String> nombresPartidas = accesobd.devolverPartidasNombre(c);

			// Limpiar la pantalla de selección de partida
			seleccionarPartidaGM.limpiarPantalla();
			// Establecer los nombres de las partidas disponibles en la ventana
			seleccionarPartidaGM.setNombresPartidas(nombresPartidas);
			// Agregar los botones para cada partida disponible
			for (String nombre : nombresPartidas) {
				seleccionarPartidaGM.agregarBotonPartida(nombre);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			accesobd.cerrarConexion(c);
		}
		paginaPrincipalGM.dispose();
		seleccionarPartidaGM.hacerVisible();

	}
}