package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

/**
 * Clase que implementa un actionListener para crear una cuenta.
 * Este actionListener se utiliza para manejar el proceso de creación de una
 * cuenta en la interfaz de usuario de la aplicación
 */
public class CrearCuentaDosListener implements ActionListener {

    // Referencia a la vista de crearCuentaDos y crearCuenta
    private CrearCuentaDos crearCuentaDos;
    private CuentaCreada cuentaCreada;

    /**
     * Constructor de la clase que inicializa las referencias a las vistas.
     *
     * @param crearCuentaDos La vista de crear cuenta.
     * @param cuentaCreada   La vista de cuenta creada.
     */
    public CrearCuentaDosListener(CrearCuentaDos crearCuentaDos, CuentaCreada cuentaCreada) {
        this.crearCuentaDos = crearCuentaDos;
        this.cuentaCreada = cuentaCreada;
    }

    /**
     * Método que se ejecuta cuando se dispara un evento de acción.
     * Realiza la validación de los campos de texto y gestiona el proceso de
     * creación de cuenta.
     *
     * @param e El evento de acción que desencadenó este método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica si los campos de texto están llenos y si las contraseñas coinciden
        if ((crearCuentaDos.getTextField().getText().length() > 0)
                && (crearCuentaDos.getTxtContrasena().getText().length() > 0)
                && (crearCuentaDos.getTxtRepetirContrasena().getText().length() > 0) && (crearCuentaDos
                        .getTxtContrasena().getText().equals(crearCuentaDos.getTxtRepetirContrasena().getText()))) {

            // Obtiene los datos del usuario de los campos de texto
            String nombreUsuario = crearCuentaDos.getTextField().getText();
            String contrasenaUsuario = crearCuentaDos.getTxtContrasena().getText();

            // Crea una instancia de la clase de acceso a la BBDD
            AccesoBD accesoBD = new AccesoBD();
            Connection c = accesoBD.getConexion();

            // Llamada al método para crear un nuevo miembro en la BBDD
            accesoBD.crearMiembro(c, nombreUsuario, CrearCuentaDos.getApellido(), contrasenaUsuario,
                    CrearCuentaDos.getNumExpediente(), CrearCuentaDos.getEstudios());

            // Array para almacenar los datos del usuario
            Object[] usuarioDatos = null;
            // ID del usuario, que se inicializa en 0
            int usuarioId = 0;

            // Verifica el login del usuario para obtener su ID
            try {
                usuarioDatos = accesoBD.comprobarLogin(c, nombreUsuario);

                usuarioId = (Integer) usuarioDatos[0];
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            // Imprime el ID del usuario para depuración
            System.out.println(usuarioId);

            // Cierre de la conexión a la BBDD
            accesoBD.cerrarConexion(c);

            // Establece el ID del miembro actual en la aplicación
            App.setMiembroActualId(usuarioId);
            // Cierre de la vista de creación de cuenta y muestra la vista de cuenta creada
            crearCuentaDos.dispose();
            cuentaCreada.hacerVisible();

            // accesoBD.crearCuenta(c, nombrePersonaje, sexoPersonaje, razaPersonaje,
            // clasePersonaje, App.getMiembroActualId());}

            // crearCuenta.dispose();
            // crearCuentaDos.hacerVisible();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }
    }

}
