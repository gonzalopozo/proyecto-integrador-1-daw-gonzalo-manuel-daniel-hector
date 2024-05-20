package views;

import javax.swing.*;
import javax.swing.table.*;

/**
 * Vista de los detalles de los niveles de un jugador en una partida.
 */
public class DetallesNivelesJugando extends VistaDefaultDialog {
    private JTable tablaDatos;
    private JScrollPane scrBarraHorizontal;

    /**
     * Constructor de la vista de los detalles de los niveles de un jugador en una
     * partida.
     */
    public DetallesNivelesJugando(Jugando vistaJugador) {
        super(vistaJugador);
        setSize(600, 400);
        inicializarComponentes();
        asignarLogo(IMAGEN_LOGO);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        volver = new JButton("VOLVER"); // Crear botón de volver
        volver.setBounds(10, 327, 107, 23);
        getContentPane().add(volver);

        DefaultTableModel model = new DefaultTableModel(); // Crear modelo de datos
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
