package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

public class UnirsePartidaListener implements ActionListener {

    private UnirsePartida unirsePartida;
    // private PaginaPrincipal paginaPrincipal;
    
    public UnirsePartidaListener(UnirsePartida unirsePartida) {
        this.unirsePartida = unirsePartida;
        // this.paginaPrincipal = paginaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        AccesoBD accesoBD = new AccesoBD();
        Connection c = accesoBD.getConexion();

        int selectedRow = unirsePartida.getTable().getSelectedRow();

        
            
        if (selectedRow != 1) {
            String nombrePartida = unirsePartida.getTable().getValueAt(selectedRow, 1).toString();
            String ambientacionPartida = unirsePartida.getTable().getValueAt(selectedRow, 2).toString();

            System.out.println(nombrePartida + " - " + ambientacionPartida);

            try {
                accesoBD.unirsePartida(c, PaginaPrincipal.getPersonajeSeleccionadoId(), accesoBD.devolverIdPartida(c, nombrePartida, ambientacionPartida));
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        



        accesoBD.cerrarConexion(c);

        

        
    }
}
