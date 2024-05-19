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
 * Listener para manejar la acción de mostrar detalles de personajes.
 */
public class DetallesPersonajesListener implements ActionListener {
    
    private PaginaPrincipal paginaPrincipal;
    private DetallesPersonajesCuenta detallesPersonajesCuenta;

    /**
     * Constructor que inicializa los componentes necesarios.
     * @param paginaPrincipal La página principal.
     * @param detallesPersonajesCuenta La ventana de detalles de personajes.
     */
    public DetallesPersonajesListener(PaginaPrincipal paginaPrincipal, DetallesPersonajesCuenta detallesPersonajesCuenta) {
        this.paginaPrincipal = paginaPrincipal;
        this.detallesPersonajesCuenta = detallesPersonajesCuenta;
    }

    /**
     * Maneja la acción de mostrar detalles de personajes.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        
        AccesoBD acceso = new AccesoBD();
        
        Connection c = acceso.getConexion();
        ArrayList<String[]> datos = null;
        try {
            //Obtiene los datos de la cuenta desde la base de datos
            datos = acceso.hacerConsultaTablaCuenta(c);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            // TODO: handle exception
        } finally {
            acceso.cerrarConexion(c);
        }

        //Obtiene la tabla de la ventana de detalles de personajes
        JTable tabla = detallesPersonajesCuenta.getTablaDatos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        //Limpia los datos de la tabla
        model.setRowCount(0);

        // Agrega las filas con los datos de los personajes a la tabla
        for (String[] fila : datos) {
            //agrega una fila a la tabla
            model.addRow(fila);
            //Imprime la fila agregada
            System.out.println("Fila agregada: " + Arrays.toString(fila));
            for (String a : fila) {
                //Imprime cada elemento de la fila
                System.out.println(a);
            }
        }
        //Notifica a la tabla que los datos han cambiado
        model.fireTableDataChanged();
        //Actualiza el modelo de la tabla
        tabla.setModel(model);

        //Establece la tabla actualizada en la ventana de detalles de personajes
        detallesPersonajesCuenta.setTablaDatos(tabla);
        
        acceso.cerrarConexion(c);

        paginaPrincipal.dispose();

        detallesPersonajesCuenta.hacerVisible();

        

    }
}
