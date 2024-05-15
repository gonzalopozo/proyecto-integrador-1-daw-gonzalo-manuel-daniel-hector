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

import control.LoginListener;
import control.MoverseListener;
import views.*;

public class App {
	
	private final static Color COLOR_BIANCA = new Color(249,247,238);
	private final static Color COLOR_LIGHTING_YELLOW = new Color(247,178,44);
	private final static Color COLOR_ALLPORTS = new Color(25,69,122);
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

	            
                Login login = new Login();
		        CrearCuenta crearCuenta = new CrearCuenta();
                CrearCuentaDos crearCuentaDos = new CrearCuentaDos();
                CuentaCreada cuentaCreada = new CuentaCreada();
                CrearPartida crearPartida = new CrearPartida();
                CrearPersonaje crearPersonaje = new CrearPersonaje();
                DetallesPersonajesCuenta detallesPersonajesCuenta = new DetallesPersonajesCuenta();
                DetallesPersonajesPartida detallesPersonajesPartida = new DetallesPersonajesPartida();
                PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
                PaginaPrincipalGM paginaPrincipalGM = new PaginaPrincipalGM();
                SeleccionarPartida seleccionarPartida = new SeleccionarPartida();
                PartidasDisponibles partidasDisponibles = new PartidasDisponibles();
                SeleccionRol seleccionRol = new SeleccionRol();
                UnirsePartida unirsePartida = new UnirsePartida();
                SeleccionarPartidaGM seleccionarPartidaGM = new SeleccionarPartidaGM();
                
                login.hacerVisible();

                MoverseListener loginSeleccionRol = new MoverseListener(login, seleccionRol);
                login.setListenerBotonContinuar(loginSeleccionRol);

                LoginListener loginCuenta = new LoginListener(login);
                login.setListenerBotonContinuar(loginCuenta);
                
                
                
                MoverseListener seleccionRolLogin = new MoverseListener(seleccionRol, login);
                seleccionRol.setListenerBotonVolver(seleccionRolLogin);

                MoverseListener loginCrearCuenta = new MoverseListener(login, crearCuenta);
                login.setListenerBotonCrearCuenta(loginCrearCuenta);

                MoverseListener crearCuentaCrearCuentaDos = new MoverseListener(crearCuenta, crearCuentaDos);
                crearCuenta.setListenerBotonContinuar(crearCuentaCrearCuentaDos);

                MoverseListener cuentaCreadaDos = new MoverseListener(crearCuentaDos, cuentaCreada);
                crearCuentaDos.setListenerBotonContinuar(cuentaCreadaDos);

                MoverseListener cuentaCreadaSeleccionRol = new MoverseListener(cuentaCreada, seleccionRol);
                cuentaCreada.setListenerBotonContinuar(cuentaCreadaSeleccionRol);

                MoverseListener rolJugador = new MoverseListener(seleccionRol, paginaPrincipal);
                seleccionRol.setListenerBotonContinuar(rolJugador);

                MoverseListener jugadorCrearPersonaje = new MoverseListener(paginaPrincipal, crearPersonaje);
                paginaPrincipal.setListenerBotonCrearPersonaje(jugadorCrearPersonaje);

                MoverseListener paginaPrincipalSeleccionRol = new MoverseListener(paginaPrincipal, seleccionRol);
                paginaPrincipal.setListenerBotonVolver(paginaPrincipalSeleccionRol);

                MoverseListener crearPersonajePaginaPrincipal = new MoverseListener(crearPersonaje, paginaPrincipal);
                crearPersonaje.setListenerBotonVolver(crearPersonajePaginaPrincipal);

                MoverseListener paginaPrincipalDetallesPersonajeCuenta = new MoverseListener (paginaPrincipal, detallesPersonajesCuenta);
                paginaPrincipal.setListenerBotonVerPartidas(paginaPrincipalDetallesPersonajeCuenta);

                MoverseListener detallesPersonajesCuentaPaginaPrincipal = new MoverseListener (detallesPersonajesCuenta, paginaPrincipal);
                detallesPersonajesCuenta.setListenerBotonVolver(detallesPersonajesCuentaPaginaPrincipal);

                MoverseListener paginaPrincipalUnirsePartida = new MoverseListener(paginaPrincipal, unirsePartida);
                paginaPrincipal.setListenerBotonJugar(paginaPrincipalUnirsePartida);

                MoverseListener unirsePartidaPaginaPrincipal = new MoverseListener(unirsePartida, paginaPrincipal);
                unirsePartida.setListenerBotonVolver(unirsePartidaPaginaPrincipal);
                
                MoverseListener unirsePartidaDetallesPersonajesPartida = new MoverseListener(unirsePartida, detallesPersonajesPartida);
                unirsePartida.setListenerBotonDetalles(unirsePartidaDetallesPersonajesPartida);
                
                MoverseListener detallesPersonajesPartidaUnirsePartida = new MoverseListener(detallesPersonajesPartida, unirsePartida);
                detallesPersonajesPartida.setListenerBotonVolver(detallesPersonajesPartidaUnirsePartida);
                
                MoverseListener crearCuentaLogin = new MoverseListener(crearCuenta, login);
                crearCuenta.setListenerBotonVolver(crearCuentaLogin);
                
                MoverseListener crearCuentaDosCrearCuenta = new MoverseListener(crearCuentaDos, crearCuenta);
                crearCuentaDos.setListenerBotonVolver(crearCuentaDosCrearCuenta);

                // MoverseListener cuentaCreadaDos = new MoverseListener(crearCuentaDos, cuentaCreada);
                // crearCuentaDos.setListenerBotonContinuar(cuentaCreadaDos);

                
            }



        });

	}

}
