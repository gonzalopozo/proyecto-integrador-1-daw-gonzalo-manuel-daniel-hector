package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import control.*;

//clase que va a extender de la de vista default
public class EditarPartida extends VistaDefault {

    // se definen todas las variables que se van a utilizar en la vista.
    private JTextField txtNombrePartida;
    private JLabel lblNombrePartida;
    private JLabel lblAmbientacion;
    private JComboBox<String> cmbAmbientacion;

    /**
     * Constructor de la vista, asignando los métodos necesarios.
     */
    public EditarPartida() {
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

        txtNombrePartida = new JTextField();
        txtNombrePartida.setBounds(192, 247, 200, 20);
        getContentPane().add(txtNombrePartida);
        txtNombrePartida.setColumns(10);

        continuar = new JButton("CONFIRMAR CAMBIOS");
        continuar.setFont(new Font("Arial", Font.BOLD, 14));
        continuar.setForeground(new Color(42, 42, 42));
        continuar.setBackground(new Color(247, 178, 44));
        continuar.setBounds(198, 329, 188, 31);
        getContentPane().add(continuar);

        lblNombrePartida = new JLabel("NUEVO NOMBRE");
        lblNombrePartida.setFont(new Font("Arial", Font.BOLD, 14));
        lblNombrePartida.setForeground(new Color(247, 178, 44));
        lblNombrePartida.setBounds(192, 226, 150, 14);
        getContentPane().add(lblNombrePartida);

        lblAmbientacion = new JLabel("NUEVA AMBIENTACIÓN");
        lblAmbientacion.setFont(new Font("Arial", Font.BOLD, 14));
        lblAmbientacion.setForeground(new Color(247, 178, 44));
        lblAmbientacion.setBounds(192, 278, 200, 14);
        getContentPane().add(lblAmbientacion);

        String[] nombres = { "Estepas de Tong Long", "Suramar", "Cementerio de Dragones", "Zul`Drak", "Sueño Esmeralda",
                "Argus" };
        cmbAmbientacion = new JComboBox<>(nombres);
        cmbAmbientacion.setBounds(192, 296, 200, 20);
        getContentPane().add(cmbAmbientacion);

        volver = new JButton("VOLVER");
        volver.setFont(new Font("Arial", Font.BOLD, 14));
        volver.setForeground(new Color(42, 42, 42));
        volver.setBackground(new Color(247, 178, 44));
        volver.setBounds(30, 400, 158, 32);
        getContentPane().add(volver);

    }

    /**
     * @return the txtNombrePartida
     */
    public JTextField getTxtNombrePartida() {
        return txtNombrePartida;
    }

    /**
     * @param txtNombrePartida the txtNombrePartida to set
     */
    public void setTxtNombrePartida(JTextField txtNombrePartida) {
        this.txtNombrePartida = txtNombrePartida;
    }

    /**
     * @return the cmbAmbientacion
     */
    public JComboBox<String> getCmbAmbientacion() {
        return cmbAmbientacion;
    }

    /**
     * @param cmbAmbientacion the cmbAmbientacion to set
     */
    public void setCmbAmbientacion(JComboBox<String> cmbAmbientacion) {
        this.cmbAmbientacion = cmbAmbientacion;
    }

}
