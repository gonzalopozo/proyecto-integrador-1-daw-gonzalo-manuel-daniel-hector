package control;

import views.*;
import java.awt.event.*;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.*;

/**
 * Listener para manejar la acción de mostrar detalles de personajes para una
 * partida seleccionada.
 */
public class DetallesPersonajesPartidaJugarListener implements ActionListener {

    private UnirsePartida unirsePartida;
    private DetallesPersonajesPartida detallesPersonajesPartida;

    /**
     * Constructor que inicializa los componentes necesarios.
     * 
     * @param unirsePartida             La ventana de unirse a partida.
     * @param detallesPersonajesPartida La ventana de detalles de personajes para la
     *                                  partida.
     */
    public DetallesPersonajesPartidaJugarListener(UnirsePartida unirsePartida,
            DetallesPersonajesPartida detallesPersonajesPartida) {
        this.unirsePartida = unirsePartida;
        this.detallesPersonajesPartida = detallesPersonajesPartida;
    }

    /**
     * Maneja la acción de mostrar detalles de personajes para una partida
     * seleccionada.
     * 
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener el índice de la fila seleccionada en la tabla de la ventana Unirse a
        // partida
        int selectedRow = unirsePartida.getTable().getSelectedRow();

        if (selectedRow != -1) { // Verificar que una fila esté seleccionada

            // Obtener los datos de cada columna de la fila seleccionada
            String nombrePartida = unirsePartida.getTable().getValueAt(selectedRow, 1).toString();
            String ambientacionPartida = unirsePartida.getTable().getValueAt(selectedRow, 2).toString();

            // Imprimir los datos de la partida seleccionada
            System.out.println(nombrePartida + " - " + ambientacionPartida);

            AccesoBD acceso = new AccesoBD();
            Connection c = acceso.getConexion();

            // ArrayList para almacenar los datos de los personajes de la partida
            ArrayList<String[]> datos = null;
            try {
                // Obtener los detalles de los personajes para la partida seleccionada desde la
                // base de datos
                datos = acceso.hacerConsultaTablaDetallesPartida(c, nombrePartida, ambientacionPartida);
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                // TODO: handle exception
            } finally {
                acceso.cerrarConexion(c);
            }

            // Obtener la tabla de la ventana de detalles de personajes para la partida
            JTable tabla = detallesPersonajesPartida.getTablaDatos();
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();

            // Limpiar los datos existentes en la tabla
            model.setRowCount(0);

            // Agregar las filas con los datos de los personajes a la tabla
            for (String[] fila : datos) {
                // Agregar una fila a la tabla
                model.addRow(fila);
                // Imprimir la fila agregada
                System.out.println("Fila agregada: " + Arrays.toString(fila));
                for (String a : fila) {
                    // Imprimir cada elemento de la fila
                    System.out.println(a);
                }
            }
            // Notificar a la tabla que los datos han cambiado
            model.fireTableDataChanged();
            // Actualizar el modelo de la tabla
            tabla.setModel(model);

            // Establece la tabla actualizada en la ventana de detalles de personajes para
            // la partida
            detallesPersonajesPartida.setTablaDatos(tabla);

            unirsePartida.dispose();
            detallesPersonajesPartida.hacerVisible();

            // Mostrar los datos en un mensaje
        } else {
            // JOptionPane.showMessageDialog(frame, "No hay ninguna fila seleccionada");
        }

    }

}
