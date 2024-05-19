package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import main.App;
import model.AccesoBD;
import views.*;

import java.awt.event.*;

/**
 * Listener para manejar la partida que ha sido seleccionada. Implementa el
 * ItemListener
 */
public class PartidaSeleccionadaListener implements ItemListener {
    private SeleccionarPartidaGM seleccionarPartidaGM;

    /**
     * Constructor para la partida seleccionada
     */
    public PartidaSeleccionadaListener(SeleccionarPartidaGM seleccionarPartidaGM) {
        this.seleccionarPartidaGM = seleccionarPartidaGM;
    }

    /**
     * Maneja el acceso a la base de datos, de la que se obtendrá el id de la
     * partida
     */
    @Override
    public void itemStateChanged(ItemEvent e) {

        // Se crea el acceso a la base de datos
        AccesoBD accesoBD = new AccesoBD();
        Connection c = accesoBD.getConexion();

        if (e.getStateChange() == ItemEvent.SELECTED) {

            // Se crea la variable que almacenará el id de la partida que obtenga de la base
            // de datos.
            int partidaSeleccionadaId = 0;
            try {
                partidaSeleccionadaId = accesoBD.devolverIdPartidaGM(c, seleccionarPartidaGM.getSelectedButtonText(seleccionarPartidaGM.getBotonesPartidas()), App.getmiembroActualId());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally {
                accesoBD.cerrarConexion(c);
            }

            SeleccionarPartidaGM.setPartidaSeleccionadaId(partidaSeleccionadaId);

        }

    }

}