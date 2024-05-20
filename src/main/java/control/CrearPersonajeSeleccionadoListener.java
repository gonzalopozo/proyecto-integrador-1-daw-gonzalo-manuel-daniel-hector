package control;

import views.*;

import java.awt.event.*;

/**
 * Clase que implementa un ItemListener para cambiar la imagen del personaje
 * seleccionado.
 * Este ItemListener se utiliza para manejar el cambio de selección de raza o
 * sexo
 * en la interfaz de usuario de creación de personajes.
 */
public class CrearPersonajeSeleccionadoListener implements ItemListener {
    private CrearPersonaje crearPersonaje;

    /**
     * Constructor de la clase que inicializa la referencia a la vista de creación
     * de personaje.
     *
     * @param crearPersonaje La vista de creación de personaje.
     */
    public CrearPersonajeSeleccionadoListener(CrearPersonaje crearPersonaje) {
        this.crearPersonaje = crearPersonaje;
    }

    /**
     * Método que se ejecuta cuando se cambia la selección de raza o sexo.
     * Cambia la imagen del personaje seleccionado en la interfaz de usuario de
     * creación de personajes.
     *
     * @param e El evento de cambio de selección que desencadenó este método.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        // AccesoBD accesoBD = new AccesoBD();
        // Connection c = accesoBD.getConexion();

        // Array bidimensional con datos de las imágenes de los personajes, el primer
        // elemento de la fila indica la raza, el segundo el sexo, y el tercer elemento
        // es la ruta donde se encuentra la imagen
        String[][] imagenesPersonajes = {
                { "Humano", "Hombre", "src/main/resources/humanoGrande.png" },
                { "Humano", "Mujer", "src/main/resources/humanaGrande.png" },
                { "Enano", "Hombre", "src/main/resources/enanoGrande.png" },
                { "Enano", "Mujer", "src/main/resources/enanaGrande.png" },
                { "Elfo de la noche", "Hombre", "src/main/resources/elfo.png" },
                { "Elfo de la noche", "Mujer", "src/main/resources/elfa.png" },
                { "Huargen", "Hombre", "src/main/resources/huargenHombre.png" },
                { "Huargen", "Mujer", "src/main/resources/huargenMujer.png" },
                { "Dracthyr", "Hombre", "src/main/resources/dracthyrHombre.png" },
                { "Dracthyr", "Mujer", "src/main/resources/dracthyrMujer.png" },
                { "No muerto", "Hombre", "src/main/resources/nomuerto.png" },
                { "No muerto", "Mujer", "src/main/resources/nomuerta.png" },
                { "Orco", "Hombre", "src/main/resources/orcoHombre.png" },
                { "Orco", "Mujer", "src/main/resources/orcoMujer.png" },
                { "Pandaren", "Hombre", "src/main/resources/pandaHombre.png" },
                { "Pandaren", "Mujer", "src/main/resources/pandaMujer.png" },
                { "Tauren", "Hombre", "src/main/resources/taurenHombre.png" },
                { "Tauren", "Mujer", "src/main/resources/taurenMujer.png" },
                { "Troll", "Hombre", "src/main/resources/troll.png" },
                { "Troll", "Mujer", "src/main/resources/trollMujer.png" }
        };

        // Verifica si se selecciona un nuevo item o elemento
        if (e.getStateChange() == ItemEvent.SELECTED) {

            // Obtiene la raza y sexo seleccionado
            String raza = crearPersonaje.getSelectedButtonText(crearPersonaje.getRaza());
            String sexo = crearPersonaje.getSelectedButtonText(crearPersonaje.getSexo());

            // Este bucle for itera sobre los datos de las imágenes para encontrar la
            // correspondiente al personaje seleccionado
            for (String[] datosFotos : imagenesPersonajes) {
                // Comprueba si la raza y el sexo coinciden con la selección actual
                if (datosFotos[0].equals(raza) && datosFotos[1].equals(sexo)) {
                    // Si coincide actualiza la imagen del personaje con la ruta correspondiente
                    crearPersonaje.cambiarImagenPersonaje(datosFotos[2]);
                }
            }

        }

    }

}