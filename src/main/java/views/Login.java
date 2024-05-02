package views;

import javax.swing.*;
import java.awt.*;

public class Login extends VistaDefault {
    private JTextField txtUsuario;
    private JTextField txtNombre;
    private JLabel lblusuario;
    private JLabel lblcontraseña;
    private JLabel lblpregunta;
    private JButton btnIniciarSesion;

    public Login() {
        super();
        setSize(600, 500);
        setLocationRelativeTo(null);
        inicializarComponentes();
        asignarLogo(imagenLogo);
    }

    private void inicializarComponentes() {
        txtUsuario = new JTextField();
        txtUsuario.setBounds(192, 247, 200, 20);
        getContentPane().add(txtUsuario);
        txtUsuario.setColumns(10);

        txtNombre = new JTextField();
        txtNombre.setBounds(192, 296, 200, 20);
        getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        btnIniciarSesion = new JButton("INICIAR SESIÓN");
        btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciarSesion.setForeground(new Color(42, 42, 42));
        btnIniciarSesion.setBackground(new Color(247, 178, 44));
        btnIniciarSesion.setBounds(214, 329, 156, 31);
        getContentPane().add(btnIniciarSesion);

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

        continuar = new JButton("CREAR CUENTA");
        continuar.setFont(new Font("Arial", Font.BOLD, 14));
        continuar.setForeground(new Color(42, 42, 42));
        continuar.setBackground(new Color(247, 178, 44));
        continuar.setBounds(318, 382, 164, 31);
        getContentPane().add(continuar);

    }
}
