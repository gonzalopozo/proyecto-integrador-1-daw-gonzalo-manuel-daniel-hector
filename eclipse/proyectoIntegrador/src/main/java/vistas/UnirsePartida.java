package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UnirsePartida extends JFrame {
    private JLabel logo;
    private JTable table;

    public UnirsePartida() {

        getContentPane().setLayout(null);
        setSize(600, 400);

        logo = new JLabel();

        JButton btnNewButton_1_2_1 = new JButton("VOLVER");
        btnNewButton_1_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1_2_1.setBounds(10, 327, 107, 23);
        getContentPane().add(btnNewButton_1_2_1);

        // Data to be displayed in the JTable
        String[][] data = {
            { "La batalla por el templo del Tigre Blanco", "Estepas de Tong Long", "33"},
            { "Lucha contra el Rey Exánime", "Cementerio de Dragones", "7"},
            {"La conquista demoníaca", "Argus", "24"}
        };

        // Column Names
        String[] columnNames = { "Partida", "Ambientación", "Nivel medio" };

        // Create the JTable with data and columnNames
        table = new JTable(data, columnNames);

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 11, 564, 302);

        // Add the JScrollPane to the content pane
        getContentPane().add(scrollPane);
        
        JButton btnNewButton_1_2_1_1 = new JButton("UNIRSE");
        btnNewButton_1_2_1_1.setBounds(467, 327, 107, 23);
        getContentPane().add(btnNewButton_1_2_1_1);
        
        JButton btnNewButton_1_2_1_2 = new JButton("DETALLES");
        btnNewButton_1_2_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1_2_1_2.setBounds(221, 327, 141, 23);
        getContentPane().add(btnNewButton_1_2_1_2);
    }

    public void hacerVisible() {
        setVisible(true);
    }

    public void asignarLogo(ImageIcon img) {
        logo.setIcon(img);
        logo.setBounds(375, -10, 350, 350);
        getContentPane().add(logo);
    }
}
