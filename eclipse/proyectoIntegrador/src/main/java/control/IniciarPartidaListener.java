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
 * Listener para manejar el evento de iniciar una partida.
 */
public class IniciarPartidaListener implements ActionListener {

    private SeleccionarPartidaGM seleccionarPartidaGM;
    private JugandoGM jugandoGMVista;

    /**
     * Constructor que inicializa los componentes necesarios.
     * 
     * @param seleccionarPartidaGM La ventana de selección de partida del Game
     *                             Master.
     * @param jugandoGMVista       La vista del Game Master mientras juega.
     */
    public IniciarPartidaListener(SeleccionarPartidaGM seleccionarPartidaGM, JugandoGM jugandoGMVista) {
        this.seleccionarPartidaGM = seleccionarPartidaGM;
        this.jugandoGMVista = jugandoGMVista;
        // this.paginaPrincipal = paginaPrincipal;
    }

    /**
     * Maneja el evento de iniciar una partida.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        AccesoBD accesoBD = new AccesoBD();
        Connection c = accesoBD.getConexion();

        // Verificar si se ha seleccionado una partida
        if (SeleccionarPartidaGM.getPartidaSeleccionadaId() == 0) {
            // Mostrar un mensaje de error si no se ha seleccionado una partida
            JOptionPane.showMessageDialog(null, "¡Selecciona una partida!");
        } else {
            // Obtener el ID de la partida seleccionada
            System.out.println(SeleccionarPartidaGM.getPartidaSeleccionadaId());
            try {
                // Iniciar la partida en la BBDD
                accesoBD.iniciarPartida(c, SeleccionarPartidaGM.getPartidaSeleccionadaId());
                ;
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            // Obtener los nombres de los personajes asociados a la partida
            ArrayList<String> arrayPersonajesPartida = null;

            try {
                arrayPersonajesPartida = accesoBD.devolverPersonajespPartida(c,
                        SeleccionarPartidaGM.getPartidaSeleccionadaId());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally {
                accesoBD.cerrarConexion(c);
            }

            // Convertir la lista de nombres de personajes en un arreglo de cadenas
            String[] nombresPersonajes = new String[arrayPersonajesPartida.size()];

            for (int i = 0; i < arrayPersonajesPartida.size(); i++) {
                nombresPersonajes[i] = arrayPersonajesPartida.get(i);
            }

            // Crear un modelo de combo box con los nombres de los personajes asociados a la
            // partida
            DefaultComboBoxModel<String> modelComboBoxNombresPersonajesPartida = new DefaultComboBoxModel<String>(
                    nombresPersonajes);
            // Establecer el modelo de combo box en la vista del Game master mientras juega
            jugandoGMVista.setPersonajesPartidaComboBoxModel(modelComboBoxNombresPersonajesPartida);

            seleccionarPartidaGM.dispose();

            jugandoGMVista.hacerVisible();
        }

    }
}
