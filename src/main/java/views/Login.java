package views;

import javax.swing.*;
import java.awt.*;
import control.*;

public class Login extends VistaDefault {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JLabel lblusuario;
    private JLabel lblcontraseña;
    private JLabel lblpregunta;
    private JButton btnCrearCuenta;

    public Login() {
        super();
        setSize(600, 500);
        setLocationRelativeTo(null);
        inicializarComponentes();
        asignarLogo(imagenLogo);
    }

    private void inicializarComponentes() {
        getContentPane().setLayout(null);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(192, 247, 200, 20);
        getContentPane().add(txtUsuario);
        txtUsuario.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(192, 296, 200, 20);
        getContentPane().add(txtPassword);
        txtPassword.setColumns(10);

        continuar = new JButton("INICIAR SESIÓN");
        continuar.setFont(new Font("Arial", Font.BOLD, 14));
        continuar.setForeground(new Color(42, 42, 42));
        continuar.setBackground(new Color(247, 178, 44));
        continuar.setBounds(214, 329, 156, 31);
        
        getContentPane().add(continuar);

        lblusuario = new JLabel("USUARIO");
        lblusuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblusuario.setForeground(new Color(247, 178, 44));
        lblusuario.setBounds(192, 226, 100, 14);
        getContentPane().add(lblusuario);

        lblcontraseña = new JLabel("CONTRASEÑA");
        lblcontraseña.setFont(new Font("Arial", Font.BOLD, 14));
        lblcontraseña.setForeground(new Color(247, 178, 44));
        lblcontraseña.setBounds(192, 278, 200, 14);
        getContentPane().add(lblcontraseña);

        lblpregunta = new JLabel("¿Todavía no tienes cuenta?");
        lblpregunta.setFont(new Font("Arial", Font.BOLD, 13));
        lblpregunta.setForeground(new Color(247, 178, 44));
        lblpregunta.setBounds(129, 389, 179, 19);
        getContentPane().add(lblpregunta);

        btnCrearCuenta = new JButton("CREAR CUENTA");
        btnCrearCuenta.setFont(new Font("Arial", Font.BOLD, 14));
        btnCrearCuenta.setForeground(new Color(42, 42, 42));
        btnCrearCuenta.setBackground(new Color(247, 178, 44));
        btnCrearCuenta.setBounds(318, 378, 158, 32);
        getContentPane().add(btnCrearCuenta);
        
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }



    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }



    public JPasswordField getTxtPassword() {
        return txtPassword;
    }



    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }



    public JLabel getLblusuario() {
        return lblusuario;
    }



    public void setLblusuario(JLabel lblusuario) {
        this.lblusuario = lblusuario;
    }



    public JLabel getLblcontraseña() {
        return lblcontraseña;
    }



    public void setLblcontraseña(JLabel lblcontraseña) {
        this.lblcontraseña = lblcontraseña;
    }



    public JLabel getLblpregunta() {
        return lblpregunta;
    }



    public void setLblpregunta(JLabel lblpregunta) {
        this.lblpregunta = lblpregunta;
    }



    public JButton getBtnCrearCuenta() {
        return btnCrearCuenta;
    }



    public void setBtnCrearCuenta(JButton btnCrearCuenta) {
        this.btnCrearCuenta = btnCrearCuenta;
    }



    public void setListenerBotonCrearCuenta(MoverseListener listener) {
        btnCrearCuenta.addActionListener(listener);
    }
}
