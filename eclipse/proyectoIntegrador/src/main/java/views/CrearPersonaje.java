package views;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.*;
import components.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class CrearPersonaje extends VistaDefault {

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

	public CrearPersonaje() {
		super();
		setSize(1000,600);
		inicializarComponentes();
		setLocationRelativeTo(null);
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
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
		ImageIcon imgAlianza = new ImageIcon("src/main/resources/AllianceLogo.png");
		logoAlianza.setIcon(imgAlianza);
		logoAlianza.setBounds(28, 10, 98, 98);
		getContentPane().add(logoAlianza);
		
		logoHorda = new JLabel();
		ImageIcon imgHorda = new ImageIcon("src/main/resources/logohorda.png");
		logoHorda.setIcon(imgHorda);
		logoHorda.setBounds(876, 22, 98, 98);
		getContentPane().add(logoHorda);
		ImageIcon imgHombre = new ImageIcon("src/main/resources/iconoHombre.png");
		ImageIcon imgMujer = new ImageIcon("src/main/resources/iconoMujer.png");
		
		
		File iconoHuman = new File("src/main/resources/humano.png"); // Ruta de tu imagen
        Image imageHuman = null;
		try {
			imageHuman = ImageIO.read(iconoHuman);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnHumano = new CircularToggleButton(imageHuman, "Humano");
		rdbtnHumano.setText("Humano");
		rdbtnHumano.setBounds(45, 135, 45, 45);
		getContentPane().add(rdbtnHumano);
		
		File iconoDwarf = new File("src/main/resources/enano.png"); // Ruta de tu imagen
        Image imageDwarf = null;
		try {
			imageDwarf = ImageIO.read(iconoDwarf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnEnano = new CircularToggleButton(imageDwarf, "Enano");
		rdbtnEnano.setText("Enano");
		rdbtnEnano.setBounds(45, 185, 44, 44);
		getContentPane().add(rdbtnEnano);
		
		File iconoNe = new File("src/main/resources/elfoNoche.png"); // Ruta de tu imagen
        Image imageNE = null;
		try {
			imageNE = ImageIO.read(iconoNe);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnElfoNoche = new CircularToggleButton(imageNE, "Elfo de la noche");
		rdbtnElfoNoche.setText("Elfo de la noche");
		rdbtnElfoNoche.setBounds(45, 235, 44, 44);
		getContentPane().add(rdbtnElfoNoche);
		
		File iconoHuargen = new File("src/main/resources/huargen.png"); // Ruta de tu imagen
        Image imageHuargen = null;
		try {
			imageHuargen = ImageIO.read(iconoHuargen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnHuargen = new CircularToggleButton(imageHuargen, "Huargen");
		rdbtnHuargen.setText("Huargen");
		rdbtnHuargen.setBounds(45, 285, 44, 44);
		getContentPane().add(rdbtnHuargen);
		
		File iconoPandaA = new File("src/main/resources/enano.png"); // Ruta de tu imagen
        Image imagePandaA = null;
		try {
			imagePandaA = ImageIO.read(iconoPandaA);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnPandaAlianza = new CircularToggleButton(imagePandaA, "Panda");
		rdbtnPandaAlianza.setText("Panda");
		rdbtnPandaAlianza.setBounds(45, 335, 44, 44);
		getContentPane().add(rdbtnPandaAlianza);
		
		File iconoOrco = new File("src/main/resources/orcoH.png"); // Ruta de tu imagen
        Image imageOrco = null;
		try {
			imageOrco = ImageIO.read(iconoOrco);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnOrco = new CircularToggleButton(imageOrco, "Orco");
		rdbtnOrco.setText("Orco");
		rdbtnOrco.setBounds(884, 135, 44, 44);
		getContentPane().add(rdbtnOrco);
		
		File iconoNoMuerto = new File("src/main/resources/nomuertoH.png"); // Ruta de tu imagen
        Image imageNoMuerto = null;
		try {
			imageNoMuerto = ImageIO.read(iconoNoMuerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnNoMuerto = new CircularToggleButton(imageNoMuerto, "No Muerto");
		rdbtnNoMuerto.setText("No muerto");
		rdbtnNoMuerto.setBounds(884, 185, 44, 44);
		getContentPane().add(rdbtnNoMuerto);
		
		File iconoTauren = new File("src/main/resources/taurenH.png"); // Ruta de tu imagen
        Image imageTauren = null;
		try {
			imageTauren = ImageIO.read(iconoTauren);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnTauren = new CircularToggleButton(imageTauren, "Tauren");
		rdbtnTauren.setText("Tauren");
		rdbtnTauren.setBounds(884, 235, 44, 44);
		getContentPane().add(rdbtnTauren);
		
		File iconoTroll = new File("src/main/resources/trollH.png"); // Ruta de tu imagen
        Image imageTroll = null;
		try {
			imageTroll = ImageIO.read(iconoTroll);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnTroll = new CircularToggleButton(imageTroll, "Troll");
		rdbtnTroll.setText("Troll");
		rdbtnTroll.setBounds(884, 285, 44, 44);
		getContentPane().add(rdbtnTroll);
		
		File iconoDracthyr = new File("src/main/resources/dracthyrr.png"); // Ruta de tu imagen
        Image imageDracthyr = null;
		try {
			imageDracthyr = ImageIO.read(iconoDracthyr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnDracthyr = new CircularToggleButton(imageDracthyr, "Dracthyr");
		rdbtnDracthyr.setText("Dracthyr");
		rdbtnDracthyr.setBounds(884, 335, 44, 44);
		getContentPane().add(rdbtnDracthyr);
		
		
		File iconoMujer = new File("src/main/resources/logoMujer.png"); // Ruta de tu imagen
        Image imageMujer = null;
		try {
			imageMujer = ImageIO.read(iconoMujer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rdbtnMujer = new CircularToggleButton(imageMujer,"Mujer");
		rdbtnMujer.setText("Mujer");
		rdbtnMujer.setBounds(494, 10, 44, 44);
		getContentPane().add(rdbtnMujer);
		
		
		File iconoHombre = new File("src/main/resources/logoHombre.png"); // Ruta de tu imagen
        Image imageHombre = null;
		try {
			imageHombre = ImageIO.read(iconoHombre);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rdbtnHombre = new CircularToggleButton(imageHombre, "Hombre");
		rdbtnHombre.setText("Hombre");
		rdbtnHombre.setBounds(440, 10, 44, 44);
		getContentPane().add(rdbtnHombre);
		
		
		
		File iconoGuerrero = new File("src/main/resources/guerrero.png"); // Ruta de tu imagen
        Image imageGuerrero = null;
		try {
			imageGuerrero = ImageIO.read(iconoGuerrero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnGuerrero = new CircularToggleButton(imageGuerrero, "Guerrero");
		btnGuerrero.setText("Guerrero");
		btnGuerrero.setBounds(159, 506, 44, 44);
		getContentPane().add(btnGuerrero);
		
		
		File iconoCazador = new File("src/main/resources/cazador.png"); // Ruta de tu imagen
        Image imageCazador = null;
		try {
			imageCazador = ImageIO.read(iconoCazador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnCazador = new CircularToggleButton(imageCazador, "Cazador");
		btnCazador.setText("Cazador");
		btnCazador.setBounds(211, 506, 44, 44);
		getContentPane().add(btnCazador);
		
		File iconoMago = new File("src/main/resources/mago.png"); // Ruta de tu imagen
        Image imageMago = null;
		try {
			imageMago = ImageIO.read(iconoMago);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnMago = new CircularToggleButton(imageMago, "Mago");
		rdbtnMago.setText("Mago");
		rdbtnMago.setBounds(263, 506, 44, 44);
		getContentPane().add(rdbtnMago);
		
		
		File iconoPicaro = new File("src/main/resources/picaro.png"); // Ruta de tu imagen
        Image imagePicaro = null;
		try {
			imagePicaro = ImageIO.read(iconoPicaro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnPicaro = new CircularToggleButton(imagePicaro, "Picaro");
		rdbtnPicaro.setText("Picaro");
		rdbtnPicaro.setBounds(315, 506, 44, 44);
		getContentPane().add(rdbtnPicaro);
		
		File iconoSacerdote = new File("src/main/resources/sacerdote.png"); // Ruta de tu imagen
        Image imageSacerdote = null;
		try {
			imageSacerdote = ImageIO.read(iconoSacerdote);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnSacerdote = new CircularToggleButton(imageSacerdote, "Sacerdote");
		rdbtnSacerdote.setText("Sacerdote");
		rdbtnSacerdote.setBounds(367, 506, 44, 44);
		getContentPane().add(rdbtnSacerdote);
		
		File iconoBrujo = new File("src/main/resources/brujo.png"); // Ruta de tu imagen
        Image imageBrujo = null;
		try {
			imageBrujo = ImageIO.read(iconoBrujo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnBrujo = new CircularToggleButton(imageBrujo, "Brujo");
		rdbtnBrujo.setText("Brujo");
		rdbtnBrujo.setBounds(419, 506, 44, 44);
		getContentPane().add(rdbtnBrujo);
		
		File iconoPaladin = new File("src/main/resources/paladin.png"); // Ruta de tu imagen
        Image imagePaladin = null;
		try {
			imagePaladin = ImageIO.read(iconoPaladin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnPaladin = new CircularToggleButton(imagePaladin, "Paladin");
		rdbtnPaladin.setText("Paladin");
		rdbtnPaladin.setBounds(471, 506, 44, 44);
		getContentPane().add(rdbtnPaladin);
		
		File iconoDruida = new File("src/main/resources/druida.png"); // Ruta de tu imagen
        Image imageDruida = null;
		try {
			imageDruida = ImageIO.read(iconoDruida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnDruida = new CircularToggleButton(imageDruida, "Druida");
		rdbtnDruida.setText("Druida");
		rdbtnDruida.setBounds(523, 506, 44, 44);
		getContentPane().add(rdbtnDruida);
		
		File iconoChaman = new File("src/main/resources/chaman.png"); // Ruta de tu imagen
        Image imageChaman = null;
		try {
			imageChaman = ImageIO.read(iconoChaman);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnChaman = new CircularToggleButton(imageChaman,"Chaman");
		rdbtnChaman.setText("Chaman");
		rdbtnChaman.setBounds(575, 506, 44, 44);
		getContentPane().add(rdbtnChaman);
		
		File iconoDK = new File("src/main/resources/caballeroMuerte.png"); // Ruta de tu imagen
        Image imageDK = null;
		try {
			imageDK = ImageIO.read(iconoDK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnCaballeroMuerte = new CircularToggleButton(imageDK, "Cabellero de la Muerte");
		rdbtnCaballeroMuerte.setText("Caballero de la muerte");
		rdbtnCaballeroMuerte.setBounds(627, 506, 44, 44);
		getContentPane().add(rdbtnCaballeroMuerte);
		
		File iconoDH = new File("src/main/resources/cazadorDemonios.png"); // Ruta de tu imagen
        Image imageDH = null;
		try {
			imageDH = ImageIO.read(iconoDH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnCazadorDemonios = new CircularToggleButton(imageDH, "Cazador de Demonios");
		rdbtnCazadorDemonios.setText("Cazador de demonios");
		rdbtnCazadorDemonios.setBounds(679, 506, 44, 44);
		getContentPane().add(rdbtnCazadorDemonios);
		
		
		File iconoEvocador = new File("src/main/resources/dracthyr.png"); // Ruta de tu imagen
        Image imageEvocador = null;
		try {
			imageEvocador = ImageIO.read(iconoEvocador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rdbtnEvocador = new CircularToggleButton(imageEvocador, "Evocador");
		rdbtnEvocador.setText("Evocador");
		rdbtnEvocador.setBounds(731, 506, 44, 44);
		getContentPane().add(rdbtnEvocador);
		
		personaje = new JLabel();
		personaje.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon orco = new ImageIcon("src/main/resources/enanoBailongo.gif");
		
		txtNombrePersonaje = new JTextField();
		txtNombrePersonaje.setBounds(426, 107, 132, 20);
		getContentPane().add(txtNombrePersonaje);
		txtNombrePersonaje.setColumns(10);
		personaje.setIcon(orco);
		personaje.setBounds(342, 151, 300, 300);
		getContentPane().add(personaje);
		
		JLabel lblNewLabel = new JLabel("Nombre Personaje");
		lblNewLabel.setBounds(427, 80, 140, 14);
		getContentPane().add(lblNewLabel);
		
		sexo = new ButtonGroup();
		sexo.add(rdbtnHombre);
		sexo.add(rdbtnMujer);
		
		raza = new ButtonGroup();
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
		
		clase = new ButtonGroup();
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
}
