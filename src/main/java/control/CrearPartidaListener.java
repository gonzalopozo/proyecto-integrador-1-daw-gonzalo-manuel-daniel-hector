package control;

import java.awt.event.*;
import java.sql.*;

import model.AccesoBD;
import views.*;
import main.*;

/**
 * Clase que implementa un ActionListener para crear una nueva partida.
 * Este ActionListener se utiliza para manejar la acción de crear una nueva
 * partida
 * en la interfaz de usuario del Game Master.
 */
public class CrearPartidaListener implements ActionListener {

    // Referencia a las vistas crearPartida y paginaPrincipalGM
    private CrearPartida crearPartida;
    private PaginaPrincipalGM paginaPrincipalGM;

    /**
     * Constructor de la clase que inicializa las referencias a las vistas.
     *
     * @param crearPartida      La vista de creación de partida.
     * @param paginaPrincipalGM La vista principal del Game Master.
     */
    public CrearPartidaListener(CrearPartida crearPartida, PaginaPrincipalGM paginaPrincipalGM) {
        this.crearPartida = crearPartida;
        this.paginaPrincipalGM = paginaPrincipalGM;
    }

    /**
     * Método que se ejecuta cuando se dispara un evento de acción.
     * Realiza la acción de crear una nueva partida en la interfaz de usuario del
     * Game Master.
     *
     * @param e El evento de acción que desencadenó este método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Verifica si el campo de nombre de partida está lleno
        if ((crearPartida.getTxtNombrePartida().getText().length() > 0)) {
            // Imprime el ID del miembro actual para depuración
            System.out.println(App.getMiembroActualId());
            // Se obtienen el nombre y la ambientación de la partida
            String nombrePartida = crearPartida.getTxtNombrePartida().getText();
            String ambientacionPartida = crearPartida.getCmbAmbientacion().getSelectedItem().toString();

            // Creación de la instancia y obtención de la conexión a la BBDD
            AccesoBD accesoBD = new AccesoBD();
            Connection c = accesoBD.getConexion();

            // Crea la partida en la BBDD
            accesoBD.crearPartida(c, nombrePartida, App.getMiembroActualId(), ambientacionPartida);
            // Cierre de la conexión
            accesoBD.cerrarConexion(c);
            // Cierre de la vista
            crearPartida.dispose();
            // Muestra la vista principal del GM
            paginaPrincipalGM.hacerVisible();

        }

    }
}
