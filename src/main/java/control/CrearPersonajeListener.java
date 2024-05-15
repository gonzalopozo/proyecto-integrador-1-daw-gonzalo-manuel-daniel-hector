package control;

import java.awt.event.*;
import java.sql.*;

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
        // TODO Auto-generated method stub
        if ((crearPersonaje.getSexo().getSelection() != null) && (crearPersonaje.getRaza().getSelection() != null) && (crearPersonaje.getClase().getSelection() != null) && (crearPersonaje.getTxtNombrePersonaje().getText().length() > 0)) {
            String nombrePersonaje = crearPersonaje.getTxtNombrePersonaje().getText();
            // CircularToggleButton razaSeleccionada = (CircularToggleButton) crearPersonaje.getRaza().getSelection();
            String razaPersonaje = "";
            // CircularToggleButton claseSeleccionada = (CircularToggleButton) crearPersonaje.getClase().getSelection();
            String clasePersonaje = "";
            // CircularToggleButton sexoSeleccionado = (CircularToggleButton) crearPersonaje.getSexo().getSelection();
            String sexoPersonaje = "";


            Object razaSeleccionadaObj = crearPersonaje.getRaza().getSelection().getSelectedObjects()[0];
            if (razaSeleccionadaObj instanceof CircularToggleButton) {
                CircularToggleButton razaSeleccionada = (CircularToggleButton) razaSeleccionadaObj;
                razaPersonaje = razaSeleccionada.getAtributo();
                // Resto del código...
            }
    
            Object claseSeleccionadaObj = crearPersonaje.getClase().getSelection().getSelectedObjects()[0];
            if (claseSeleccionadaObj instanceof CircularToggleButton) {
                CircularToggleButton claseSeleccionada = (CircularToggleButton) claseSeleccionadaObj;
                clasePersonaje = claseSeleccionada.getAtributo();
                // Resto del código...
            }

            Object sexoSeleccionadoObj = crearPersonaje.getSexo().getSelection().getSelectedObjects()[0];
            if (sexoSeleccionadoObj instanceof CircularToggleButton) {
                CircularToggleButton sexoSeleccionado = (CircularToggleButton) sexoSeleccionadoObj;
                sexoPersonaje = sexoSeleccionado.getAtributo();
                // Resto del código...
            }

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
