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

public class DetallesPersonajesListener implements ActionListener{
    
    private PaginaPrincipal paginaPrincipal;
    private DetallesPersonajesCuenta detallesPersonajesCuenta;

    public DetallesPersonajesListener(PaginaPrincipal paginaPrincipal, DetallesPersonajesCuenta detallesPersonajesCuenta) {
        this.paginaPrincipal = paginaPrincipal;
        this.detallesPersonajesCuenta = detallesPersonajesCuenta;
    }

    @Override
    public void actionPerformed(ActionEvent e){


        AccesoBD acceso = new AccesoBD();
        
        Connection c = acceso.getConexion();
        ArrayList<String[]> datos = null;
        try {
            acceso.obtenerDatos(c);
            datos = acceso.hacerConsultaTablaCuenta(c);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            // TODO: handle exception
        }

        JTable tabla = detallesPersonajesCuenta.getTablaDatos();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        System.out.println(Arrays.toString(datos.get(0)));

        for (String[] fila : datos) {
            model.addRow(fila);
            System.out.println("Fila agregada: " + Arrays.toString(fila));
            for (String a : fila) {
                System.out.println(a);
            }
        }
        model.fireTableDataChanged();
        tabla.setModel(model);


        detallesPersonajesCuenta.setTablaDatos(tabla);


        //String[][] datos = {
        //     {"Pepe el del Madrid", "Troll", "Druida", "La batalla por el templo del Tigre Blanco", "70", "50000", "10000", "1000", "1000", "3000", "1000", "450"},
        //     {"LeBron James", "Tauren", "Caballero de la muerte", "Liberación de los elfos", "50", "15000", "300", "10000", "1800", "800", "1750", "100"},
        //     {"D'Angelo Russell", "Dracthyr", "Evocador", "Lucha contra el Rey Exánime", "40", "20000", "7000", "5000", "10000", "5000", "3000", "500"}
        // };


        // for (String[] fila : datos) {
        //     model.addRow(fila);
        // }


        
        acceso.cerrarConexion(c);

        paginaPrincipal.dispose();

        detallesPersonajesCuenta.hacerVisible();

        

    }
}
