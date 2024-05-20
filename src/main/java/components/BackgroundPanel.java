/**
 * 
 */
package components;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;


import javax.swing.JPanel;

/**
 * 
 */
public class BackgroundPanel extends JPanel {

	private Image backgroundImage;

    // Constructor para cargar la imagen
    public BackgroundPanel(String fileName) {
        try {
            backgroundImage = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
	
}
