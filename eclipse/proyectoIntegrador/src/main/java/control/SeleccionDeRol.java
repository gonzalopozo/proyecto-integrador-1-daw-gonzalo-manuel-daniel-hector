package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionDeRol {
    private SeleccionRol seleccionRol;

    public SeleccionDeRol(SeleccionRol seleccionRol) {
        this.seleccionRol = seleccionRol;
        this.seleccionRol.getToggleBtnJugador().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            new PaginaPrincipal().setVisible(true);
            }
        });

        this.seleccionRol.getToggleBtnGameMaster().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PaginaPrincipalGM().setVisible(true);
            
            }
        });
    }
}