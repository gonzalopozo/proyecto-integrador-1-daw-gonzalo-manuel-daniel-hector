package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import vistas.*;

public class App {
	
	private final static Color COLOR_BIANCA = new Color(249,247,238);
	private final static Color COLOR_LIGHTING_YELLOW = new Color(247,178,44);
	private final static Color COLOR_ALLPORTS = new Color(25, 69, 122);
	private final static Color COLOR_REGAL_BLUE = new Color(19, 27, 66);
	private final static Color COLOR_NERO = new Color(42, 42, 42);
	private final static Color COLOR_BLUE_LABEL = new Color(38, 102, 165);
	private final static Font LABEL_FONT_BOLD = new Font("Arial", Font.BOLD, 14);
	private final static Font LABEL_FONT = new Font("Arial", Font.PLAIN, 12);

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                try {
                    UIManager.setLookAndFeel(new FlatMacLightLaf());
                    UIManager.put("Component.focusColor", COLOR_LIGHTING_YELLOW);
                    UIManager.put("Button.arc", 20);
                    UIManager.put("RootPane.background", COLOR_BIANCA);
                    UIManager.put("TitlePane.foreground", COLOR_NERO);
                    UIManager.put("Panel.background", COLOR_ALLPORTS);
                    UIManager.put("Label.font", LABEL_FONT_BOLD);
                    UIManager.put("TextArea.font", LABEL_FONT);
                    UIManager.put("TextField.font", LABEL_FONT);
                    UIManager.put("Label.foreground", COLOR_LIGHTING_YELLOW);
                    UIManager.put("Button.foreground", COLOR_NERO);
                    UIManager.put("Button.font", LABEL_FONT_BOLD);
                    UIManager.put("Button.background", COLOR_LIGHTING_YELLOW);
                    UIManager.put("CheckBox.foreground", COLOR_LIGHTING_YELLOW);
                    UIManager.put("CheckBox.font", LABEL_FONT);
                    
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                  SeleccionarPartida iniciar = new SeleccionarPartida();
	              iniciar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	              iniciar.setTitle("Black Temple");
	              Toolkit miPantalla = Toolkit.getDefaultToolkit();
	              Image logoIcono = miPantalla.getImage("src/main/resources/logoIcono.png");
	              iniciar.setIconImage(logoIcono);
	              iniciar.setSize(1000,600);
		          iniciar.setLocationRelativeTo(null);
		          ImageIcon logo = new ImageIcon("src/main/resources/logoTitulo.png");
		          iniciar.asignarLogo(logo);
	              iniciar.hacerVisible();

	              
            }



        });

	}

}
