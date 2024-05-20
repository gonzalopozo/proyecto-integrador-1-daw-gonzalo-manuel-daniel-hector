package control;

import java.awt.event.*;
import java.sql.*;

import model.AccesoBD;
import views.*;
import main.*;

/**
 * Clase que implementa ActionListener para subir el nivel de un personaje en la
 * vista JugandoGM
 */
public class SubirNivelGMListener implements ActionListener {

    private JugandoGM jugandoGMVista; // Vista JugandoGM

    /**
     * Constructor de la clase
     * 
     * @param jugandoGMVista Vista JugandoGM
     */
    public SubirNivelGMListener(JugandoGM jugandoGMVista) {
        this.jugandoGMVista = jugandoGMVista;
    }

    /**
     * Método que sube el nivel de un personaje en la vista JugandoGM
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        AccesoBD accesoBD = new AccesoBD(); // Acceso a la base de datos
        Connection c = accesoBD.getConexion(); // Conexión a la base de datos

        String nombrePersonajeSeleccionado = (String) jugandoGMVista.getPersonajesPartidaComboBox().getSelectedItem();

        System.out.println(nombrePersonajeSeleccionado);

        // Nombre del personaje seleccionado en el combobox

        int personajeId = 0; // Id del personaje seleccionado

        try {
            System.out.println(c);
            System.out.println(nombrePersonajeSeleccionado);
            System.out.println(App.getmiembroActualId());
            personajeId = accesoBD.devolverPersonajeId(c, nombrePersonajeSeleccionado,
                    App.getMiembroActualId()); // Id
            // del
            // personaje
            // seleccionado
            // en
            // el
            // combobox
            System.out.println(personajeId);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            accesoBD.subirNivelPersonaje(c, personajeId, SeleccionarPartidaGM.getPartidaSeleccionadaId()); // Subir
                                                                                                           // nivel del
                                                                                                           // personaje
                                                                                                           // seleccionado
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        int[][] datosSubidaNivel = null; // Datos de la subida de nivel del personaje seleccionado en el combobox

        try {
            datosSubidaNivel = accesoBD.subidaNivelPersonajeDatos(c, personajeId,
                    SeleccionarPartidaGM.getPartidaSeleccionadaId());
            // Datos de la subida de nivel del seleccionado en el combobox
            // Id de la partida seleccionada

        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        /**
         * Mensaje con las estadísticas de la subida de nivel del personaje seleccionado
         * en el combobox
         * 
         * @param estadisticasSubidaPersonaje Estadísticas de la subida de nivel del
         *                                    personaje seleccionado en el combobox
         * @param nombrePersonajeSeleccionado Nombre del personaje seleccionado en el
         *                                    combobox
         * @param datosSubidaNivel            Datos de la subida de nivel del personaje
         *                                    seleccionado en el combobox
         * @return Mensaje con las estadísticas de la subida de nivel del personaje
         *         seleccionado en el combobox
         */
        String estadisticasSubidaPersonaje = nombrePersonajeSeleccionado + " ha subido a nivel "
                + datosSubidaNivel[0][0] + "\n  - La salud aumentó " + (datosSubidaNivel[0][1] - datosSubidaNivel[1][1])
                + " puntos" + "\n  - La fuerza aumentó " + (datosSubidaNivel[0][2] - datosSubidaNivel[1][2]) + " puntos"
                + "\n  - La destreza aumentó " + (datosSubidaNivel[0][3] - datosSubidaNivel[1][3]) + " puntos"
                + "\n  - La sabiduria aumento " + (datosSubidaNivel[0][4] - datosSubidaNivel[1][4]) + " puntos"
                + "\n  - El carisma aumento " + (datosSubidaNivel[0][5] - datosSubidaNivel[1][5]) + " puntos"
                + "\n  - La inteligencia aumento " + (datosSubidaNivel[0][6] - datosSubidaNivel[1][6]) + " puntos"
                + "\n  - La constitucion aumento " + (datosSubidaNivel[0][7] - datosSubidaNivel[1][7]) + " puntos";

        jugandoGMVista.getOutputSubidaNivelTextArea().setText(estadisticasSubidaPersonaje); // Mostrar mensaje con las
                                                                                            // estadísticas de la subida
                                                                                            // de nivel del personaje
                                                                                            // seleccionado en el
                                                                                            // combobox

    }
}
