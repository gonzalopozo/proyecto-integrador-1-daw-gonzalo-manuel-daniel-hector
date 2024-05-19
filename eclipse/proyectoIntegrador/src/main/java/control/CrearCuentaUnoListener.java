package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

/**
 * Clase que implementa un ActionListener para el primer paso de creación de
 * cuenta.
 * Este ActionListener se utiliza para manejar la acción de pasar al segundo
 * paso
 * de creación de cuenta en la interfaz de usuario de la aplicación.
 */
public class CrearCuentaUnoListener implements ActionListener {

    // Referencias a las vistas del primer paso de crear cuenta y del segundo paso
    // de crear cuenta
    private CrearCuenta crearCuenta;
    private CrearCuentaDos crearCuentaDos;

    /**
     * Constructor de la clase que inicializa las referencias a las vistas.
     *
     * @param crearCuenta    La vista del primer paso de creación de cuenta.
     * @param crearCuentaDos La vista del segundo paso de creación de cuenta.
     */
    public CrearCuentaUnoListener(CrearCuenta crearCuenta, CrearCuentaDos crearCuentaDos) {
        this.crearCuenta = crearCuenta;
        this.crearCuentaDos = crearCuentaDos;
    }

    /**
     * Método que se ejecuta cuando se dispara un evento de acción.
     * Realiza la validación de los campos y gestiona el paso al segundo
     * paso de creación de cuenta en la interfaz de usuario.
     *
     * @param e El evento de acción que desencadenó este método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica si todos los campos están completos y se han aceptado los términos y
        // condiciones de uso
        if ((crearCuenta.getTxtNombre().getText().length() > 0) && (crearCuenta.getTxtApellido().getText().length() > 0)
                && (crearCuenta.getTxtNumExpediente().getText().length() > 0)
                && (crearCuenta.getTxtEstudios().getText().length() > 0)
                && (crearCuenta.getCheckBoxTerminos().isSelected())) {

            // Asigna los valores del primer paso al segundo paso de crearCuentaDos
            CrearCuentaDos.setNombre(crearCuenta.getTxtNombre().getText());
            CrearCuentaDos.setApellido(crearCuenta.getTxtApellido().getText());
            CrearCuentaDos.setNumExpediente(Integer.parseInt(crearCuenta.getTxtNumExpediente().getText()));
            CrearCuentaDos.setEstudios(crearCuenta.getTxtEstudios().getText());

            // Cierra la vista del primer paso y muestra la vista del segundo paso
            crearCuenta.dispose();
            crearCuentaDos.hacerVisible();
        } else {
            // Muestra mensaje de error si los campos no están completados o no se han
            // aceptado los términos
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos y acepte los términos.");
        }
    }

}
