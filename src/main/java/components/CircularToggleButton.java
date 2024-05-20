package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Clase que define un botón circular que se puede alternar
public class CircularToggleButton extends JToggleButton {
    private Image image; // Imagen que se mostrará en el botón
    private Color hoverColor = new Color(247, 178, 44); // Color de fondo
    private Color borderColor = new Color(25, 69, 122); // Color del borde
    private int borderThickness = 2; // Grosor del borde
    public String atributo; // Atributo adicional que puede ser utilizado externamente

    // Constructor que recibe una imagen y un atributo
    public CircularToggleButton(Image image, String atributo) {
        // Asigna la imagen y atributo pasados como parámetros
        this.image = image;
        this.atributo = atributo;
        setContentAreaFilled(false); // Hace que el área de contenido sea transparente
        setBorderPainted(false); // Elimina el borde por defecto del botón
        setFocusPainted(false); // Elimina el efecto visual cuando el botón está enfocado

        // Agrega un oyente de mouse para manejar el efecto hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Si el botón está seleccionado, cambia el borde y el fondo al color hover
                if (isSelected()) {
                    setBorder(BorderFactory.createLineBorder(borderColor, borderThickness));
                    setBackground(hoverColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Si el botón está seleccionado, restaura el borde y el fondo cuando el mouse
                // sale
                if (isSelected()) {
                    // Si el botón está seleccionada, elimina el borde y restaura el color del fondo
                    setBorder(null);
                    setBackground(null);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Si el botón está seleccionado, pinta el fondo con el color hover
        if (isSelected()) {
            g.setColor(hoverColor);
            g.fillOval(0, 0, getWidth(), getHeight());
        } else {
            // Si no está seleccionado, pinta el fondo con el color de borde
            g.setColor(new Color(25, 69, 122));
            g.fillOval(borderThickness, borderThickness, getWidth() - 2 * borderThickness,
                    getHeight() - 2 * borderThickness);
        }

        // Pinta la imagen en el centro del botón si existe
        if (image != null) {
            int x = (getWidth() - image.getWidth(this)) / 2;
            int y = (getHeight() - image.getHeight(this)) / 2;
            g.drawImage(image, x, y, this);
        }
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Sobreescribe este método para evitar que se pinte el borde
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(80, 80); // Define el tamaño preferido del botón
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize(); // El tamaño mínimo es el mismo que el preferido
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize(); // El tamaño máximo es el mismo que el preferido
    }
}
