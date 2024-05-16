package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CircularToggleButton extends JToggleButton {
    private Image image;
    private Color hoverColor = new Color(247,178,44);
    private Color borderColor = new Color(25,69,122);
    private int borderThickness = 2; // Grosor del borde
    public String atributo;

    public CircularToggleButton(Image image, String atributo) {
        this.image = image;
        this.atributo = atributo;
        setContentAreaFilled(false); // Para que el botón sea transparente
        setBorderPainted(false); // Para eliminar el borde
        setFocusPainted(false); // Para eliminar el efecto de enfoque

        // Agrega un oyente para el efecto hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (isSelected()) {
                    setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
                    setBackground(hoverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (isSelected()) {
                    setBorder(null); // Restaura el borde
                    setBackground(null); // Restaura el color de fondo cuando el mouse sale
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Pintar el fondo
        if (isSelected()) {
            g.setColor(hoverColor);
            g.fillOval(0, 0, getWidth(), getHeight());
        } else {
            g.setColor(getBackground());
            g.fillOval(borderThickness, borderThickness, getWidth() - 2 * borderThickness, getHeight() - 2 * borderThickness);
        }

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
        return new Dimension(50, 50); // Tamaño predeterminado
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize(); // Mismo tamaño mínimo que preferido
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize(); // Mismo tamaño máximo que preferido
    }

}