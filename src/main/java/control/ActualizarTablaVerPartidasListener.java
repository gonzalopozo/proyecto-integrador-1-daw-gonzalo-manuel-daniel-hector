package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

import model.AccesoBD;
import views.*;

public class ActualizarTablaVerPartidasListener implements ActionListener{

    private UnirsePartida vista;
    
    private AccesoBD bbdd;


    public ActualizarTablaVerPartidasListener (UnirsePartida vista, AccesoBD bbdd){
        this.vista = vista;
        this.bbdd = bbdd;
    }

    @Override
    public void actionPerformed (ActionEvent e){
        
        // Estructura para actualizar la tabla cuando se presiona el botón Unirse
        int filaSeleccionada = vista.getTable().getSelectedRow();
        //Se verifica si se ha seleccionado alguna fila
        if (filaSeleccionada != 1){
            // Se obtiene el id de la partida que ha seleccionado el usuario, siendo 0 el índice de la primera columna
            String nombrePartida = (String) vista.getTable().getValueAt(filaSeleccionada, 0);
            
            //Se obtiene el nombre del personaje que se inserta en la partida
            String nombrePersonaje = vista.getName();

            boolean ingresoPersonajeAPartida = bbdd.agregarPersonajeAPartida(nombrePersonaje, nombrePartida);

            if (ingresoPersonajeAPartida){
                JOptionPane.showMessageDialog(null, "Te has unido a la partida " + nombrePartida);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al unirse a la partida");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una partida");
        }
    }

    private String obtenerNombrePersonaje(){
        return "Nombre personaje";
    }
}