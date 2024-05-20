package views;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.*;
import components.*;
import control.*;

/**
 * clase que va a extender de la de vista default
 */
public class CrearPersonaje extends VistaDefault {

	// se definen todas las variables que se van a utilizar en la vista.
	private JLabel logoAlianza;
	private JLabel logoHorda;
	private CircularToggleButton rdbtnHumano;
	private CircularToggleButton rdbtnEnano;
	private CircularToggleButton rdbtnElfoNoche;
	private CircularToggleButton rdbtnHuargen;
	private CircularToggleButton rdbtnPandaAlianza;
	private CircularToggleButton rdbtnOrco;
	private CircularToggleButton rdbtnNoMuerto;
	private CircularToggleButton rdbtnTauren;
	private CircularToggleButton rdbtnTroll;
	private CircularToggleButton rdbtnDracthyr;
	private CircularToggleButton btnGuerrero;
	private CircularToggleButton btnCazador;
	private CircularToggleButton rdbtnMago;
	private CircularToggleButton rdbtnPicaro;
	private CircularToggleButton rdbtnSacerdote;
	private CircularToggleButton rdbtnBrujo;
	private CircularToggleButton rdbtnPaladin;
	private CircularToggleButton rdbtnDruida;
	private CircularToggleButton rdbtnChaman;
	private CircularToggleButton rdbtnCazadorDemonios;
	private CircularToggleButton rdbtnCaballeroMuerte;
	private CircularToggleButton rdbtnEvocador;
	private CircularToggleButton rdbtnHombre;
	private CircularToggleButton rdbtnMujer;
	private JLabel personaje;
	private JTextField txtNombrePersonaje;
	private ButtonGroup sexo;
	private ButtonGroup raza;
	private ButtonGroup clase;
	private ImageIcon imagenPersonaje;

	// e crean los getters y setters

	public JLabel getLogoAlianza() {
		return logoAlianza;
	}

	public void setLogoAlianza(JLabel logoAlianza) {
		this.logoAlianza = logoAlianza;
	}

	public JLabel getLogoHorda() {
		return logoHorda;
	}

	public void setLogoHorda(JLabel logoHorda) {
		this.logoHorda = logoHorda;
	}

	public CircularToggleButton getRdbtnHumano() {
		return rdbtnHumano;
	}

	public void setRdbtnHumano(CircularToggleButton rdbtnHumano) {
		this.rdbtnHumano = rdbtnHumano;
	}

	public CircularToggleButton getRdbtnEnano() {
		return rdbtnEnano;
	}

	public void setRdbtnEnano(CircularToggleButton rdbtnEnano) {
		this.rdbtnEnano = rdbtnEnano;
	}

	public CircularToggleButton getRdbtnElfoNoche() {
		return rdbtnElfoNoche;
	}

	public void setRdbtnElfoNoche(CircularToggleButton rdbtnElfoNoche) {
		this.rdbtnElfoNoche = rdbtnElfoNoche;
	}

	public CircularToggleButton getRdbtnHuargen() {
		return rdbtnHuargen;
	}

	public void setRdbtnHuargen(CircularToggleButton rdbtnHuargen) {
		this.rdbtnHuargen = rdbtnHuargen;
	}

	public CircularToggleButton getRdbtnPandaAlianza() {
		return rdbtnPandaAlianza;
	}

	public void setRdbtnPandaAlianza(CircularToggleButton rdbtnPandaAlianza) {
		this.rdbtnPandaAlianza = rdbtnPandaAlianza;
	}

	public CircularToggleButton getRdbtnOrco() {
		return rdbtnOrco;
	}

	public void setRdbtnOrco(CircularToggleButton rdbtnOrco) {
		this.rdbtnOrco = rdbtnOrco;
	}

	public CircularToggleButton getRdbtnNoMuerto() {
		return rdbtnNoMuerto;
	}

	public void setRdbtnNoMuerto(CircularToggleButton rdbtnNoMuerto) {
		this.rdbtnNoMuerto = rdbtnNoMuerto;
	}

	public CircularToggleButton getRdbtnTauren() {
		return rdbtnTauren;
	}

	public void setRdbtnTauren(CircularToggleButton rdbtnTauren) {
		this.rdbtnTauren = rdbtnTauren;
	}

	public CircularToggleButton getRdbtnTroll() {
		return rdbtnTroll;
	}

	public void setRdbtnTroll(CircularToggleButton rdbtnTroll) {
		this.rdbtnTroll = rdbtnTroll;
	}

	public CircularToggleButton getRdbtnDracthyr() {
		return rdbtnDracthyr;
	}

	public void setRdbtnDracthyr(CircularToggleButton rdbtnDracthyr) {
		this.rdbtnDracthyr = rdbtnDracthyr;
	}

	public CircularToggleButton getBtnGuerrero() {
		return btnGuerrero;
	}

	public void setBtnGuerrero(CircularToggleButton btnGuerrero) {
		this.btnGuerrero = btnGuerrero;
	}

	public CircularToggleButton getBtnCazador() {
		return btnCazador;
	}

	public void setBtnCazador(CircularToggleButton btnCazador) {
		this.btnCazador = btnCazador;
	}

	public CircularToggleButton getRdbtnMago() {
		return rdbtnMago;
	}

	public void setRdbtnMago(CircularToggleButton rdbtnMago) {
		this.rdbtnMago = rdbtnMago;
	}

	public CircularToggleButton getRdbtnPicaro() {
		return rdbtnPicaro;
	}

	public void setRdbtnPicaro(CircularToggleButton rdbtnPicaro) {
		this.rdbtnPicaro = rdbtnPicaro;
	}

	public CircularToggleButton getRdbtnSacerdote() {
		return rdbtnSacerdote;
	}

	public void setRdbtnSacerdote(CircularToggleButton rdbtnSacerdote) {
		this.rdbtnSacerdote = rdbtnSacerdote;
	}

	public CircularToggleButton getRdbtnBrujo() {
		return rdbtnBrujo;
	}

	public void setRdbtnBrujo(CircularToggleButton rdbtnBrujo) {
		this.rdbtnBrujo = rdbtnBrujo;
	}

	public CircularToggleButton getRdbtnPaladin() {
		return rdbtnPaladin;
	}

	public void setRdbtnPaladin(CircularToggleButton rdbtnPaladin) {
		this.rdbtnPaladin = rdbtnPaladin;
	}

	public CircularToggleButton getRdbtnDruida() {
		return rdbtnDruida;
	}

	public void setRdbtnDruida(CircularToggleButton rdbtnDruida) {
		this.rdbtnDruida = rdbtnDruida;
	}

	public CircularToggleButton getRdbtnChaman() {
		return rdbtnChaman;
	}

	public void setRdbtnChaman(CircularToggleButton rdbtnChaman) {
		this.rdbtnChaman = rdbtnChaman;
	}

	public CircularToggleButton getRdbtnCazadorDemonios() {
		return rdbtnCazadorDemonios;
	}

	public void setRdbtnCazadorDemonios(CircularToggleButton rdbtnCazadorDemonios) {
		this.rdbtnCazadorDemonios = rdbtnCazadorDemonios;
	}

	public CircularToggleButton getRdbtnCaballeroMuerte() {
		return rdbtnCaballeroMuerte;
	}

	public void setRdbtnCaballeroMuerte(CircularToggleButton rdbtnCaballeroMuerte) {
		this.rdbtnCaballeroMuerte = rdbtnCaballeroMuerte;
	}

	public CircularToggleButton getRdbtnEvocador() {
		return rdbtnEvocador;
	}

	public void setRdbtnEvocador(CircularToggleButton rdbtnEvocador) {
		this.rdbtnEvocador = rdbtnEvocador;
	}

	public CircularToggleButton getRdbtnHombre() {
		return rdbtnHombre;
	}

	public void setRdbtnHombre(CircularToggleButton rdbtnHombre) {
		this.rdbtnHombre = rdbtnHombre;
	}

	public CircularToggleButton getRdbtnMujer() {
		return rdbtnMujer;
	}

	public void setRdbtnMujer(CircularToggleButton rdbtnMujer) {
		this.rdbtnMujer = rdbtnMujer;
	}

	public JLabel getPersonaje() {
		return personaje;
	}

	public void setPersonaje(JLabel personaje) {
		this.personaje = personaje;
	}

	public JTextField getTxtNombrePersonaje() {
		return txtNombrePersonaje;
	}

	public void setTxtNombrePersonaje(JTextField txtNombrePersonaje) {
		this.txtNombrePersonaje = txtNombrePersonaje;
	}

	public ButtonGroup getSexo() {
		return sexo;
	}

	public void setSexo(ButtonGroup sexo) {
		this.sexo = sexo;
	}

	public ButtonGroup getRaza() {
		return raza;
	}

	public void setRaza(ButtonGroup raza) {
		this.raza = raza;
	}

	public ButtonGroup getClase() {
		return clase;
	}

	public void setClase(ButtonGroup clase) {
		this.clase = clase;
	}

	/**
	 * Constructor de la vista, asignando los métodos necesarios.
	 */
	public CrearPersonaje() {
		super();
		setSize(1000, 600);
		inicializarComponentes();
		setLocationRelativeTo(null);
	}

	/**
	 * Método que determina si el botón está seleccionado o no.
	 */
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	/**
	 * Método el cual se va a encargar de inicializar todos los componentes que van
	 * a aparecer en la vista.
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		// Creación de botón crear personaje, el cual hará las funciones de continuar
		continuar = new JButton("CREAR PERSONAJE");
		continuar.setBounds(778, 515, 200, 23);
		getContentPane().add(continuar);

		// Creación del botón de volver
		volver = new JButton("VOLVER");
		volver.setBounds(9, 515, 150, 23);
		getContentPane().add(volver);

		// Creación de etiqueta en la que aparecerá la imagen de la alianza
		logoAlianza = new JLabel();
		ImageIcon imgAlianza = new ImageIcon("src/main/resources/AllianceLogo.png");
		logoAlianza.setIcon(imgAlianza);
		logoAlianza.setBounds(28, 10, 98, 98);
		getContentPane().add(logoAlianza);

		// Creación de etiqueta en la que aparecerá la imagen de la horda
		logoHorda = new JLabel();
		ImageIcon imgHorda = new ImageIcon("src/main/resources/logohorda.png");
		logoHorda.setIcon(imgHorda);
		logoHorda.setBounds(876, 22, 98, 98);
		getContentPane().add(logoHorda);

		// Creación del file para poner la ruta de la imagen
		File iconoHuman = new File("src/main/resources/humano.png"); // Ruta de tu imagen
		Image imageHuman = null;
		try {
			imageHuman = ImageIO.read(iconoHuman);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del humano al que se le asigna la imagen
		rdbtnHumano = new CircularToggleButton(imageHuman, "Humano");
		rdbtnHumano.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnHumano.setText("Humano");
		rdbtnHumano.setBounds(45, 135, 55, 55);
		getContentPane().add(rdbtnHumano);

		// Creación del file para poner la ruta de la imagen
		File iconoDwarf = new File("src/main/resources/enano.png"); // Ruta de tu imagen
		Image imageDwarf = null;
		try {
			imageDwarf = ImageIO.read(iconoDwarf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del enano al que se le asigna la imagen
		rdbtnEnano = new CircularToggleButton(imageDwarf, "Enano");
		rdbtnEnano.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnEnano.setText("Enano");
		rdbtnEnano.setBounds(45, 185, 55, 55);
		getContentPane().add(rdbtnEnano);

		// Creación del file para poner la ruta de la imagen
		File iconoNe = new File("src/main/resources/elfoNoche.png"); // Ruta de tu imagen
		Image imageNE = null;
		try {
			imageNE = ImageIO.read(iconoNe);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del elfo de la noche al que se le asigna la imagen
		rdbtnElfoNoche = new CircularToggleButton(imageNE, "Elfo de la noche");
		rdbtnElfoNoche.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnElfoNoche.setText("Elfo de la noche");
		rdbtnElfoNoche.setBounds(45, 235, 55, 55);
		getContentPane().add(rdbtnElfoNoche);

		// Creación del file para poner la ruta de la imagen
		File iconoHuargen = new File("src/main/resources/huargen.png"); // Ruta de tu imagen
		Image imageHuargen = null;
		try {
			imageHuargen = ImageIO.read(iconoHuargen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del huargen al que se le asigna la imagen
		rdbtnHuargen = new CircularToggleButton(imageHuargen, "Huargen");
		rdbtnHuargen.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnHuargen.setText("Huargen");
		rdbtnHuargen.setBounds(45, 285, 55, 55);
		getContentPane().add(rdbtnHuargen);

		// Creación del file para poner la ruta de la imagen
		File iconoPandaA = new File("src/main/resources/pandaH.png"); // Ruta de tu imagen
		Image imagePandaA = null;
		try {
			imagePandaA = ImageIO.read(iconoPandaA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del panda al que se le asigna la imagen
		rdbtnPandaAlianza = new CircularToggleButton(imagePandaA, "Panda");
		rdbtnPandaAlianza.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnPandaAlianza.setText("Pandaren");
		rdbtnPandaAlianza.setBounds(45, 335, 55, 55);
		getContentPane().add(rdbtnPandaAlianza);

		// Creación del file para poner la ruta de la imagen
		File iconoOrco = new File("src/main/resources/orcoH.png"); // Ruta de tu imagen
		Image imageOrco = null;
		try {
			imageOrco = ImageIO.read(iconoOrco);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del huargen al que se le asigna la imagen
		rdbtnOrco = new CircularToggleButton(imageOrco, "Orco");
		rdbtnOrco.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnOrco.setText("Orco");
		rdbtnOrco.setBounds(884, 135, 55, 55);
		getContentPane().add(rdbtnOrco);

		// Creación del file para poner la ruta de la imagen
		File iconoNoMuerto = new File("src/main/resources/nomuertoH.png"); // Ruta de tu imagen
		Image imageNoMuerto = null;
		try {
			imageNoMuerto = ImageIO.read(iconoNoMuerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del no muerto al que se le asigna la imagen
		rdbtnNoMuerto = new CircularToggleButton(imageNoMuerto, "No Muerto");
		rdbtnNoMuerto.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnNoMuerto.setText("No muerto");
		rdbtnNoMuerto.setBounds(884, 185, 55, 55);
		getContentPane().add(rdbtnNoMuerto);

		// Creación del file para poner la ruta de la imagen
		File iconoTauren = new File("src/main/resources/taurenH.png"); // Ruta de tu imagen
		Image imageTauren = null;
		try {
			imageTauren = ImageIO.read(iconoTauren);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del tauren al que se le asigna la imagen
		rdbtnTauren = new CircularToggleButton(imageTauren, "Tauren");
		rdbtnTauren.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnTauren.setText("Tauren");
		rdbtnTauren.setBounds(884, 235, 55, 55);
		getContentPane().add(rdbtnTauren);

		// Creación del file para poner la ruta de la imagen
		File iconoTroll = new File("src/main/resources/trollH.png"); // Ruta de tu imagen
		Image imageTroll = null;
		try {
			imageTroll = ImageIO.read(iconoTroll);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del troll al que se le asigna la imagen
		rdbtnTroll = new CircularToggleButton(imageTroll, "Troll");
		rdbtnTroll.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnTroll.setText("Troll");
		rdbtnTroll.setBounds(884, 285, 55, 55);
		getContentPane().add(rdbtnTroll);

		// Creación del file para poner la ruta de la imagen
		File iconoDracthyr = new File("src/main/resources/dracthyrr.png"); // Ruta de tu imagen
		Image imageDracthyr = null;
		try {
			imageDracthyr = ImageIO.read(iconoDracthyr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del dracthyr al que se le asigna la imagen
		rdbtnDracthyr = new CircularToggleButton(imageDracthyr, "Dracthyr");
		rdbtnDracthyr.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnDracthyr.setText("Dracthyr");
		rdbtnDracthyr.setBounds(884, 335, 55, 55);
		getContentPane().add(rdbtnDracthyr);

		// Creación del file para poner la ruta de la imagen
		File iconoMujer = new File("src/main/resources/logoMujer.png"); // Ruta de tu imagen
		Image imageMujer = null;
		try {
			imageMujer = ImageIO.read(iconoMujer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton de la mujer al que se le asigna la imagen
		rdbtnMujer = new CircularToggleButton(imageMujer, "Mujer");
		rdbtnMujer.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnMujer.setText("Mujer");
		rdbtnMujer.setBounds(494, 10, 55, 55);
		getContentPane().add(rdbtnMujer);

		// Creación del file para poner la ruta de la imagen
		File iconoHombre = new File("src/main/resources/logoHombre.png"); // Ruta de tu imagen
		Image imageHombre = null;
		try {
			imageHombre = ImageIO.read(iconoHombre);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del hombre al que se le asigna la imagen
		rdbtnHombre = new CircularToggleButton(imageHombre, "Hombre");
		rdbtnHombre.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnHombre.setText("Hombre");
		rdbtnHombre.setBounds(440, 10, 55, 55);
		getContentPane().add(rdbtnHombre);

		// Creación del file para poner la ruta de la imagen
		File iconoGuerrero = new File("src/main/resources/guerrero.png"); // Ruta de tu imagen
		Image imageGuerrero = null;
		try {
			imageGuerrero = ImageIO.read(iconoGuerrero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del guerrero al que se le asigna la imagen
		btnGuerrero = new CircularToggleButton(imageGuerrero, "Guerrero");
		btnGuerrero.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		btnGuerrero.setText("Guerrero");
		btnGuerrero.setBounds(159, 506, 55, 55);
		getContentPane().add(btnGuerrero);

		// Creación del file para poner la ruta de la imagen
		File iconoCazador = new File("src/main/resources/cazador.png"); // Ruta de tu imagen
		Image imageCazador = null;
		try {
			imageCazador = ImageIO.read(iconoCazador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del hombre al que se le asigna la imagen
		btnCazador = new CircularToggleButton(imageCazador, "Cazador");
		btnCazador.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		btnCazador.setText("Cazador");
		btnCazador.setBounds(211, 506, 55, 55);
		getContentPane().add(btnCazador);

		// Creación del file para poner la ruta de la imagen
		File iconoMago = new File("src/main/resources/mago.png"); // Ruta de tu imagen
		Image imageMago = null;
		try {
			imageMago = ImageIO.read(iconoMago);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del mago al que se le asigna la imagen
		rdbtnMago = new CircularToggleButton(imageMago, "Mago");
		rdbtnMago.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnMago.setText("Mago");
		rdbtnMago.setBounds(263, 506, 55, 55);
		getContentPane().add(rdbtnMago);

		// Creación del file para poner la ruta de la imagen
		File iconoPicaro = new File("src/main/resources/picaro.png"); // Ruta de tu imagen
		Image imagePicaro = null;
		try {
			imagePicaro = ImageIO.read(iconoPicaro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del picaro al que se le asigna la imagen
		rdbtnPicaro = new CircularToggleButton(imagePicaro, "Picaro");
		rdbtnPicaro.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnPicaro.setText("Picaro");
		rdbtnPicaro.setBounds(315, 506, 55, 55);
		getContentPane().add(rdbtnPicaro);

		// Creación del file para poner la ruta de la imagen
		File iconoSacerdote = new File("src/main/resources/sacerdote.png"); // Ruta de tu imagen
		Image imageSacerdote = null;
		try {
			imageSacerdote = ImageIO.read(iconoSacerdote);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del sacerdote al que se le asigna la imagen
		rdbtnSacerdote = new CircularToggleButton(imageSacerdote, "Sacerdote");
		rdbtnSacerdote.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnSacerdote.setText("Sacerdote");
		rdbtnSacerdote.setBounds(367, 506, 55, 55);
		getContentPane().add(rdbtnSacerdote);

		// Creación del file para poner la ruta de la imagen
		File iconoBrujo = new File("src/main/resources/brujo.png"); // Ruta de tu imagen
		Image imageBrujo = null;
		try {
			imageBrujo = ImageIO.read(iconoBrujo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del brujo al que se le asigna la imagen
		rdbtnBrujo = new CircularToggleButton(imageBrujo, "Brujo");
		rdbtnBrujo.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnBrujo.setText("Brujo");
		rdbtnBrujo.setBounds(419, 506, 55, 55);
		getContentPane().add(rdbtnBrujo);

		// Creación del file para poner la ruta de la imagen
		File iconoPaladin = new File("src/main/resources/paladin.png"); // Ruta de tu imagen
		Image imagePaladin = null;
		try {
			imagePaladin = ImageIO.read(iconoPaladin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del paladín al que se le asigna la imagen
		rdbtnPaladin = new CircularToggleButton(imagePaladin, "Paladin");
		rdbtnPaladin.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnPaladin.setText("Paladin");
		rdbtnPaladin.setBounds(471, 506, 55, 55);
		getContentPane().add(rdbtnPaladin);

		// Creación del file para poner la ruta de la imagen
		File iconoDruida = new File("src/main/resources/druida.png"); // Ruta de tu imagen
		Image imageDruida = null;
		try {
			imageDruida = ImageIO.read(iconoDruida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del druida al que se le asigna la imagen
		rdbtnDruida = new CircularToggleButton(imageDruida, "Druida");
		rdbtnDruida.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnDruida.setText("Druida");
		rdbtnDruida.setBounds(523, 506, 55, 55);
		getContentPane().add(rdbtnDruida);

		// Creación del file para poner la ruta de la imagen
		File iconoChaman = new File("src/main/resources/chaman.png"); // Ruta de tu imagen
		Image imageChaman = null;
		try {
			imageChaman = ImageIO.read(iconoChaman);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del chamán al que se le asigna la imagen
		rdbtnChaman = new CircularToggleButton(imageChaman, "Chaman");
		rdbtnChaman.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnChaman.setText("Chaman");
		rdbtnChaman.setBounds(575, 506, 55, 55);
		getContentPane().add(rdbtnChaman);

		// Creación del file para poner la ruta de la imagen
		File iconoDK = new File("src/main/resources/caballeroMuerte.png"); // Ruta de tu imagen
		Image imageDK = null;
		try {
			imageDK = ImageIO.read(iconoDK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del caballero de la muerte al que se le asigna la
		// imagen
		rdbtnCaballeroMuerte = new CircularToggleButton(imageDK, "Cabellero de la Muerte");
		rdbtnCaballeroMuerte.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnCaballeroMuerte.setText("Caballero de la muerte");
		rdbtnCaballeroMuerte.setBounds(627, 506, 55, 55);
		getContentPane().add(rdbtnCaballeroMuerte);

		// Creación del file para poner la ruta de la imagen
		File iconoDH = new File("src/main/resources/cazadorDemonios.png"); // Ruta de tu imagen
		Image imageDH = null;
		try {
			imageDH = ImageIO.read(iconoDH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del cazador de demonios al que se le asigna la imagen
		rdbtnCazadorDemonios = new CircularToggleButton(imageDH, "Cazador de Demonios");
		rdbtnCazadorDemonios.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnCazadorDemonios.setText("Cazador de demonios");
		rdbtnCazadorDemonios.setBounds(679, 506, 55, 55);
		getContentPane().add(rdbtnCazadorDemonios);

		// Creación del file para poner la ruta de la imagen
		File iconoEvocador = new File("src/main/resources/dracthyr.png"); // Ruta de tu imagen
		Image imageEvocador = null;
		try {
			imageEvocador = ImageIO.read(iconoEvocador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Creación de radiobutton del evocador al que se le asigna la imagen
		rdbtnEvocador = new CircularToggleButton(imageEvocador, "Evocador");
		rdbtnEvocador.addItemListener(new CrearPersonajeSeleccionadoListener(this));
		rdbtnEvocador.setText("Evocador");
		rdbtnEvocador.setBounds(731, 506, 55, 55);
		getContentPane().add(rdbtnEvocador);

		// Creación de la etiqueta del personaje
		personaje = new JLabel();
		personaje.setHorizontalAlignment(SwingConstants.CENTER);
		personaje.setBounds(342, 151, 300, 300);
		getContentPane().add(personaje);

		// Creación del textfield del nombre del personaje
		txtNombrePersonaje = new JTextField();
		txtNombrePersonaje.setBounds(426, 107, 132, 20);
		getContentPane().add(txtNombrePersonaje);
		txtNombrePersonaje.setColumns(10);

		// Creación de la etiqueta del nombre personaje
		JLabel lblNewLabel = new JLabel("Nombre Personaje");
		lblNewLabel.setBounds(427, 80, 140, 14);
		getContentPane().add(lblNewLabel);

		// Creación del buttongroup de sexo
		sexo = new ButtonGroup();
		// Se añaden ambos botones del género
		sexo.add(rdbtnHombre);
		sexo.add(rdbtnMujer);

		// Creación del buttongroup de raza
		raza = new ButtonGroup();
		// Se añaden todos los radiobutton al buttongroup de raza
		raza.add(rdbtnHumano);
		raza.add(rdbtnEnano);
		raza.add(rdbtnElfoNoche);
		raza.add(rdbtnHuargen);
		raza.add(rdbtnEnano);
		raza.add(rdbtnOrco);
		raza.add(rdbtnNoMuerto);
		raza.add(rdbtnTauren);
		raza.add(rdbtnTroll);
		raza.add(rdbtnDracthyr);
		raza.add(rdbtnPandaAlianza);

		// Creación del buttongroup de clase
		clase = new ButtonGroup();
		// Se añaden los radiobutton al buttongroup de clase
		clase.add(btnGuerrero);
		clase.add(btnCazador);
		clase.add(rdbtnMago);
		clase.add(rdbtnPicaro);
		clase.add(rdbtnSacerdote);
		clase.add(rdbtnBrujo);
		clase.add(rdbtnPaladin);
		clase.add(rdbtnDruida);
		clase.add(rdbtnChaman);
		clase.add(rdbtnCaballeroMuerte);
		clase.add(rdbtnCazadorDemonios);
		clase.add(rdbtnEvocador);

	}

	/**
	 * Método que cambia la imagen
	 */
	public void cambiarImagenPersonaje(String rutaImagen) {
		imagenPersonaje = new ImageIcon(rutaImagen);
		personaje.setIcon(imagenPersonaje);

		personaje.revalidate();
		personaje.repaint();
	}
}
