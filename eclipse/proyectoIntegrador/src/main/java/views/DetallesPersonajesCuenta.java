package views;

import javax.swing.*;

public class DetallesPersonajesCuenta extends VistaDefault {
    private JTable tablaDatos;
    private JScrollPane scrBarraHorizontal;

    public DetallesPersonajesCuenta() {
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

        Object[][] datos = {
            {"icono1", "Troll", "Pepe el del Madrid", "Druida", "La batalla por el templo del Tigre Blanco", 70, 50000, 10000, 1000, 1000, 3000, 1000, 450},
            {"icono2", "Tauren", "LeBron James", "Caballero de la muerte", "Liberación de los elfos", 50, 15000, 300, 10000, 1800, 800, 1750, 100},
            {"icono3", "Dracthyr", "D'Angelo Russell", "Evocador", "Lucha contra el Rey Exánime", 40, 20000, 7000, 5000, 10000, 5000, 3000, 500}
        };

        String[] nombresColumnas = {"Icono", "Nombre", "Raza", "Clase", "Partida", "Nivel", "Salud", "Fuerza", "Destreza", "Sabiduría", "Carisma", "Inteligencia", "Constitución"};

        tablaDatos = new JTable(datos, nombresColumnas);
        scrBarraHorizontal = new JScrollPane(tablaDatos);
        scrBarraHorizontal.setBounds(10, 11, 564, 302);
        getContentPane().add(scrBarraHorizontal);

    }
}
