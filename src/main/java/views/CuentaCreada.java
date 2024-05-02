package views;

import javax.swing.*;

public class CuentaCreada extends VistaDefault {

	private JLabel lblcheck;
	private ImageIcon imgCheck;
	private JLabel lblListo;
	private JLabel lblCuentaCreada;


	public CuentaCreada() {
		super();
		setSize(500,400);
		inicializarComponentes();
		setLocationRelativeTo(null);
	}
	
	private void inicializarComponentes(){
		lblcheck = new JLabel();
		imgCheck = new ImageIcon("src/main/resources/iconoCheck.png");
		lblcheck.setIcon(imgCheck);
		lblcheck.setBounds(168, 11, 222, 222);
		getContentPane().add(lblcheck);
		
		continuar = new JButton("CONTINUAR");
		continuar.setBounds(174, 294, 136, 31);
		getContentPane().add(continuar);
		
		lblListo = new JLabel("¡lblListo!");
		lblListo.setHorizontalAlignment(SwingConstants.CENTER);
		lblListo.setBounds(199, 233, 85, 14);
		getContentPane().add(lblListo);
		
		lblCuentaCreada = new JLabel("SE HA CREADO TU CUENTA");
		lblCuentaCreada.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaCreada.setBounds(136, 258, 212, 14);
		getContentPane().add(lblCuentaCreada);
	}
}