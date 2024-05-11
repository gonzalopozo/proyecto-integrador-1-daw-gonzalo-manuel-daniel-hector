package control;

public class ActualizarTablaVerPartidasListener implements ActionListener{

    private ActualizarTablaVerPartidasListener vista;
    private JTable tablaPartidas;
    private BaseDeDatos BaseDeDatos;


    public ActualizarTablaVerPartidasListener (ActualizarTablaVerPartidasListener vista, JTable tablaPartidas, BaseDeDatos BaseDeDatos){
        this.vista = vista;
        this.tablaPartidas = tablaPartidas;
        this.BaseDeDatos = BaseDeDatos;
    }

    @Override
    public void actionPerformed (ActionEvent e){
        
        // Estructura para actualizar la tabla cuando se presiona el botón Unirse
        int filaSeleccionada = tablaPartidas.getSelectedRow;
        //Se verifica si se ha seleccionado alguna fila
        if (filaSeleccionada !=1){
            // Se obtiene el id de la partida que ha seleccionado el usuario, siendo 0 el índice de la primera columna
            String nombrePartida = /*TODO: Puede que no sea un cast, sino un toString */(String) tablaPartidas.getValueAt(filaSeleccionada, 0);

            //Se obtiene el nombre del personaje que se inserta en la partida
            String nombrePersonaje = obtenerNombrePersonaje();

            boolean ingresoPersonajeAPartida = baseDeDatos.agregarPersonajeAPartida(nombrePersonaje, nombrePartida);

            if (ingresoPersonajeAPartida){
                JOptionPane.showMessageDialog(null, "Te has unido a la partida " + nombrePartida);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al unirse a la partida");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una partida");
        }
    }

    private String obtenerNombrePersonaje(){
        return "Nombre personaje";
    }
}