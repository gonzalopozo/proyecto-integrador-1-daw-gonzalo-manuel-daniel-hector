package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import main.App;
import model.AccesoBD;
import views.*;


import java.awt.event.*;

public class PersonajeSeleccionadoListener implements ItemListener {
    private PaginaPrincipal paginaPrincipal;

    public PersonajeSeleccionadoListener(PaginaPrincipal paginaPrincipal) {
        this.paginaPrincipal = paginaPrincipal;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        AccesoBD accesoBD = new AccesoBD();
        Connection c = accesoBD.getConexion();


        if (e.getStateChange() == ItemEvent.SELECTED) {
            try {
                int prueba = accesoBD.devolverPersonajesMiembro(c, paginaPrincipal.getSelectedButtonText(paginaPrincipal.getBotonesPersonajes()));
                System.out.println(prueba);
                PaginaPrincipal.setPersonajeSeleccionadoId(prueba);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            paginaPrincipal.getLblNombrePersonaje().setText(paginaPrincipal.getSelectedButtonText(paginaPrincipal.getBotonesPersonajes()));
        }
        
    }   



    

}