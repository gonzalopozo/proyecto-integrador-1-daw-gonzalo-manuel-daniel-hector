package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;

import views.SeleccionRol;
import views.PaginaPrincipal;
import views.PaginaPrincipalGM;

public class SeleccionRolListener implements ActionListener {
    private SeleccionRol vista;
    private PaginaPrincipal paginaPrincipal;
    private PaginaPrincipalGM paginaPrincipalGM;

    

    /**
	 * @param vista
	 * @param paginaPrincipal
	 * @param paginaPrincipalGM
	 */
	public SeleccionRolListener(SeleccionRol vista, PaginaPrincipal paginaPrincipal,
			PaginaPrincipalGM paginaPrincipalGM) {
		this.vista = vista;
		this.paginaPrincipal = paginaPrincipal;
		this.paginaPrincipalGM = paginaPrincipalGM;
	}



	@Override
    public void actionPerformed(ActionEvent e){ 
        
        
        if (vista.getBtnGroupRoles().isSelected((ButtonModel) vista.getToggleBtnGameMaster())){
        	paginaPrincipalGM.setVisible(true);
        } else if (vista.getBtnGroupRoles().isSelected((ButtonModel) vista.getToggleBtnJugador())) {
        	paginaPrincipal.setVisible(true);
        }    
    }
}