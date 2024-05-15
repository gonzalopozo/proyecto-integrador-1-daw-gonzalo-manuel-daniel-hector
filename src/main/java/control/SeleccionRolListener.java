package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;

import views.SeleccionRol;
import views.PaginaPrincipal;
import views.PaginaPrincipalGM;

public class SeleccionRolListener implements ActionListener {
    private SeleccionRol seleccionRol;
    private PaginaPrincipal paginaPrincipal;
    private PaginaPrincipalGM paginaPrincipalGM;

    

    /**
	 * @param seleccionRol
	 * @param paginaPrincipal
	 * @param paginaPrincipalGM
	 */
	public SeleccionRolListener(SeleccionRol seleccionRol, PaginaPrincipal paginaPrincipal, PaginaPrincipalGM paginaPrincipalGM) {
		this.seleccionRol = seleccionRol;
		this.paginaPrincipal = paginaPrincipal;
		this.paginaPrincipalGM = paginaPrincipalGM;
	}

	@Override
    public void actionPerformed(ActionEvent e){ 
        if (seleccionRol.getBtnGroupRoles().getSelection().equals(seleccionRol.getToggleBtnGameMaster().getModel())) {
			seleccionRol.dispose();
			paginaPrincipalGM.hacerVisible();
        } else if (seleccionRol.getBtnGroupRoles().isSelected((ButtonModel) seleccionRol.getToggleBtnJugador().getModel())) {
			seleccionRol.dispose();
			paginaPrincipal.hacerVisible();
        }    
    }
}