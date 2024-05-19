package control;

import views.*;
import java.awt.event.*;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.*;
import javax.swing.table.*;

public class DetallesPersonajesPartidaJugarListener implements ActionListener {

    private UnirsePartida unirsePartida;
    private DetallesPersonajesPartida detallesPersonajesPartida;

    public DetallesPersonajesPartidaJugarListener(UnirsePartida unirsePartida, DetallesPersonajesPartida detallesPersonajesPartida) {
        this.unirsePartida = unirsePartida;
        this.detallesPersonajesPartida = detallesPersonajesPartida;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int selectedRow = unirsePartida.getTable().getSelectedRow();

        if (selectedRow != -1) { // Verificar que una fila esté seleccionada
                // Obtener los datos de cada columna de la fila seleccionada
                String nombrePartida = unirsePartida.getTable().getValueAt(selectedRow, 1).toString();
                String ambientacionPartida = unirsePartida.getTable().getValueAt(selectedRow, 2).toString();

                System.out.println(nombrePartida + " - " + ambientacionPartida);
                
                AccesoBD acceso = new AccesoBD();
                Connection c = acceso.getConexion();
                ArrayList<String[]> datos = null;
                try {
                    datos = acceso.hacerConsultaTablaDetallesPartida(c, nombrePartida, ambientacionPartida);
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                    // TODO: handle exception
                } finally {
                    acceso.cerrarConexion(c);
                }

                JTable tabla = detallesPersonajesPartida.getTablaDatos();
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();

                model.setRowCount(0);

                for (String[] fila : datos) {
                    model.addRow(fila);
                    System.out.println("Fila agregada: " + Arrays.toString(fila));
                    for (String a : fila) {
                        System.out.println(a);
                    }
                }
                model.fireTableDataChanged();
                tabla.setModel(model);


                detallesPersonajesPartida.setTablaDatos(tabla);

                unirsePartida.dispose();
                detallesPersonajesPartida.hacerVisible();



                // Mostrar los datos en un mensaje
            } else {
                // JOptionPane.showMessageDialog(frame, "No hay ninguna fila seleccionada");
            }

        // if (selectedRow != -1) { // Verificar que una fila esté seleccionada
        //         // Obtener los datos de cada columna de la fila seleccionada
        //         String nombre = table.getValueAt(selectedRow, 0).toString();
        //         String edad = table.getValueAt(selectedRow, 1).toString();
        //         String ciudad = table.getValueAt(selectedRow, 2).toString();
                
        //         // Mostrar los datos en un mensaje
        //         JOptionPane.showMessageDialog(frame, 
        //             "Nombre: " + nombre + "\nEdad: " + edad + "\nCiudad: " + ciudad);
        // } else {
        //         JOptionPane.showMessageDialog(frame, "No hay ninguna fila seleccionada");
        //     }
    }

    
}
