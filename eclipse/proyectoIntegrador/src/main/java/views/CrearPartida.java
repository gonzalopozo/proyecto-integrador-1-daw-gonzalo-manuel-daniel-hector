package views;

import javax.swing.*;
import java.awt.Font;

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
        getContentPane().setLayout(null);
        txtNombrePartida = new JTextField();
        txtNombrePartida.setBounds(242, 310, 200, 20);
        getContentPane().add(txtNombrePartida);
        txtNombrePartida.setColumns(10);

        continuar = new JButton("CREAR PARTIDA");
        continuar.setBounds(259, 400, 162, 31);
        getContentPane().add(continuar);

        lblNombrePartida = new JLabel("NOMBRE PARTIDA");
        lblNombrePartida.setBounds(242, 288, 186, 14);
        getContentPane().add(lblNombrePartida);

        lblAmbientacion = new JLabel("AMBIENTACIÓN");
        lblAmbientacion.setBounds(242, 341, 186, 14);
        getContentPane().add(lblAmbientacion);

        lblCrearPartida = new JLabel("CREAR PARTIDA");
        lblCrearPartida.setFont(new Font("Arial", Font.BOLD, 18));
        lblCrearPartida.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrearPartida.setBounds(242, 242, 200, 14);
        getContentPane().add(lblCrearPartida);

        String [] nombres = {"Estepas de Tong Long", "Suramar", "Cementerio de Dragones", "Zul`Drak", "Sueño Esmeralda", "Argus"};
        cmbAmbientacion = new JComboBox<>(nombres);
        cmbAmbientacion.setBounds(242, 360, 200, 20);
        getContentPane().add(cmbAmbientacion);
        
        JButton btnNewButton = new JButton("VOLVER");
        btnNewButton.setBounds(10, 527, 89, 23);
        getContentPane().add(btnNewButton);
    }
}
