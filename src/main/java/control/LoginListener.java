package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import model.AccesoBD;
import views.*;
import main.*;

/**
 * Clase que implementa la interfaz ActionListener y que se encarga de gestionar
 * el evento de pulsar el botón de login.
 */
public class LoginListener implements ActionListener {

    private Login login;
    private SeleccionRol seleccionRol;
    private int cont = 3;
    private PaginaPrincipal paginaPrincipal;

    /**
     * Constructor de la clase.
     * 
     * @param login        Ventana de login.
     * @param seleccionRol Ventana de selección de rol.
     */
    public LoginListener(Login login, SeleccionRol seleccionRol, PaginaPrincipal paginaPrincipal) {
        this.login = login;
        this.seleccionRol = seleccionRol;
        this.paginaPrincipal = paginaPrincipal;
    }

    /**
     * Método que se ejecuta al ocurrir un evento de acción, como hacer clic en un
     * botón.
     * 
     * @param e Evento de acción.
     */
    // @Override
    // public void actionPerformed(ActionEvent e) {

    //     String password = login.getTxtPassword().getText(); // Obtenemos la contraseña introducida por el usuario
    //     String usuario = login.getTxtUsuario().getText(); // Obtenemos el usuario introducido por el usuario

    //     Object[] usuarioDatos = null; // Array que almacena los datos del usuario
    //     String contraBD = ""; // Contraseña almacenada en la base de datos
    //     int usuarioId; // Id del usuario

    //     AccesoBD acceso = new AccesoBD(); // Creamos un objeto de la clase AccesoBD
    //     Connection c = acceso.getConexion(); // Establecemos la conexión con la base de datos

    //     try {
    //         usuarioDatos = acceso.comprobarLogin(c, usuario); // Comprobamos si el usuario existe en la base de datos
    //     } catch (SQLException ex) { // Si se produce una excepción, la capturamos
    //         ex.printStackTrace();
    //     }
    //     acceso.cerrarConexion(c);

    //     usuarioId = (Integer) usuarioDatos[0]; // Obtenemos el id del usuario del array de datos del usuario
    //     contraBD = (String) usuarioDatos[1]; // Obtenemos la contraseña del usuario del array de datos del
    //                                                 // usuario

    //     if (contraBD == "") { // Si la contraseña es nula, mostramos un mensaje de error
    //         login.getLblMensaje().setText("ERROR Introduza usuario y contraseña.");
    //     } else if (contraBD == "" && password == "") { // Si la contraseña y el usuario son nulos, mostramos un mensaje
    //                                                    // de error
    //         login.getLblMensaje().setText("Este Usuario no existe");
    //     } else if (contraBD.equals(password)) { // Si la contraseña introducida por el usuario es igual a la contraseña
    //                                             // almacenada en la base de datos, mostramos la ventana de selección de
    //                                             // rol
    //         App.setMiembroActual(usuario); // Establecemos el usuario actual
    //         App.setMiembroActualId(usuarioId); // Establecemos el id del usuario actual
    //         login.dispose(); // Cerramos la ventana de login

    //         seleccionRol.hacerVisible(); // Mostramos la ventana de selección de rol

    //         paginaPrincipal.limpiarPantalla();
    //         paginaPrincipal.limpiarTextoImagen();

    //     } else { // Si la contraseña introducida por el usuario no es igual a la contraseña
    //              // almacenada en la base de datos, mostramos un mensaje de error

    //         login.getLblMensaje().setText("Esta contraseña es incorrecta");
    //         cont--; // Decrementamos el contador de intentos
    //         if (cont == 0) { // Si el contador de intentos llega a 0, cerramos la ventana de login
    //             login.dispose(); // Cerramos la ventana de login
    //         }

    //     }

    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = login.getTxtPassword().getText(); // Obtenemos la contraseña introducida por el usuario
        String usuario = login.getTxtUsuario().getText(); // Obtenemos el usuario introducido por el usuario

        Object[] usuarioDatos = null; // Array que almacena los datos del usuario
        String contraBD = ""; // Contraseña almacenada en la base de datos
        int usuarioId; // Id del usuario

        AccesoBD acceso = new AccesoBD(); // Creamos un objeto de la clase AccesoBD
        Connection c = acceso.getConexion(); // Establecemos la conexión con la base de datos

        try {
            usuarioDatos = acceso.comprobarLogin(c, usuario); // Comprobamos si el usuario existe en la base de datos
        } catch (SQLException ex) { // Si se produce una excepción, la capturamos
            ex.printStackTrace();
        }
        acceso.cerrarConexion(c);

        if (usuarioDatos == null) {
            login.getLblMensaje().setText("ERROR Introduza usuario y contraseña.");
            return;
        }

        usuarioId = (Integer) usuarioDatos[0]; // Obtenemos el id del usuario del array de datos del usuario
        contraBD = (String) usuarioDatos[1]; // Obtenemos la contraseña del usuario del array de datos del usuario

        if (contraBD.isEmpty()) { // Si la contraseña es nula, mostramos un mensaje de error
            login.getLblMensaje().setText("ERROR Introduza usuario y contraseña.");
        } else if (contraBD.equals(password)) { // Si la contraseña introducida por el usuario es igual a la contraseña
            // almacenada en la base de datos, mostramos la ventana de selección de rol
            App.setMiembroActual(usuario); // Establecemos el usuario actual
            App.setMiembroActualId(usuarioId); // Establecemos el id del usuario actual
            SeleccionarPartidaGM.setGameMasterId(usuarioId);
            login.dispose(); // Cerramos la ventana de login

            seleccionRol.hacerVisible(); // Mostramos la ventana de selección de rol

            paginaPrincipal.limpiarPantalla();
            paginaPrincipal.limpiarTextoImagen();
        } else { // Si la contraseña introducida por el usuario no es igual a la contraseña
            // almacenada en la base de datos, mostramos un mensaje de error
            login.getLblMensaje().setText("Esta contraseña es incorrecta");
            cont--; // Decrementamos el contador de intentos
            if (cont == 0) { // Si el contador de intentos llega a 0, cerramos la ventana de login
                login.dispose(); // Cerramos la ventana de login
            }
        }
    }

}
