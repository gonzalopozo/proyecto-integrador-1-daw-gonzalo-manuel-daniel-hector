package control;

import java.awt.event.*;
import java.sql.*;

import model.AccesoBD;
import views.*;
import main.*;

public class CrearPartidaListener implements ActionListener {

    private CrearPartida crearPartida;
    private PaginaPrincipalGM paginaPrincipalGM;
    
    public CrearPartidaListener(CrearPartida crearPartida, PaginaPrincipalGM paginaPrincipalGM) {
        this.crearPartida = crearPartida;
        this.paginaPrincipalGM = paginaPrincipalGM;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if ((crearPartida.getTxtNombrePartida().getText().length() > 0)) {
            System.out.println(App.getMiembroActualId());
            String nombrePartida = crearPartida.getTxtNombrePartida().getText();
            String ambientacionPartida = crearPartida.getCmbAmbientacion().getSelectedItem().toString();

            AccesoBD accesoBD = new AccesoBD();
            Connection c = accesoBD.getConexion();

            accesoBD.crearPartida(c, nombrePartida, App.getMiembroActualId(), ambientacionPartida);

            accesoBD.cerrarConexion(c);
            
            crearPartida.dispose();

            paginaPrincipalGM.hacerVisible();

        } 

        
    }

    

    // public void actionPerformed(ActionEvent e) {
    //     if (crearPartida.getSexo().isSelected() && crearPartida.getRaza().isSelected() && crearPartida.getClase().isSelected() && (crearPartida.getTxtNombrePersonaje().getText.length() > 0))
    // }
}
