package views;

import javax.swing.*;
import control.*;

public class UnirsePartida extends VistaDefault {
    private JTable table;
    private JScrollPane scrbarraHorizontal;
    private JButton btnDetalles;

    public UnirsePartida() {
        super();
		setSize(600,400);
		inicializarComponentes();
		asignarLogo(imagenLogo);
        setLocationRelativeTo(null);
    }

    public void inicializarComponentes() {
        volver = new JButton("VOLVER");
        volver.setBounds(10, 327, 107, 23);
        getContentPane().add(volver);

        String[][] datos = {
            { "La batalla por el templo del Tigre Blanco", "Estepas de Tong Long", "33"},
            { "Lucha contra el Rey Exánime", "Cementerio de Dragones", "7"},
            {"La conquista demoníaca", "Argus", "24"}
        };

        String[] nombresColumnas = { "Partida", "Ambientación", "Nivel medio" };

        table = new JTable(datos, nombresColumnas);

        scrbarraHorizontal = new JScrollPane(table);
        scrbarraHorizontal.setBounds(10, 11, 564, 302);
        getContentPane().add(scrbarraHorizontal);
        
        continuar = new JButton("UNIRSE");
        continuar.setBounds(467, 327, 107, 23);
        getContentPane().add(continuar);
        
        btnDetalles = new JButton("DETALLES");
        btnDetalles.setBounds(221, 327, 141, 23);
        getContentPane().add(btnDetalles);
    }

    public void setListenerBotonDetalles(MoverseListener listener) {
        btnDetalles.addActionListener(listener);
    }

}
