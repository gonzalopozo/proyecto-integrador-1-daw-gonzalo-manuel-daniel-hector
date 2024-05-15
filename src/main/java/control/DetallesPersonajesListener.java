package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccesoBD;
import views.*;

public class DetallesPersonajesListener implements ActionListener{
    
    private DetallesPersonajesCuenta vDetalles;
    private int cont = 3;

    public DetallesPersonajesListener(DetallesPersonajesCuenta vDetalles) {
        this.vDetalles = vDetalles;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        ArrayList<String> datos = new ArrayList<String>();


        AccesoBD acceso = new AccesoBD();
        Connection c = acceso.getConexion();

        try{
            datos = acceso.obtenerDatos(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        acceso.cerrarConexion();


        

    }
}
