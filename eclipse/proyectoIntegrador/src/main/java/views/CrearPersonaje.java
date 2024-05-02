package views;

import javax.swing.*;

public class CrearPersonaje extends VistaDefault {

	private JLabel logoAlianza;
	private JLabel logoHorda;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JLabel iconoHombre;
	private JLabel iconoMujer;
	private JRadioButton rdbtnHumano;
	private JRadioButton rdbtnEnano;
	private JRadioButton rdbtnElfoNoche;
	private JRadioButton rdbtnHuargen;
	private JRadioButton rdbtnPandaAlianza;
	private JRadioButton rdbtnOrco;
	private JRadioButton rdbtnNoMuerto;
	private JRadioButton rdbtnTauren;
	private JRadioButton rdbtnTroll;
	private JRadioButton rdbtnDracthyr;
	private JRadioButton rdbtnGuerrero;
	private JRadioButton rdbtnCazador;
	private JRadioButton rdbtnMago;
	private JRadioButton rdbtnPicaro;
	private JRadioButton rdbtnSacerdote;
	private JRadioButton rdbtnBrujo;
	private JRadioButton rdbtnPaladin;
	private JRadioButton rdbtnDruida;
	private JRadioButton rdbtnChaman;
	private JRadioButton rdbtnCazadorDemonios;
	private JLabel lblNombrePersonaje;
	private JLabel personaje;

	public CrearPersonaje() {
		super();
		setSize(1000,600);
		inicializarComponentes();
		asignarLogo(imagenLogo);
		setLocationRelativeTo(null);
}

public void inicializarComponentes(){
		getContentPane().setLayout(null);
		
		continuar = new JButton("CREAR PERSONAJE");
		continuar.setBounds(778, 515, 200, 23);
		getContentPane().add(continuar);
		
		volver = new JButton("VOLVER");
		volver.setBounds(9, 515, 150, 23);
		getContentPane().add(volver);
		
		logoAlianza = new JLabel();
		ImageIcon imgAlianza = new ImageIcon("src/main/resources/alianzaIcono.png");
		logoAlianza.setIcon(imgAlianza);
		logoAlianza.setBounds(9, 10, 98, 98);
		getContentPane().add(logoAlianza);
		
		logoHorda = new JLabel();
		ImageIcon imgHorda = new ImageIcon("src/main/resources/hordaIcono.png");
		logoHorda.setIcon(imgHorda);
		logoHorda.setBounds(880, 10, 98, 98);
		getContentPane().add(logoHorda);
		
		rdbtnHombre = new JRadioButton("");
		rdbtnHombre.setBounds(488, 11, 20, 23);
		getContentPane().add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("");
		rdbtnMujer.setBounds(555, 11, 20, 23);
		getContentPane().add(rdbtnMujer);
		
		iconoHombre = new JLabel();
		ImageIcon imgHombre = new ImageIcon("src/main/resources/iconoHombre.png");
		iconoHombre.setIcon(imgHombre);
		iconoHombre.setBounds(468, 10, 98, 98);
		getContentPane().add(iconoHombre);
		
		iconoMujer = new JLabel();
		ImageIcon imgMujer = new ImageIcon("src/main/resources/iconoMujer.png");
		iconoMujer.setIcon(imgMujer);
		iconoMujer.setBounds(532, 10, 98, 98);
		getContentPane().add(iconoMujer);
		
		rdbtnHumano = new JRadioButton("Humano");
		rdbtnHumano.setBounds(17, 156, 109, 23);
		getContentPane().add(rdbtnHumano);
		
		rdbtnEnano = new JRadioButton("Enano");
		rdbtnEnano.setBounds(17, 182, 109, 23);
		getContentPane().add(rdbtnEnano);
		
		rdbtnElfoNoche = new JRadioButton("Elfo de la Noche");
		rdbtnElfoNoche.setBounds(17, 208, 109, 23);
		getContentPane().add(rdbtnElfoNoche);
		
		rdbtnHuargen = new JRadioButton("Huargen");
		rdbtnHuargen.setBounds(17, 234, 109, 23);
		getContentPane().add(rdbtnHuargen);
		
		rdbtnPandaAlianza = new JRadioButton("PandaAlianza");
		rdbtnPandaAlianza.setBounds(17, 260, 109, 23);
		getContentPane().add(rdbtnPandaAlianza);
		
		rdbtnOrco = new JRadioButton("Orco");
		rdbtnOrco.setBounds(884, 156, 109, 23);
		getContentPane().add(rdbtnOrco);
		
		rdbtnNoMuerto = new JRadioButton("No muerto");
		rdbtnNoMuerto.setBounds(884, 182, 109, 23);
		getContentPane().add(rdbtnNoMuerto);
		
		rdbtnTauren = new JRadioButton("Tauren");
		rdbtnTauren.setBounds(884, 208, 109, 23);
		getContentPane().add(rdbtnTauren);
		
		rdbtnTroll = new JRadioButton("Troll");
		rdbtnTroll.setBounds(884, 234, 109, 23);
		getContentPane().add(rdbtnTroll);
		
		rdbtnDracthyr = new JRadioButton("Dracthyr");
		rdbtnDracthyr.setBounds(884, 260, 109, 23);
		getContentPane().add(rdbtnDracthyr);
		
		rdbtnGuerrero = new JRadioButton("Guerrero");
		rdbtnGuerrero.setBounds(426, 515, 21, 23);
		getContentPane().add(rdbtnGuerrero);
		
		rdbtnCazador = new JRadioButton("Cazador");
		rdbtnCazador.setBounds(449, 515, 21, 23);
		getContentPane().add(rdbtnCazador);
		
		rdbtnMago = new JRadioButton("Mago");
		rdbtnMago.setBounds(472, 515, 21, 23);
		getContentPane().add(rdbtnMago);
		
		rdbtnPicaro = new JRadioButton("Pícaro");
		rdbtnPicaro.setBounds(495, 515, 21, 23);
		getContentPane().add(rdbtnPicaro);
		
		rdbtnSacerdote = new JRadioButton("Sacerdote");
		rdbtnSacerdote.setBounds(518, 515, 21, 23);
		getContentPane().add(rdbtnSacerdote);
		
		rdbtnBrujo = new JRadioButton("Brujo");
		rdbtnBrujo.setBounds(535, 515, 21, 23);
		getContentPane().add(rdbtnBrujo);
		
		rdbtnPaladin = new JRadioButton("Paladín");
		rdbtnPaladin.setBounds(558, 515, 21, 23);
		getContentPane().add(rdbtnPaladin);
		
		rdbtnDruida = new JRadioButton("Druida");
		rdbtnDruida.setBounds(581, 515, 21, 23);
		getContentPane().add(rdbtnDruida);
		
		rdbtnChaman = new JRadioButton("Chamán");
		rdbtnChaman.setBounds(604, 515, 21, 23);
		getContentPane().add(rdbtnChaman);
		
		rdbtnCazadorDemonios = new JRadioButton("Cazador de demonios");
		rdbtnCazadorDemonios.setBounds(629, 515, 21, 23);
		getContentPane().add(rdbtnCazadorDemonios);
		
		lblNombrePersonaje = new JLabel("NOMBRE PERSONAJE");
		lblNombrePersonaje.setBounds(426, 120, 200, 20);
		getContentPane().add(lblNombrePersonaje);
		
		personaje = new JLabel();
		ImageIcon orco = new ImageIcon("src/main/resources/imagenOrco.png");
		personaje.setIcon(orco);
		personaje.setBounds(350, 150, 300, 300);
		getContentPane().add(personaje);
	}
}
