package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccesoBD;
import views.*;

import java.util.Arrays;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class PersonajeSeleccionadoListener implements ItemListener {

    private PaginaPrincipal paginaPrincipal;
    private DetallesPersonajesCuenta detallesPersonajesCuenta;

    public PersonajeSeleccionadoListener(PaginaPrincipal paginaPrincipal, DetallesPersonajesCuenta detallesPersonajesCuenta) {
            this.paginaPrincipal = paginaPrincipal;
            this.detallesPersonajesCuenta = detallesPersonajesCuenta;
        } 

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if (e.getStateChange() == ItemEvent.SELECTED) {
            System.out.println("button is selected");
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            System.out.println("button is not selected");
        }
        
    }   



    

}