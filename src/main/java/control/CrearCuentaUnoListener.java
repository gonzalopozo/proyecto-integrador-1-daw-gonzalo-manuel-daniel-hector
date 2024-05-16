package control;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import components.CircularToggleButton;
import model.AccesoBD;
import views.*;
import main.*;

public class CrearCuentaUnoListener implements ActionListener {

    private CrearCuenta crearCuenta;
    private CrearCuentaDos crearCuentaDos;
    
    public CrearCuentaUnoListener(CrearCuenta crearCuenta, CrearCuentaDos crearCuentaDos) {
        this.crearCuenta = crearCuenta;
        this.crearCuentaDos = crearCuentaDos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((crearCuenta.getTxtNombre().getText().length() > 0) && (crearCuenta.getTxtApellido().getText().length() > 0) && (crearCuenta.getTxtNumExpediente().getText().length() > 0) && (crearCuenta.getTxtEstudios().getText().length() > 0) && (crearCuenta.getCheckBoxTerminos().isSelected())) {
            CrearCuentaDos.setNombre(crearCuenta.getTxtNombre().getText());
            CrearCuentaDos.setApellido(crearCuenta.getTxtApellido().getText());
            CrearCuentaDos.setNumExpediente(Integer.parseInt(crearCuenta.getTxtNumExpediente().getText()));
            CrearCuentaDos.setEstudios(crearCuenta.getTxtEstudios().getText());
            
            crearCuenta.dispose();
            crearCuentaDos.hacerVisible();
        }

    }
    
}
