package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

public class CrearPersonajeListener implements ActionListener {

    private CrearPersonaje crearPersonaje;
    private PaginaPrincipal paginaPrincipal;
    
    public CrearPersonajeListener(CrearPersonaje crearPersonaje, PaginaPrincipal paginaPrincipal) {
        this.crearPersonaje = crearPersonaje;
        this.paginaPrincipal = paginaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonGroup razaGroup = crearPersonaje.getRaza();
        ButtonGroup claseGroup = crearPersonaje.getClase();
        ButtonGroup sexoGroup = crearPersonaje.getSexo();

        if ((crearPersonaje.getSexo().getSelection() != null) && (crearPersonaje.getRaza().getSelection() != null) && (crearPersonaje.getClase().getSelection() != null) && (crearPersonaje.getTxtNombrePersonaje().getText().length() > 0)) {
            String nombrePersonaje = crearPersonaje.getTxtNombrePersonaje().getText();
            String razaPersonaje = crearPersonaje.getSelectedButtonText(razaGroup);
            String clasePersonaje = crearPersonaje.getSelectedButtonText(claseGroup);
            String sexoPersonaje = crearPersonaje.getSelectedButtonText(sexoGroup);



            // String nombrePersonaje = crearPersonaje.getTxtNombrePersonaje().getText();
            // AbstractButton razaSeleccionada = (AbstractButton) crearPersonaje.getRaza().getSelection();
            // String razaPersonaje = razaSeleccionada.getText();
            // AbstractButton claseSeleccionada = (AbstractButton) crearPersonaje.getClase().getSelection();
            // String clasePersonaje = claseSeleccionada.getText();
            // AbstractButton sexoSeleccionado = (AbstractButton) crearPersonaje.getSexo().getSelection();
            // String sexoPersonaje = sexoSeleccionado.getText();


            // Object razaSeleccionadaObj = crearPersonaje.getRaza().getSelection();
            // if (razaSeleccionadaObj instanceof CircularToggleButton) {
            //     CircularToggleButton razaSeleccionada = (CircularToggleButton) razaSeleccionadaObj;
            //     razaPersonaje = razaSeleccionada.atributo;
            //     // Resto del código...
            // }
    
            // Object claseSeleccionadaObj = crearPersonaje.getClase().getSelection();
            // if (claseSeleccionadaObj instanceof CircularToggleButton) {
            //     CircularToggleButton claseSeleccionada = (CircularToggleButton) claseSeleccionadaObj;
            //     clasePersonaje = claseSeleccionada.atributo;
            //     // Resto del código...
            // }

            // Object sexoSeleccionadoObj = crearPersonaje.getSexo().getSelection();
            // if (sexoSeleccionadoObj instanceof CircularToggleButton) {
            //     CircularToggleButton sexoSeleccionado = (CircularToggleButton) sexoSeleccionadoObj;
            //     sexoPersonaje = sexoSeleccionado.atributo;
            //     // Resto del código...
            // }


            // // String nombrePersonaje = crearPersonaje.getTxtNombrePersonaje().getText();
            // // CircularToggleButton razaSeleccionada = null;
            // // CircularToggleButton claseSeleccionada = null;
            // // CircularToggleButton sexoSeleccionado = null;
            // // try {
            // //     razaSeleccionada = (CircularToggleButton) crearPersonaje.getRaza().getSelection();
            // // } catch (Exception ee) {
            // //     // TODO: handle exception
            // // }
            // // String razaPersonaje = razaSeleccionada.getAtributo();
            // // try {
            // //     claseSeleccionada = (CircularToggleButton) crearPersonaje.getClase().getSelection();
            // // } catch (Exception eee) {
            // //     // TODO: handle exception
            // // }
            // // String clasePersonaje = claseSeleccionada.getAtributo();
            // // try {
            // //     sexoSeleccionado = (CircularToggleButton) crearPersonaje.getSexo().getSelection();
            // // } catch (Exception eeee) {
            // //     // TODO: handle exception
            // // }
            // // String sexoPersonaje = sexoSeleccionado.getAtributo();

            AccesoBD accesoBD = new AccesoBD();
            Connection c = accesoBD.getConexion();

            accesoBD.crearPersonaje(c, sexoPersonaje, nombrePersonaje, razaPersonaje, clasePersonaje, App.getMiembroActualId());

            crearPersonaje.dispose();

            paginaPrincipal.hacerVisible();

        } 

        
    }


    

    // public void actionPerformed(ActionEvent e) {
    //     if (crearPersonaje.getSexo().isSelected() && crearPersonaje.getRaza().isSelected() && crearPersonaje.getClase().isSelected() && (crearPersonaje.getTxtNombrePersonaje().getText.length() > 0))
    // }
}
