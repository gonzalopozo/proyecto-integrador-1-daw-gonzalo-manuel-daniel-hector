package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonModel;

import main.App;
import model.AccesoBD;
import views.*;

public class PartidasDisponiblesGMListener implements ActionListener {
    private PaginaPrincipalGM paginaPrincipalGM;
    private SeleccionarPartidaGM seleccionarPartidaGM;

    public PartidasDisponiblesGMListener(PaginaPrincipalGM paginaPrincipalGM, SeleccionarPartidaGM seleccionarPartidaGM) {
		this.paginaPrincipalGM = paginaPrincipalGM;
		this.seleccionarPartidaGM = seleccionarPartidaGM;
	}

	@Override
    public void actionPerformed(ActionEvent e){ 
		AccesoBD accesobd = new AccesoBD(); 
		Connection c = accesobd.getConexion();
		try {
			ArrayList<String> nombresPersonajes = accesobd.devolverPartidasNombre(c);
			
			// seleccionarPartidaGM.limpiarPantalla();
			// seleccionarPartidaGM.setNombresPersonajes(nombresPersonajes);
		for (String nombre : nombresPersonajes) {
				seleccionarPartidaGM.agregarBotonPartida(nombre);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			accesobd.cerrarConexion(c);
		}
		paginaPrincipalGM.dispose();
		seleccionarPartidaGM.hacerVisible();
		
    }
}