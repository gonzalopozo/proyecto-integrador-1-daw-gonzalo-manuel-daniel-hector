package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonModel;

import main.App;
import model.AccesoBD;
import views.SeleccionRol;
import views.PaginaPrincipal;
import views.PaginaPrincipalGM;

/**
 * Listener para manejar la selección de roles en la página de selección de
 * roles.
 */
public class SeleccionRolListener implements ActionListener {
	private SeleccionRol seleccionRol;
	private PaginaPrincipal paginaPrincipal;
	private PaginaPrincipalGM paginaPrincipalGM;

	/**
	 * Constructor que inicializa los componentes necesarios.
	 * 
	 * @param seleccionRol      La vista de selección de roles.
	 * @param paginaPrincipal   La página principal para los jugadores.
	 * @param paginaPrincipalGM La página principal para el game master.
	 */
	public SeleccionRolListener(SeleccionRol seleccionRol, PaginaPrincipal paginaPrincipal,
			PaginaPrincipalGM paginaPrincipalGM) {
		this.seleccionRol = seleccionRol;
		this.paginaPrincipal = paginaPrincipal;
		this.paginaPrincipalGM = paginaPrincipalGM;
	}

	/**
	 * Maneja el evento de clic en los botones de selección de roles.
	 * 
	 * @param e El evento de acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si se selecciona el rol de GM, se muestra la página principal del GM
		if (seleccionRol.getBtnGroupRoles().getSelection().equals(seleccionRol.getToggleBtnGameMaster().getModel())) {
			seleccionRol.dispose();
			paginaPrincipalGM.hacerVisible();
		} else if (seleccionRol.getBtnGroupRoles()
				.isSelected((ButtonModel) seleccionRol.getToggleBtnJugador().getModel())) {
			// Si se selecciona el rol de jugador
			System.out.println(App.getMiembroActualId());
			AccesoBD accesobd = new AccesoBD(); // Se crea un objeto de acceso a la base de datos
			Connection c = accesobd.getConexion();
			try {
				// Se obtienen los nombres de los personajes del miembro actual
				ArrayList<String> nombresPersonajes = accesobd.devolverPersonajesMiembro(c);

				// Se limpia la pantalla de la página principal del jugador
				paginaPrincipal.limpiarPantalla();
				paginaPrincipal.setNombresPersonajes(nombresPersonajes);

				// Se agregan botones para cada personaje en la página principal
				for (String nombre : nombresPersonajes) {
					paginaPrincipal.agregarBotonPersonaje(nombre);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				accesobd.cerrarConexion(c);
			}
			seleccionRol.dispose();
			paginaPrincipal.hacerVisible();
		}
	}
}