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

import control.*;
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

    final static Login login = new Login();
	final static CrearCuenta crearCuenta = new CrearCuenta();
    final static CrearCuentaDos crearCuentaDos = new CrearCuentaDos();
    final static CuentaCreada cuentaCreada = new CuentaCreada();
    final static CrearPartida crearPartida = new CrearPartida();
    final static CrearPersonaje crearPersonaje = new CrearPersonaje();
    final static DetallesPersonajesCuenta detallesPersonajesCuenta = new DetallesPersonajesCuenta();
    final static DetallesPersonajesPartida detallesPersonajesPartida = new DetallesPersonajesPartida();
    final static PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    final static PaginaPrincipalGM paginaPrincipalGM = new PaginaPrincipalGM();
    final static SeleccionarPartida seleccionarPartida = new SeleccionarPartida();
    final static PartidasDisponibles partidasDisponibles = new PartidasDisponibles();
    final static SeleccionRol seleccionRol = new SeleccionRol();
    final static UnirsePartida unirsePartida = new UnirsePartida();
    final static SeleccionarPartidaGM seleccionarPartidaGM = new SeleccionarPartidaGM();

    static String miembroActual;
    static int miembroActualId;

    

    public static int getMiembroActualId() {
        return miembroActualId;
    }

    public static void setMiembroActualId(int miembroActualId) {
        App.miembroActualId = miembroActualId;
    }

    public static String getMiembroActual() {
        return miembroActual;
    }

    public static void setMiembroActual(String miembroActual) {
        App.miembroActual = miembroActual;
    }

    public static Login getLogin() {
        return login;
    }

    public static CrearCuenta getCrearcuenta() {
        return crearCuenta;
    }

    public static CrearCuentaDos getCrearcuentados() {
        return crearCuentaDos;
    }

    public static CuentaCreada getCuentacreada() {
        return cuentaCreada;
    }

    public static CrearPartida getCrearpartida() {
        return crearPartida;
    }

    public static CrearPersonaje getCrearpersonaje() {
        return crearPersonaje;
    }

    public static DetallesPersonajesCuenta getDetallespersonajescuenta() {
        return detallesPersonajesCuenta;
    }

    public static DetallesPersonajesPartida getDetallespersonajespartida() {
        return detallesPersonajesPartida;
    }

    public static PaginaPrincipal getPaginaprincipal() {
        return paginaPrincipal;
    }

    public static PaginaPrincipalGM getPaginaprincipalgm() {
        return paginaPrincipalGM;
    }

    public static SeleccionarPartida getSeleccionarpartida() {
        return seleccionarPartida;
    }

    public static PartidasDisponibles getPartidasdisponibles() {
        return partidasDisponibles;
    }

    public static SeleccionRol getSeleccionrol() {
        return seleccionRol;
    }

    public static UnirsePartida getUnirsepartida() {
        return unirsePartida;
    }

    public static SeleccionarPartidaGM getSeleccionarpartidagm() {
        return seleccionarPartidaGM;
    }

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

	            
                
                
                login.hacerVisible();

                //MoverseListener loginSeleccionRol = new MoverseListener(login, seleccionRol);
                //login.setListenerBotonContinuar(loginSeleccionRol);

                LoginListener loginCuenta = new LoginListener(login, seleccionRol);
                login.setListenerBotonContinuar(loginCuenta);

                SeleccionRolListener seleccionRolListener = new SeleccionRolListener(seleccionRol, paginaPrincipal, paginaPrincipalGM);
                seleccionRol.setListenerBotonContinuar(seleccionRolListener);
                
                DetallesPersonajesListener detallesPersonajesListener = new DetallesPersonajesListener(paginaPrincipal, detallesPersonajesCuenta);
                paginaPrincipal.setListenerBotonVerPartidas(detallesPersonajesListener);
                

                
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




                MoverseListener paginaPrincipalGMpartidasDisponibles = new MoverseListener(paginaPrincipalGM, partidasDisponibles);
                paginaPrincipalGM.setListenerBotonContinuar(paginaPrincipalGMpartidasDisponibles);

                MoverseListener PartidasDisponibles = new MoverseListener(partidasDisponibles, paginaPrincipalGM);
                partidasDisponibles.setListenerBotonVolver(PartidasDisponibles);


                MoverseListener PaginaPrincipalGMSeleccionRol = new MoverseListener(paginaPrincipalGM, seleccionRol);
                paginaPrincipalGM.setListenerBotonVolver(PaginaPrincipalGMSeleccionRol);


                MoverseListenerDos PaginaPrincipalGMCrearPartida = new MoverseListenerDos(paginaPrincipalGM, crearPartida);
                paginaPrincipalGM.setListenerBotonContinuarDos(PaginaPrincipalGMCrearPartida);


                MoverseListener CrearPartidaPaginaPrincipalGM = new MoverseListener(crearPartida, paginaPrincipalGM);
                crearPartida.setListenerBotonVolver(CrearPartidaPaginaPrincipalGM);

                MoverseListener jugadorCrearPersonaje = new MoverseListener(paginaPrincipal, crearPersonaje);
                paginaPrincipal.setListenerBotonCrearPersonaje(jugadorCrearPersonaje);

                MoverseListener paginaPrincipalSeleccionRol = new MoverseListener(paginaPrincipal, seleccionRol);
                paginaPrincipal.setListenerBotonVolver(paginaPrincipalSeleccionRol);

                //MoverseListener crearPersonajePaginaPrincipal = new MoverseListener(crearPersonaje, paginaPrincipal);
                CrearPersonajeListener crearPersonajePaginaPrincipal = new CrearPersonajeListener(crearPersonaje, paginaPrincipal);
                crearPersonaje.setListenerBotonContinuar(crearPersonajePaginaPrincipal);

                CrearPartidaListener crearPartidaPaginaPrincipalGM = new CrearPartidaListener(crearPartida, paginaPrincipalGM);
                crearPartida.setListenerBotonContinuar(crearPartidaPaginaPrincipalGM);


                // MoverseListener paginaPrincipalDetallesPersonajeCuenta = new MoverseListener (paginaPrincipal, detallesPersonajesCuenta);
                // paginaPrincipal.setListenerBotonVerPartidas(paginaPrincipalDetallesPersonajeCuenta);

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
