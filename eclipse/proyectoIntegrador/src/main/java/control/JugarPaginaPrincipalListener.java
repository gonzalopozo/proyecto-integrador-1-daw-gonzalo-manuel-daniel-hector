package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccesoBD;
import views.*;

import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.*;

/**
 * Listener para manejar el evento de jugar desde la página principal.
 */
public class JugarPaginaPrincipalListener implements ActionListener {

    private PaginaPrincipal paginaPrincipal;
    private UnirsePartida unirsePartida;

    /**
     * Constructor que inicializa los componentes necesarios.
     * 
     * @param paginaPrincipal La página principal desde la cual se va a jugar.
     * @param unirsePartida   La ventana para unirse a una partida.
     */
    public JugarPaginaPrincipalListener(PaginaPrincipal paginaPrincipal, UnirsePartida unirsePartida) {
        this.paginaPrincipal = paginaPrincipal;
        this.unirsePartida = unirsePartida;
    }

    /**
     * Maneja el evento de jugar desde la página principal.
     * 
     * @param e El evento de acción.
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verificar si se ha seleccionado un personaje
        if (PaginaPrincipal.getPersonajeSeleccionadoId() == 0) {
            // Mostrar un mensaje de error si no se ha seleccionado personaje
            JOptionPane.showMessageDialog(null, "¡Selecciona un personaje!");
        } else {
            AccesoBD acceso = new AccesoBD();

            Connection c = acceso.getConexion();
            ArrayList<String[]> datos = null;
            try {
                // Obtener las partidas disponibles para el personaje seleccionado
                datos = acceso.hacerConsultaTablaPartidas(c, PaginaPrincipal.getPersonajeSeleccionadoId());
            } catch (SQLException sqle) {
                sqle.printStackTrace();

            } finally {
                acceso.cerrarConexion(c);
            }

            // Obtener la tabla de unirse a partida
            JTable tabla = unirsePartida.getTable();
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();

            // Limpiar los datos existentes en la tabla
            model.setRowCount(0);

            // Agregar las filas con los datos de las partidas a la tabla
            for (String[] fila : datos) {
                model.addRow(fila);
                System.out.println("Fila agregada: " + Arrays.toString(fila));
                for (String a : fila) {
                    System.out.println(a);
                }
            }
            // Notificar a la tabla que los datos han cambiado
            model.fireTableDataChanged();
            // Establecer el modelo de la tabla
            tabla.setModel(model);

            unirsePartida.setTable(tabla);

            acceso.cerrarConexion(c);

            paginaPrincipal.dispose();

            unirsePartida.hacerVisible();

        }

    }
}
