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
 * ActionListener para mostrar los detalles de los niveles jugando.
 */
public class DetallesNivelesJugandoListener implements ActionListener {

    // Referencias a las vistas uniserPartida y detallesNivelesJugando
    private UnirsePartida unirsePartida;
    private DetallesNivelesJugando detallesNivelesJugando;

    /**
     * Constructor que inicializa las referencias a las vistas necesarias.
     * 
     * @param unirsePartida          Vista para unirse a una partida.
     * @param detallesNivelesJugando Vista de detalles de niveles jugando.
     */
    public DetallesNivelesJugandoListener(UnirsePartida unirsePartida, DetallesNivelesJugando detallesNivelesJugando) {
        this.unirsePartida = unirsePartida;
        this.detallesNivelesJugando = detallesNivelesJugando;
    }

    /**
     * Método que se ejecuta cuando se dispara un evento de acción.
     * 
     * @param e Evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtiene la fila seleccionada en la tabla de unirse a partida
        int selectedRow = unirsePartida.getTable().getSelectedRow();

        AccesoBD acceso = new AccesoBD();

        Connection c = acceso.getConexion();
        ArrayList<String[]> datos = null;
        int partidaId = 0;
        try {
            // Obtiene el ID de la partida seleccionada
            partidaId = acceso.devolverIdPartida(c, unirsePartida.getTable().getValueAt(selectedRow, 1).toString(),
                    unirsePartida.getTable().getValueAt(selectedRow, 2).toString());
            // Obtiene los datos de los niveles del personaje para la partida seleccionada
            datos = acceso.hacerConsultaNivelesPersonaje(c, PaginaPrincipal.getPersonajeSeleccionadoId(), partidaId);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            // TODO: handle exception
        } finally {
            acceso.cerrarConexion(c);
        }

        JTable tabla = detallesNivelesJugando.getTablaDatos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        // Limpia los datos existentes en la tabla
        model.setRowCount(0);

        // Agrega las filas con los datos de los niveles jugando a la tabla
        for (String[] fila : datos) {
            // Agrega una fila a la tabla
            model.addRow(fila);
            // Imprime la fila agregada
            System.out.println("Fila agregada: " + Arrays.toString(fila));
            for (String a : fila) {
                // Imprime cada elemento de la fila
                System.out.println(a);
            }
        }
        // Notifica a la tabla que los datos han cambiado
        model.fireTableDataChanged();
        // Actualiza el modelo de la tabla
        tabla.setModel(model);

        // Establece la taba actualizada en la vista
        detallesNivelesJugando.setTablaDatos(tabla);

        acceso.cerrarConexion(c);

        detallesNivelesJugando.hacerVisible();

    }
}
