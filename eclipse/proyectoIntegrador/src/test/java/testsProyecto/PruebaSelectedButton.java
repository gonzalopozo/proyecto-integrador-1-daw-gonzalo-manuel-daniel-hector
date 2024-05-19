package testsProyecto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class PruebaSelectedButton {

	@Test
	public void testGeSelectedButtonText_SingleSelection() {
		
		// Se crean el buttonGroup y los JRadioButton para simular una selección
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton button1 = new JRadioButton();
		JRadioButton button2 = new JRadioButton();
		
		button1.setText("Boton1");
		button2.setText("Boton2");
		buttonGroup.add(button1);
		buttonGroup.add(button2);
		
	
		// Se simula que el botón 2 ha sido seleccionado
		button2.setSelected(true);
		
		//Ejecución del método que se quiere probar
		String selectedText = getSelectedButtonText(buttonGroup);
		
		//Se comprueba si el texto seleccionado es el esperado
		assertEquals("Boton2", selectedText);
	}
	
	@Test
	public void testGeSelectedButtonText_NoSelection() {
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		String selectedText = getSelectedButtonText(buttonGroup);
		
		assertNull(selectedText);
	}
	
	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
			
		}

		return null;
	}
}
