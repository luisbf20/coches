package coches;

import javax.swing.*;
import java.awt.*;

public class PanelCreditos extends JPanel {

    private static final long serialVersionUID = 1L;

    public PanelCreditos(VentanaJuego ventana) {
        setLayout(new GridBagLayout());
        setOpaque(false);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(0, 0, 0, 180)); // negro con transparencia
        panelCentro.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelCentro.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.setMaximumSize(new Dimension(500, 400));
        panelCentro.setPreferredSize(new Dimension(500, 400));
        panelCentro.setOpaque(true);

        JLabel titulo = new JLabel("CRÉDITOS");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setForeground(new Color(173, 216, 230)); // azul claro
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentro.add(titulo);
        panelCentro.add(Box.createVerticalStrut(20));

        panelCentro.add(crearEtiqueta("- Juego desarrollado por: Alicia, Yago, Luis "));
        panelCentro.add(crearEtiqueta(" y Hugo"));
        panelCentro.add(Box.createVerticalStrut(10));
        panelCentro.add(Box.createVerticalStrut(10));
        panelCentro.add(crearEtiqueta("- Año: 2025"));
        panelCentro.add(Box.createVerticalStrut(20));
        panelCentro.add(crearEtiqueta("¡Gracias por jugar!"));

        panelCentro.add(Box.createVerticalStrut(30));

        JButton volver = new JButton("Volver al menú");
        volver.setFont(new Font("SansSerif", Font.PLAIN, 20));
        volver.setBackground(new Color(100, 149, 237)); // azul acero claro
        volver.setForeground(Color.WHITE);
        volver.setFocusPainted(false);
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver.setPreferredSize(new Dimension(200, 40));
        volver.addActionListener(e -> ventana.mostrarMenu());

        panelCentro.add(volver);

        // Añadir el panel centrado
        add(panelCentro);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        label.setForeground(new Color(200, 220, 255)); // azul claro suave
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fondo degradado
        Graphics2D g2d = (Graphics2D) g.create();
        Color colorInicio = new Color(20, 20, 40);
        Color colorFinal = new Color(0, 0, 0);
        GradientPaint gp = new GradientPaint(0, 0, colorInicio, 0, getHeight(), colorFinal);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
}
