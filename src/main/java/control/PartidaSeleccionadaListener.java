package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccesoBD;
import views.*;


import java.awt.event.*;

public class PartidaSeleccionadaListener implements ItemListener {
    private SeleccionarPartidaGM seleccionarPartidaGM;

    public PartidaSeleccionadaListener(SeleccionarPartidaGM seleccionarPartidaGM) {
        this.seleccionarPartidaGM = seleccionarPartidaGM;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // seleccionarPartidaGM.setPersonajeSeleccionadoId();
            seleccionarPartidaGM.setTitle(seleccionarPartidaGM.getSelectedButtonText(seleccionarPartidaGM.getBotonesPartidas()));
        }
        
    }   



    

}