package views;

import javax.swing.*;
import components.*;

/**
 * clase que va a extender de la de vista default
 */
public class Jugando extends VistaDefault {

    // se definen todas las variables que se van a utilizar en la vista.
    private BackgroundPanel fondo;

    /**
     * Constructor de la vista, asignando los métodos necesarios.
     */
    public Jugando() {
        super();
        setSize(1280, 720);
        inicializarComponentes();
        asignarLogo(IMAGEN_LOGO);
        setLocationRelativeTo(null);
    }

    /**
     * Método el cual se va a encargar de inicializar todos los componentes que van
     * a aparecer en la vista.
     */
    public void inicializarComponentes() {

        // Se establece la imagen de fondo para la vista
        fondo = new BackgroundPanel("src/main/resources/fondoJugando.jpg");

        fondo.setLayout(null);

        this.setContentPane(fondo);

        // Creación del botón salir
        volver = new JButton("SALIR");
        volver.setBounds(20, 630, 200, 40);
        fondo.add(volver);

        // Creación del botón detalles niveles, que hará las funciones de continuar
        continuar = new JButton("DETALLES NIVELES");
        continuar.setBounds(1040, 630, 200, 40);
        fondo.add(continuar);

    }

}
