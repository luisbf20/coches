package coches;

import javax.swing.*;
import java.awt.*;

public class PanelDificultad extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelDificultad(VentanaJuego ventana) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(0, 0, 0, 180));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelCentro.setMaximumSize(new Dimension(400, 400));

        panelCentro.add(crearBoton("Fácil", e -> ventana.iniciarJuego(1)));
        panelCentro.add(Box.createVerticalStrut(15));
        panelCentro.add(crearBoton("Medio", e -> ventana.iniciarJuego(2)));
        panelCentro.add(Box.createVerticalStrut(15));
        panelCentro.add(crearBoton("Difícil", e -> ventana.iniciarJuego(3)));

        add(panelCentro);
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);

        Dimension size = new Dimension(280, 60);
        boton.setPreferredSize(size);
        boton.setMaximumSize(size);
        boton.setMinimumSize(size);

        boton.addActionListener(accion);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);

        return boton;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        GradientPaint gp = new GradientPaint(0, 0, new Color(20, 20, 40), 0, getHeight(), new Color(0, 0, 0));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
}
