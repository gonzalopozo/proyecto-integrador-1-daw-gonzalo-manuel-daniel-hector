package views;

import javax.swing.*;

public class DetallesPersonajesPartida extends VistaDefault {
    private JTable tablaDatos;
    private JScrollPane scrBarraHorizontal;

    public DetallesPersonajesPartida() {
        super();
        setSize(600, 400);
        inicializarComponentes();
        asignarLogo(imagenLogo);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        volver = new JButton("VOLVER");
        volver.setBounds(10, 327, 107, 23);
        getContentPane().add(volver);

        Object[][] datos = {};

        String[] nombresColumnas = {"Icono", "Nombre", "Raza", "Clase", "Nivel", "Salud", "Fuerza", "Destreza", "Sabiduría", "Carisma", "Inteligencia", "Constitución"};

        tablaDatos = new JTable(datos, nombresColumnas);
        scrBarraHorizontal = new JScrollPane(tablaDatos);
        scrBarraHorizontal.setBounds(10, 11, 564, 302);
        getContentPane().add(scrBarraHorizontal);
    }

}
