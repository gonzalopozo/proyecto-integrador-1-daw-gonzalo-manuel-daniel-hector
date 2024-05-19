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

public class SeleccionRolListener implements ActionListener {
    private SeleccionRol seleccionRol;
    private PaginaPrincipal paginaPrincipal;
    private PaginaPrincipalGM paginaPrincipalGM;

    

    /**
	 * @param seleccionRol
	 * @param paginaPrincipal
	 * @param paginaPrincipalGM
	 */
	public SeleccionRolListener(SeleccionRol seleccionRol, PaginaPrincipal paginaPrincipal, PaginaPrincipalGM paginaPrincipalGM) {
		this.seleccionRol = seleccionRol;
		this.paginaPrincipal = paginaPrincipal;
		this.paginaPrincipalGM = paginaPrincipalGM;
	}

	@Override
    public void actionPerformed(ActionEvent e){ 
        if (seleccionRol.getBtnGroupRoles().getSelection().equals(seleccionRol.getToggleBtnGameMaster().getModel())) {
			seleccionRol.dispose();
			paginaPrincipalGM.hacerVisible();
        } else if (seleccionRol.getBtnGroupRoles().isSelected((ButtonModel) seleccionRol.getToggleBtnJugador().getModel())) {
        	System.out.println(App.getMiembroActualId());
        	AccesoBD accesobd = new AccesoBD(); 
			Connection c = accesobd.getConexion();
        	try {
				ArrayList<String> nombresPersonajes = accesobd.devolverPersonajesMiembro(c);
				
				paginaPrincipal.limpiarPantalla();
				paginaPrincipal.setNombresPersonajes(nombresPersonajes);

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