package views;

import javax.swing.*;
import java.awt.Font;

/**
 * clase que va a extender de la de vista default
 */
public class CrearPartida extends VistaDefault {

    // se definen todas las variables que se van a utilizar en la vista.
    private JTextField txtNombrePartida;
    private JLabel lblNombrePartida;
    private JLabel lblAmbientacion;
    private JLabel lblCrearPartida;
    private JComboBox<String> cmbAmbientacion;

    /**
     * Constructor de la vista, asignando los métodos necesarios.
     */
    public CrearPartida() {
        super();
        setSize(700, 600);
        inicializarComponentes();
        asignarLogo(IMAGEN_LOGO);
        setLocationRelativeTo(null);
    }

    /**
     * Método el cual se va a encargar de inicializar todos los componentes que van
     * a aparecer en la vista.
     */
    private void inicializarComponentes() {
        getContentPane().setLayout(null);
        txtNombrePartida = new JTextField();
        txtNombrePartida.setBounds(242, 310, 200, 20);
        getContentPane().add(txtNombrePartida);
        txtNombrePartida.setColumns(10);

        // Creación de botón crear partida
        continuar = new JButton("CREAR PARTIDA");
        continuar.setBounds(259, 400, 162, 31);
        getContentPane().add(continuar);

        // Creación de etiqueta nombre partida
        lblNombrePartida = new JLabel("NOMBRE PARTIDA");
        lblNombrePartida.setBounds(242, 288, 186, 14);
        getContentPane().add(lblNombrePartida);

        // Creación de etiqueta ambientación
        lblAmbientacion = new JLabel("AMBIENTACIÓN");
        lblAmbientacion.setBounds(242, 341, 186, 14);
        getContentPane().add(lblAmbientacion);

        // Creación de etiqueta crear partida
        lblCrearPartida = new JLabel("CREAR PARTIDA");
        lblCrearPartida.setFont(new Font("Arial", Font.BOLD, 18));
        lblCrearPartida.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrearPartida.setBounds(242, 242, 200, 14);
        getContentPane().add(lblCrearPartida);

        // Se crea un array que va a almacenar los nombres de las distintas opciones de
        // ambientación.
        String[] nombres = { "Estepas de Tong Long", "Suramar", "Cementerio de Dragones", "Zul`Drak", "Sueño Esmeralda",
                "Argus" };
        cmbAmbientacion = new JComboBox<>(nombres);
        cmbAmbientacion.setBounds(242, 360, 200, 20);
        getContentPane().add(cmbAmbientacion);

        // Creación botón de volver
        volver = new JButton("VOLVER");
        volver.setBounds(10, 527, 180, 23);
        getContentPane().add(volver);
    }

    // Se crean los getters y setters
    public JTextField getTxtNombrePartida() {
        return txtNombrePartida;
    }

    public void setTxtNombrePartida(JTextField txtNombrePartida) {
        this.txtNombrePartida = txtNombrePartida;
    }

    public JLabel getLblNombrePartida() {
        return lblNombrePartida;
    }

    public void setLblNombrePartida(JLabel lblNombrePartida) {
        this.lblNombrePartida = lblNombrePartida;
    }

    public JLabel getLblAmbientacion() {
        return lblAmbientacion;
    }

    public void setLblAmbientacion(JLabel lblAmbientacion) {
        this.lblAmbientacion = lblAmbientacion;
    }

    public JLabel getLblCrearPartida() {
        return lblCrearPartida;
    }

    public void setLblCrearPartida(JLabel lblCrearPartida) {
        this.lblCrearPartida = lblCrearPartida;
    }

    public JComboBox<String> getCmbAmbientacion() {
        return cmbAmbientacion;
    }

    public void setCmbAmbientacion(JComboBox<String> cmbAmbientacion) {
        this.cmbAmbientacion = cmbAmbientacion;
    }
}
