package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import control.*;

/**
 * clase que va a extender de la de vista default
 */
public class Login extends VistaDefault {

    // se definen todas las variables que se van a utilizar en la vista.
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JLabel lblusuario;
    private JLabel lblcontraseña;
    private JLabel lblpregunta;
    private JLabel lblMensaje;
    private JButton btnCrearCuenta;

    /**
     * Constructor de la vista, asignando los métodos necesarios.
     */
    public Login() {
        super();
        setSize(600, 500);
        setLocationRelativeTo(null);
        inicializarComponentes();
        asignarLogo(IMAGEN_LOGO);
    }

    /**
     * Método el cual se va a encargar de inicializar todos los componentes que van
     * a aparecer en la vista.
     */
    private void inicializarComponentes() {
        getContentPane().setLayout(null);

        // Creación del textfield de usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(192, 247, 200, 20);
        getContentPane().add(txtUsuario);
        txtUsuario.setColumns(10);

        // Creación del passwordfield de contraseña
        txtPassword = new JPasswordField();
        txtPassword.setBounds(192, 296, 200, 20);
        getContentPane().add(txtPassword);
        txtPassword.setColumns(10);

        // Creación del botón de iniciar sesión, que hará las funciones de continuar
        continuar = new JButton("INICIAR SESIÓN");
        continuar.setFont(new Font("Arial", Font.BOLD, 14));
        continuar.setForeground(new Color(42, 42, 42));
        continuar.setBackground(new Color(247, 178, 44));
        continuar.setBounds(214, 329, 156, 31);

        getContentPane().add(continuar);

        // Creación de la etiqueta de usuario
        lblusuario = new JLabel("USUARIO");
        lblusuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblusuario.setForeground(new Color(247, 178, 44));
        lblusuario.setBounds(192, 226, 100, 14);
        getContentPane().add(lblusuario);

        // Creación de la etiqueta de contraseña
        lblcontraseña = new JLabel("CONTRASEÑA");
        lblcontraseña.setFont(new Font("Arial", Font.BOLD, 14));
        lblcontraseña.setForeground(new Color(247, 178, 44));
        lblcontraseña.setBounds(192, 278, 200, 14);
        getContentPane().add(lblcontraseña);

        // Creación de la etiqueta de pregunta
        lblpregunta = new JLabel("¿Todavía no tienes cuenta?");
        lblpregunta.setFont(new Font("Arial", Font.BOLD, 13));
        lblpregunta.setForeground(new Color(247, 178, 44));
        lblpregunta.setBounds(129, 389, 179, 19);
        getContentPane().add(lblpregunta);

        // Creación del botón de crear cuenta
        btnCrearCuenta = new JButton("CREAR CUENTA");
        btnCrearCuenta.setFont(new Font("Arial", Font.BOLD, 14));
        btnCrearCuenta.setForeground(new Color(42, 42, 42));
        btnCrearCuenta.setBackground(new Color(247, 178, 44));
        btnCrearCuenta.setBounds(318, 378, 158, 32);
        getContentPane().add(btnCrearCuenta);

        // Creación de la etiquta de el mensaje de error
        lblMensaje = new JLabel("");
        lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensaje.setForeground(new Color(247, 178, 44));
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 13));
        lblMensaje.setBounds(168, 339, 250, 19);
        getContentPane().add(lblMensaje);

        // Poder presionar le botón mediante la tecla enter
        txtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    continuar.doClick();
                }
            }
        });

    }

    // Se crean los getters y setters

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

    /**
     * @return the lblMensaje
     */
    public JLabel getLblMensaje() {
        return lblMensaje;
    }

    /**
     * @param lblMensaje the lblMensaje to set
     */
    public void setLblMensaje(JLabel lblMensaje) {
        this.lblMensaje = lblMensaje;
    }

    public void setBtnCrearCuenta(JButton btnCrearCuenta) {
        this.btnCrearCuenta = btnCrearCuenta;
    }

    public void setListenerBotonCrearCuenta(ActionListener listener) {
        btnCrearCuenta.addActionListener(listener);
    }
}
