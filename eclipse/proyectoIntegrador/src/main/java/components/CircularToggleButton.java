package components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class CircularToggleButton extends JToggleButton {
    private Image image;

    public CircularToggleButton(Image image) {
        this.image = image;
        setContentAreaFilled(false); // Para que el botón sea transparente
        setBorderPainted(false); // Para eliminar el borde
        setFocusPainted(false); // Para eliminar el efecto de enfoque
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Pintar el fondo
        g.setColor(getBackground());
        g.fillOval(0, 0, getWidth(), getHeight());

        // Pintar la imagen en el centro del botón
        if (image != null) {
            int x = (getWidth() - image.getWidth(this)) / 2;
            int y = (getHeight() - image.getHeight(this)) / 2;
            g.drawImage(image, x, y, this);
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No hacer nada para evitar que se pinte el borde
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(44, 44); // Tamaño predeterminado
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize(); // Mismo tamaño mínimo que preferido
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize(); // Mismo tamaño máximo que preferido
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Circular Toggle Button");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            // Carga la imagen desde el archivo
            ImageIcon icon = new ImageIcon("path/to/your/image.png");
            Image image = icon.getImage();

            // Crea el botón circular
            CircularToggleButton circularButton = new CircularToggleButton(image);

            // Agrega el botón al marco
            frame.add(circularButton);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
