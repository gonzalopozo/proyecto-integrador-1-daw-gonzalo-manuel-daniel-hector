package control;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import model.AccesoBD;
import views.PaginaPrincipal;

public class BorrarPersonajeListener implements ActionListener {
    private PaginaPrincipal paginaPrincipal;

    public BorrarPersonajeListener(PaginaPrincipal paginaPrincipal) {
        this.paginaPrincipal = paginaPrincipal;
    }


@Override
public void actionPerformed(ActionEvent e){

    String nombrePersonaje = paginaPrincipal.getSelectedButtonText(paginaPrincipal.getBotonesPersonajes());

    if (nombrePersonaje != null) {
        AccesoBD accesoBD = new AccesoBD();
        Connection c = accesoBD.getConexion();

        Object [] prueba;

        try {
            prueba = accesoBD.devolverPersonajeSeleccionadoMiembro(c, nombrePersonaje);

            accesoBD.borrarPersonaje(c, nombrePersonaje, (Integer) prueba[0]);
            paginaPrincipal.removeBotonPersonaje(nombrePersonaje);
            paginaPrincipal.limpiarTextoImagen();

        } catch (Exception eX) {
        
        } finally {
            accesoBD.cerrarConexion(c);
        }
    } else {
        JOptionPane.showMessageDialog(paginaPrincipal, "No se ha seleccionado ningún personaje", "Error", JOptionPane.ERROR_MESSAGE);

    }
    
}


}
