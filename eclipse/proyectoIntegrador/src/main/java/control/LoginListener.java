package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import model.AccesoBD;
import views.*;

public class LoginListener implements ActionListener{
    
    private Login v1;
    private int cont = 3;

    public LoginListener(Login v1) {
        this.v1 = v1;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String password = v1.getTxtPassword().getText();
        String usuario = v1.getTxtUsuario().getText();

        String contraBD = "";


        AccesoBD acceso = new AccesoBD();
        Connection c = acceso.getConexion();

        try{
            contraBD = acceso.comprobarLogin(c, usuario);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        acceso.cerrarConexion(c);


        if (contraBD == "") {
            v1.getLblMensaje().setText("ERROR Introduza usuario y contraseña.");
        } else if (contraBD == "" && password == "") {
            v1.getLblMensaje().setText("Este Usuario no existe");
        } else if (contraBD.equals(password)){
            SeleccionRol vRol = new SeleccionRol();

            v1.dispose();
            vRol.setVisible(true);

        } else {

            v1.getLblMensaje().setText("Esta contraseña es incorrecta");
            cont--;
            if (cont == 0) {
                v1.dispose();
            }

        }


    }
}
