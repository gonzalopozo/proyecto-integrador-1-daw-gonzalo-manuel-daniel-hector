package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

/**
 * Clase que implementa un ActionListener para crear un nuevo personaje.
 * Este ActionListener se utiliza para manejar la acción de crear un nuevo
 * personaje
 * en la interfaz de usuario del usuario principal.
 */
public class CrearPersonajeListener implements ActionListener {

    // Referencias a las vistas crearPersonaje y paginaPrincipal
    private CrearPersonaje crearPersonaje;
    private PaginaPrincipal paginaPrincipal;

    /**
     * Constructor de la clase que inicializa las referencias a las vistas.
     *
     * @param crearPersonaje  La vista de creación de personaje.
     * @param paginaPrincipal La vista principal del usuario.
     */
    public CrearPersonajeListener(CrearPersonaje crearPersonaje, PaginaPrincipal paginaPrincipal) {
        this.crearPersonaje = crearPersonaje;
        this.paginaPrincipal = paginaPrincipal;
    }

    /**
     * Método que se ejecuta cuando se dispara un evento de acción.
     * Realiza la acción de crear un nuevo personaje en la interfaz de usuario del
     * usuario principal.
     *
     * @param e El evento de acción que desencadenó este método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Grupo de botones para raza, clase y sexo
        ButtonGroup razaGroup = crearPersonaje.getRaza();
        ButtonGroup claseGroup = crearPersonaje.getClase();
        ButtonGroup sexoGroup = crearPersonaje.getSexo();

        // Verifica si se han seleccionado todas las opciones y se ha proporcionado un
        // nombre para el personaje
        if ((crearPersonaje.getSexo().getSelection() != null) && (crearPersonaje.getRaza().getSelection() != null)
                && (crearPersonaje.getClase().getSelection() != null)
                && (crearPersonaje.getTxtNombrePersonaje().getText().length() > 0)) {
            // Obtiene los datos del nuevo personaje, nombre, raza, clase y sexo
            String nombrePersonaje = crearPersonaje.getTxtNombrePersonaje().getText();
            String razaPersonaje = crearPersonaje.getSelectedButtonText(razaGroup);
            String clasePersonaje = crearPersonaje.getSelectedButtonText(claseGroup);
            String sexoPersonaje = crearPersonaje.getSelectedButtonText(sexoGroup);

            // Crea una instancia de la clase y la conexión a la BBDD
            AccesoBD accesoBD = new AccesoBD();
            Connection c = accesoBD.getConexion();

            // Intenta crear el personaje en la BBDD y obtiene el resultado
            boolean exitoso = accesoBD.crearPersonaje(c, nombrePersonaje, sexoPersonaje, razaPersonaje, clasePersonaje,
                    App.getMiembroActualId());

            accesoBD.cerrarConexion(c);

            // Si la creación del personaje fue exitosa, cierra la vista de creación de
            // personaje, agrega el botón para ese personaje en página principal y la hace
            // visible
            if (exitoso) {
                crearPersonaje.dispose();
                paginaPrincipal.agregarBotonPersonaje(nombrePersonaje);
                paginaPrincipal.hacerVisible();
            }

            // JToggleButton nuevoBotonPersonaje = new JToggleButton(nombrePersonaje);
            // paginaPrincipal.getBotonesPersonajes().add(nuevoBotonPersonaje);
            // paginaPrincipal.getPanelPersonajes().add(nuevoBotonPersonaje);
            // paginaPrincipal.getPanelPersonajes().revalidate();
            // paginaPrincipal.getPanelPersonajes().repaint();

        }

    }

    // public void actionPerformed(ActionEvent e) {
    // if (crearPersonaje.getSexo().isSelected() &&
    // crearPersonaje.getRaza().isSelected() &&
    // crearPersonaje.getClase().isSelected() &&
    // (crearPersonaje.getTxtNombrePersonaje().getText.length() > 0))
    // }
}
