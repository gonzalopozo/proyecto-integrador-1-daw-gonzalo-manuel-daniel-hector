package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import model.AccesoBD;
import views.*;
import main.*;

public class LoginListener implements ActionListener{
    
    private Login login;
    private SeleccionRol seleccionRol;
    private int cont = 3;

    public LoginListener(Login login, SeleccionRol seleccionRol) {
        this.login = login;
        this.seleccionRol = seleccionRol;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String password = login.getTxtPassword().getText();
        String usuario = login.getTxtUsuario().getText();

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
            login.getLblMensaje().setText("ERROR Introduza usuario y contraseña.");
        } else if (contraBD == "" && password == "") {
            login.getLblMensaje().setText("Este Usuario no existe");
        } else if (contraBD.equals(password)){
            App.setMiembroActual(usuario);
            login.dispose();

            seleccionRol.hacerVisible();
		
        } else {

            login.getLblMensaje().setText("Esta contraseña es incorrecta");
            cont--;
            if (cont == 0) {
                login.dispose();
            }

        }


    }
}
