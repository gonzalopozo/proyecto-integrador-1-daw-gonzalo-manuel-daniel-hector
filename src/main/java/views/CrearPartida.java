package views;

import javax.swing.*;

public class CrearPartida extends VistaDefault {
    private JTextField txtNombrePartida;
    private JLabel lblNombrePartida; 
    private JLabel lblAmbientacion; 
    private JLabel lblCrearPartida; 
    private JComboBox<String> cmbAmbientacion; 

    public CrearPartida() {
        super();
        setSize(700,600);
        inicializarComponentes();
        asignarLogo(imagenLogo);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        txtNombrePartida = new JTextField();
        txtNombrePartida.setBounds(400, 310, 200, 20);
        getContentPane().add(txtNombrePartida);
        txtNombrePartida.setColumns(10);

        continuar = new JButton("CREAR PARTIDA");
        continuar.setBounds(419, 390, 162, 31);
        getContentPane().add(continuar);

        lblNombrePartida = new JLabel("NOMBRE PARTIDA");
        lblNombrePartida.setBounds(400, 292, 186, 14);
        getContentPane().add(lblNombrePartida);

        lblAmbientacion = new JLabel("AMBIENTACIÓN");
        lblAmbientacion.setBounds(440, 341, 186, 14);
        getContentPane().add(lblAmbientacion);

        lblCrearPartida = new JLabel("CREAR PARTIDA");
        lblCrearPartida.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrearPartida.setBounds(400, 263, 200, 14);
        getContentPane().add(lblCrearPartida);

        String [] nombres = {"Estepas de Tong Long", "Suramar", "Cementerio de Dragones", "Zul`Drak", "Sueño Esmeralda", "Argus"};
        cmbAmbientacion = new JComboBox<>(nombres);
        cmbAmbientacion.setBounds(400, 358, 200, 22);
        getContentPane().add(cmbAmbientacion);
    }
}
