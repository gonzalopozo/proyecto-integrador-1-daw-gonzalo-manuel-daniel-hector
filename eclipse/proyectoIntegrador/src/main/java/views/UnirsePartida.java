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
