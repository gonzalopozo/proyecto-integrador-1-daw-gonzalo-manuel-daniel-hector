package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

public class CrearCuentaDosListener implements ActionListener {

    private CrearCuentaDos crearCuentaDos;
    private CuentaCreada cuentaCreada;
    
    public CrearCuentaDosListener(CrearCuentaDos crearCuentaDos, CuentaCreada cuentaCreada) {
        this.crearCuentaDos = crearCuentaDos;
        this.cuentaCreada = cuentaCreada;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if ((crearCuentaDos.getTextField().getText().length() > 0) && (crearCuentaDos.getTxtContrasena().getText().length() > 0) && (crearCuentaDos.getTxtRepetirContrasena().getText().length() > 0) && (crearCuentaDos.getTxtContrasena().getText().equals(crearCuentaDos.getTxtRepetirContrasena().getText()))) {

            String nombreUsuario = crearCuentaDos.getTextField().getText();
            String contrasenaUsuario = crearCuentaDos.getTxtContrasena().getText();

            AccesoBD accesoBD = new AccesoBD();
            Connection c = accesoBD.getConexion();

            accesoBD.crearMiembro(c, nombreUsuario, CrearCuentaDos.getApellido(), contrasenaUsuario, CrearCuentaDos.getNumExpediente(), CrearCuentaDos.getEstudios());

            Object[] usuarioDatos = null;
            int usuarioId = 0;
    
            try{
                usuarioDatos = accesoBD.comprobarLogin(c, nombreUsuario);

                usuarioId = (Integer) usuarioDatos[0];
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println(usuarioId);

            accesoBD.cerrarConexion(c);

            App.setMiembroActualId(usuarioId);
            
            crearCuentaDos.dispose();
            cuentaCreada.hacerVisible();
            // accesoBD.crearCuenta(c, nombrePersonaje, sexoPersonaje, razaPersonaje, clasePersonaje, App.getMiembroActualId());}
            
            // crearCuenta.dispose();
            // crearCuentaDos.hacerVisible();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }
        }
        



        

            


        } 

        



    

