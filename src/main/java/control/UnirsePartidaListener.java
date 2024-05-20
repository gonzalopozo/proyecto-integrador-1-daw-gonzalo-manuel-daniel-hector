package control;

import java.awt.event.*;
import java.sql.*;

import model.AccesoBD;
import views.*;

/**
 * Listener para unirse a la partida con un personaje. Implementa el
 * ActionListener.
 */
public class UnirsePartidaListener implements ActionListener {

    private UnirsePartida unirsePartida;
    private Jugando jugandoVista;

    /**
     * Constructor que define las vistas necesarias
     */
    public UnirsePartidaListener(UnirsePartida unirsePartida, Jugando jugandoVista) {
        this.unirsePartida = unirsePartida;
        this.jugandoVista = jugandoVista;
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

        int selectedRow = unirsePartida.getTable().getSelectedRow();

        if (selectedRow != 1) {
            String nombrePartida = unirsePartida.getTable().getValueAt(selectedRow, 1).toString();
            String ambientacionPartida = unirsePartida.getTable().getValueAt(selectedRow, 2).toString();

            System.out.println(nombrePartida + " - " + ambientacionPartida);

            try {
                accesoBD.unirsePartida(c, PaginaPrincipal.getPersonajeSeleccionadoId(), // se llama al mñetodo de unirse
                                                                                        // partida
                        accesoBD.devolverIdPartida(c, nombrePartida, ambientacionPartida)); // se llama al método de
                                                                                            // devolveridpartida
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            unirsePartida.dispose();
            jugandoVista.hacerVisible();

        }

        accesoBD.cerrarConexion(c);

    }
}
