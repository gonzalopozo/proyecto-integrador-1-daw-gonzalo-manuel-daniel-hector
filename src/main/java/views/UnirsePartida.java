package views;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import control.*;

/**
 * Esta clase representa la vista para unirse a una partida.
 */
public class UnirsePartida extends VistaDefault {
	private JTable table;
	private JScrollPane scrbarraHorizontal;
	private JButton btnDetalles;

	/**
	 * Constructor de la clase UnirsePartida.
	 */
	public UnirsePartida() {
		super();
		setSize(600, 400);
		inicializarComponentes();
		asignarLogo(IMAGEN_LOGO); // Asigna el logo a la vista
		setLocationRelativeTo(null);
	}

	/**
	 * Método para asignar un controlador a los botones de la vista.
	 * 
	 * @param listener Controlador que manejará los eventos de la vista.
	 */
	public void inicializarComponentes() {
		volver = new JButton("VOLVER"); // Botón para volver a la vista anterior
		volver.setBounds(10, 327, 107, 23);
		getContentPane().add(volver); // Agrega el botón a la vista

		// Creación de la tabla
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Jugando"); // Columnas de la tabla
		model.addColumn("Partida");
		model.addColumn("Ambientación");
		model.addColumn("Nivel medio");

		/*
		 * Se agregan los datos de las partidas a la tabla.
		 */
		TableColumnModel columnModel = new DefaultTableColumnModel();
		for (int i = 0; i < model.getColumnCount(); i++) { // Agrega las columnas a la tabla
			TableColumn column = new TableColumn(i); // Crea una columna
			column.setHeaderValue(model.getColumnName(i)); // Asigna el nombre de la columna
			columnModel.addColumn(column); // Agrega la columna a la tabla
		}

		table = new JTable(model, columnModel);

		scrbarraHorizontal = new JScrollPane(table); // Agrega la tabla a un scroll
		scrbarraHorizontal.setBounds(10, 11, 564, 302);
		getContentPane().add(scrbarraHorizontal); // Agrega el scroll a la vista

		continuar = new JButton("UNIRSE"); // Botón para unirse a una partida
		continuar.setBounds(467, 327, 107, 23);
		getContentPane().add(continuar); // Agrega el botón a la vista

		btnDetalles = new JButton("DETALLES"); // Botón para ver los detalles de una partida
		btnDetalles.setBounds(221, 327, 141, 23);
		getContentPane().add(btnDetalles);

		table.getSelectedRow(); // ! Obtiene la fila seleccionada de la tabla
	}

	/**
	 * Establece el listener para el botón Detalles.
	 * 
	 * @param listener El listener para el botón Detalles.
	 */
	public void setListenerBotonDetalles(DetallesPersonajesPartidaJugarListener listener) {
		btnDetalles.addActionListener(listener);
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * @return the scrbarraHorizontal
	 */
	public JScrollPane getScrbarraHorizontal() {
		return scrbarraHorizontal;
	}

	/**
	 * @param scrbarraHorizontal the scrbarraHorizontal to set
	 */
	public void setScrbarraHorizontal(JScrollPane scrbarraHorizontal) {
		this.scrbarraHorizontal = scrbarraHorizontal;
	}

	/**
	 * @return the btnDetalles
	 */
	public JButton getBtnDetalles() {
		return btnDetalles;
	}

	/**
	 * @param btnDetalles the btnDetalles to set
	 */
	public void setBtnDetalles(JButton btnDetalles) {
		this.btnDetalles = btnDetalles;
	}
}
