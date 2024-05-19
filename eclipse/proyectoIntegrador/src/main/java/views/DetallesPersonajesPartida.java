package views;

import javax.swing.*;
import javax.swing.table.*;


public class DetallesPersonajesPartida extends VistaDefault {
    private JTable tablaDatos;
    private JScrollPane scrBarraHorizontal;

    public DetallesPersonajesPartida() {
        super();
        setSize(600, 400);
        inicializarComponentes();
        asignarLogo(imagenLogo);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        volver = new JButton("VOLVER");
        volver.setBounds(10, 327, 107, 23);
        getContentPane().add(volver);

        // Object[][] datos = {};

        // String[] nombresColumnas = {"Icono", "Nombre", "Raza", "Clase", "Nivel", "Salud", "Fuerza", "Destreza", "Sabiduría", "Carisma", "Inteligencia", "Constitución"};

        // String[] nombresColumnas = {"Nombre", "Raza", "Clase", "Partida", "Nivel", "Salud", "Fuerza", "Destreza", "Sabiduría", "Carisma", "Inteligencia", "Constitución"};
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Raza");
        model.addColumn("Clase");
        model.addColumn("Nivel");
        model.addColumn("Salud");
        model.addColumn("Fuerza");
        model.addColumn("Destreza");
        model.addColumn("Sabiduría");
        model.addColumn("Carisma");
        model.addColumn("Inteligencia");
        model.addColumn("Constitución");

        // Crear el modelo de columnas con el mismo encabezado que el modelo de datos
        TableColumnModel columnModel = new DefaultTableColumnModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            TableColumn column = new TableColumn(i);
            column.setHeaderValue(model.getColumnName(i));
            columnModel.addColumn(column);
        }

        // Crear la JTable con el modelo de datos y el modelo de columnas
        tablaDatos = new JTable(model, columnModel);

        scrBarraHorizontal = new JScrollPane(tablaDatos);
        scrBarraHorizontal.setBounds(10, 11, 564, 302);
        getContentPane().add(scrBarraHorizontal);
    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(JTable tablaDatos) {
        this.tablaDatos = tablaDatos;
    }
}
