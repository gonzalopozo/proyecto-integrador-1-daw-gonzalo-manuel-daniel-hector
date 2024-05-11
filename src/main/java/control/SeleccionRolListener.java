package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.SeleccionRol;
import views.PaginaPrincipal;
import views.PaginaPrincipalGM;

public class SeleccionRolListener implements ActionListener {
    private SeleccionRol vista;

    public SeleccionRolListener(SeleccionRol vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e){ 
        this.seleccionRol = seleccionRol;
        
        this.seleccionRol.getContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (seleccionRol.getToggleBtnJugador().isSelected()) {
                    new PaginaPrincipal().setVisible(true);
                } else if (seleccionRol.getToggleBtnGameMaster().isSelected()) {
                    new PaginaPrincipalGM().setVisible(true);
                }
            }
        });
    }
}