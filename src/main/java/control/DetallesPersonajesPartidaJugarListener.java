package control;

import views.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

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
