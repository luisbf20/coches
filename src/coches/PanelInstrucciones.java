package coches;

import javax.swing.*;
import java.awt.*;

public class PanelInstrucciones extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelInstrucciones(VentanaJuego ventana) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelCentro.setMaximumSize(new Dimension(500, 400));
        
        

        JLabel titulo = new JLabel("CÓMO JUGAR");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        titulo.setForeground(Color.black);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(titulo);
        panelCentro.add(Box.createVerticalStrut(20));

        panelCentro.add(crearEtiqueta("- Usa las flechas ← ↑ → para mover el coche."));
        panelCentro.add(crearEtiqueta("- Esquiva los obstáculos para no perder."));
        panelCentro.add(crearEtiqueta("- Llega lo más lejos posible sin chocar."));
        panelCentro.add(crearEtiqueta("- Buena suerte"));

        panelCentro.add(Box.createVerticalStrut(30));

        JButton volver = new JButton("Volver al menú");
        volver.setFont(new Font("SansSerif", Font.PLAIN, 20));
        volver.setBackground(Color.black);
        volver.setForeground(Color.WHITE);
        volver.setFocusPainted(false);
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver.setPreferredSize(new Dimension(200, 40));
        volver.addActionListener(e -> ventana.mostrarMenu());

        panelCentro.add(volver);

        add(panelCentro);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        label.setForeground(Color.black);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
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
