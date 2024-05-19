package control;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

/**
 * Listener para unirse a la partida con un personaje. Implementa el
 * ActionListener.
 */
public class EditarPartidaListener implements ActionListener {

    private EditarPartida editarPartidaVista;
    private SeleccionarPartidaGM seleccionarPartidaGM;

    /**
     * Constructor que define las vistas necesarias
     */
    public EditarPartidaListener(EditarPartida editarPartidaVista, SeleccionarPartidaGM seleccionarPartidaGM) {
        this.editarPartidaVista = editarPartidaVista;
        this.seleccionarPartidaGM = seleccionarPartidaGM;
    }

    /**
     * Método que accederá a la base de datos y del que se obtendrá el nombre de la
     * partida y su ambientación
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Se crea el acceso a la base de datos.
        AccesoBD accesoBD = new AccesoBD();
        Connection c = accesoBD.getConexion();

        int partidaId = SeleccionarPartidaGM.getPartidaSeleccionadaId();
         
        String nuevoNombrePartida = editarPartidaVista.getTxtNombrePartida().getText();
        String neuvaAmbientacionPartida = (String) editarPartidaVista.getCmbAmbientacion().getSelectedItem();

        try {
			accesoBD.editarPartida(c, nuevoNombrePartida, neuvaAmbientacionPartida, partidaId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ArrayList<String> nombresPartidas;
		try {
			nombresPartidas = accesoBD.devolverPartidasNombre(c);
			seleccionarPartidaGM.limpiarPantalla();
			//Establecer los nombres de las partidas disponibles en la ventana
			seleccionarPartidaGM.setNombresPartidas(nombresPartidas);
			
			for (String nombre : nombresPartidas) {
				seleccionarPartidaGM.agregarBotonPartida(nombre);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //Limpiar la pantalla de selección de partida
		
        accesoBD.cerrarConexion(c);
        
        editarPartidaVista.dispose();
        seleccionarPartidaGM.hacerVisible();


    }
}
