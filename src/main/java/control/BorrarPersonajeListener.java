package control;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import model.AccesoBD;
import views.PaginaPrincipal;

/**
 * Clase que implementa un ActionListener para borrar un personaje.
 * Este ActionListener se utiliza para manejar la acción de borrado de un
 * personaje
 * en la interfaz de usuario de la aplicación.
 */
public class BorrarPersonajeListener implements ActionListener {
    private PaginaPrincipal paginaPrincipal;

    
    /**
     * Constructor de la clase que inicializa la referencia a la vista principal.
     *
     * @param paginaPrincipal La vista principal de la aplicación.
     */
    public BorrarPersonajeListener(PaginaPrincipal paginaPrincipal) {
        this.paginaPrincipal = paginaPrincipal;
    }

    /**
     * Método que se ejecuta cuando se dispara un evento de acción.
     * Realiza la acción de borrado de un personaje en la interfaz de usuario.
     *
     * @param e El evento de acción que desencadenó este método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Obtiene el nombre del personaje seleccionado de la vista principal
        String nombrePersonaje = paginaPrincipal.getSelectedButtonText(paginaPrincipal.getBotonesPersonajes());

        // Verifica si se ha seleccionado un personaje
        if (nombrePersonaje != null) {
            // Crea una instancia de la clase de acceso a la base de datos
            AccesoBD accesoBD = new AccesoBD();
            // Obtiene una conexión a la base de datos
            Connection c = accesoBD.getConexion();

            // Array para almacenar los datos del personaje seleccionado
            Object[] prueba;

            try {
                // Obtiene los datos del personaje seleccionado
                prueba = accesoBD.devolverPersonajeSeleccionadoMiembro(c, nombrePersonaje);
                // Borra el personaje de la base de datos
                accesoBD.borrarPersonaje(c, nombrePersonaje, (Integer) prueba[0]);
                // Remueve el botón correspondiente al personaje en la vista
                paginaPrincipal.removeBotonPersonaje(nombrePersonaje);
                // Limpia el texto y la imagen relacionados con el personaje
                paginaPrincipal.limpiarTextoImagen();

            } catch (Exception eX) {

            } finally {
                // Cierre de la conexión a la base de datos
                accesoBD.cerrarConexion(c);
            }
        } else {
            // Muestra un mensaje de error si no se ha seleccionado ningún personaje
            JOptionPane.showMessageDialog(paginaPrincipal, "No se ha seleccionado ningún personaje", "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

}
