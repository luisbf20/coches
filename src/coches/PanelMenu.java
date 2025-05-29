package coches;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelMenu(VentanaJuego ventana) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(0, 0, 0, 180));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelCentro.setMaximumSize(new Dimension(400, 400));

        JLabel titulo = new JLabel("CARRERA DE COCHES");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        titulo.setForeground(new Color(173, 216, 230));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(titulo);
        panelCentro.add(Box.createVerticalStrut(30));

        panelCentro.add(crearBoton("Iniciar Partida", e -> ventana.mostrarSeleccionDificultad()));
        panelCentro.add(Box.createVerticalStrut(15));
        panelCentro.add(crearBoton("Cómo Jugar", e -> ventana.mostrarInstrucciones()));
        panelCentro.add(Box.createVerticalStrut(15));
        panelCentro.add(crearBoton("Créditos", e -> ventana.mostrarCreditos()));
        panelCentro.add(Box.createVerticalStrut(15));
        panelCentro.add(crearBoton("Salir", e -> System.exit(0)));

        add(panelCentro);
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 24)); // fuente más grande
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension size = new Dimension(280, 60); // tamaño fijo más grande
        boton.setPreferredSize(size);
        boton.setMaximumSize(size);
        boton.setMinimumSize(size);

        boton.addActionListener(accion);
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
