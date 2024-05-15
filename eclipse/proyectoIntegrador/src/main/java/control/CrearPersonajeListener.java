package control;

import java.awt.event.*;
import java.sql.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.CrearPersonaje;

public class CrearPersonajeListener implements ActionListener {

    private CrearPersonaje vista;
    
    public CrearPersonajeListener(CrearPersonaje vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if ((vista.getSexo().getSelection() != null) && (vista.getRaza().getSelection() != null) && (vista.getClase().getSelection() != null) && (vista.getTxtNombrePersonaje().getText().length() > 0)) {
            String nombrePersonaje = vista.getTxtNombrePersonaje().getText();
            CircularToggleButton razaSeleccionada = (CircularToggleButton) vista.getRaza().getSelection();
            String razaPersonaje = razaSeleccionada.getAtributo();
            CircularToggleButton claseSeleccionada = (CircularToggleButton) vista.getClase().getSelection();
            String clasePersonaje = claseSeleccionada.getAtributo();
            CircularToggleButton sexoSeleccionado = (CircularToggleButton) vista.getSexo().getSelection();
            String sexoPersonaje = sexoSeleccionado.getAtributo();
		// String query = "INSERT INTO personajes (nombre, raza, clase, miembro_id) VALUES (?, ?, ?, ?)";


        }

        
    }

    

    // public void actionPerformed(ActionEvent e) {
    //     if (vista.getSexo().isSelected() && vista.getRaza().isSelected() && vista.getClase().isSelected() && (vista.getTxtNombrePersonaje().getText.length() > 0))
    // }
}
