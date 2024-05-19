package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import main.App;
import model.AccesoBD;
import views.*;


import java.awt.event.*;

public class CrearPersonajeSeleccionadoListener implements ItemListener {
    private CrearPersonaje crearPersonaje;

    public CrearPersonajeSeleccionadoListener(CrearPersonaje crearPersonaje) {
        this.crearPersonaje = crearPersonaje;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        // AccesoBD accesoBD = new AccesoBD();
        // Connection c = accesoBD.getConexion();

        String [][] imagenesPersonajes = {
            {"Humano", "Hombre", "src/main/resources/humanoGrande.png"},
            {"Humano", "Mujer", "src/main/resources/humanaGrande.png"},
            {"Enano", "Hombre", "src/main/resources/enanoGrande.png"},
            {"Enano", "Mujer", "src/main/resources/enanaGrande.png"},
            {"Elfo de la noche", "Hombre", "src/main/resources/elfo.png"},
            {"Elfo de la noche", "Mujer", "src/main/resources/elfa.png"},
            {"Huargen", "Hombre", "src/main/resources/huargenHombre.png"},
            {"Huargen", "Mujer", "src/main/resources/huargenMujer.png"},
            {"Dracthyr", "Hombre", "src/main/resources/dracthyrHombre.png"},
            {"Dracthyr", "Mujer", "src/main/resources/dracthyrMujer.png"},
            {"No muerto", "Hombre", "src/main/resources/nomuerto.png"},
            {"No muerto", "Mujer", "src/main/resources/nomuerta.png"},
            {"Orco", "Hombre", "src/main/resources/orcoHombre.png"},
            {"Orco", "Mujer", "src/main/resources/orcoMujer.png"},
            {"Pandaren", "Hombre", "src/main/resources/pandaHombre.png"},
            {"Pandaren", "Mujer", "src/main/resources/pandaMujer.png"},
            {"Tauren", "Hombre", "src/main/resources/taurenHombre.png"},
            {"Tauren", "Mujer", "src/main/resources/taurenMujer.png"},
            {"Troll", "Hombre", "src/main/resources/troll.png"},
            {"Troll", "Mujer", "src/main/resources/trollMujer.png"}
        };

        if (e.getStateChange() == ItemEvent.SELECTED) {

            String raza = crearPersonaje.getSelectedButtonText(crearPersonaje.getRaza());
            String sexo = crearPersonaje.getSelectedButtonText(crearPersonaje.getSexo());



            for (String[] datosFotos : imagenesPersonajes) {
                if (datosFotos[0].equals(raza) && datosFotos[1].equals(sexo)) {
                    crearPersonaje.cambiarImagenPersonaje(datosFotos[2]);
                }
            }

            

            

            

        }
        
    }   



    

}