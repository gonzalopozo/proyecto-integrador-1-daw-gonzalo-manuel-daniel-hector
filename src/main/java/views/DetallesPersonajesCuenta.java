package views;

import javax.swing.*;
import javax.swing.table.*;

/**
 * Vista que muestra los detalles de los personajes de una cuenta de usuario.
 */
public class DetallesPersonajesCuenta extends VistaDefault {
    private JTable tablaDatos;
    private JScrollPane scrBarraHorizontal;

    /**
     * Constructor de la vista donde mostrar los detalles de los personajes de una
     * cuenta de usuario.
     */
    public DetallesPersonajesCuenta() {
        super();
        setSize(600, 400);
        inicializarComponentes();
        asignarLogo(IMAGEN_LOGO);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        volver = new JButton("VOLVER"); // Botón para volver a la vista anterior
        volver.setBounds(10, 327, 107, 23);
        getContentPane().add(volver);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Raza");
        model.addColumn("Clase");
        model.addColumn("Partida");
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
        for (int i = 0; i < model.getColumnCount(); i++) { // Recorrer las columnas del modelo de datos
            TableColumn column = new TableColumn(i); // Crear una columna para la tabla
            column.setHeaderValue(model.getColumnName(i)); // Asignar el nombre de la columna
            columnModel.addColumn(column); // Agregar la columna al modelo de columnas
        }

        // Crear la JTable con el modelo de datos y el modelo de columnas
        tablaDatos = new JTable(model, columnModel);

        scrBarraHorizontal = new JScrollPane(tablaDatos); // Crear un scroll para la tabla
        scrBarraHorizontal.setBounds(10, 11, 564, 302); // Establecer las dimensiones del scroll
        getContentPane().add(scrBarraHorizontal);

    }

    public JTable getTablaDatos() {
        return tablaDatos;
    }

    public void setTablaDatos(JTable tablaDatos) {
        this.tablaDatos = tablaDatos;
    }

}
