package coches;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PanelJuego extends JPanel implements ActionListener, KeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer temporizador;
    private VentanaJuego ventana;
    private Coche jugador;
    private ArrayList<Coche> enemigos;
    private int puntuacion;
    private boolean pausado = false;
    private int dificultad;

    private JButton botonPausa;
    private Random random = new Random();

    private int anchoPantalla;
    private int altoPantalla;
    private int anchoAutopista;
    private int xAutopista;

    public PanelJuego(VentanaJuego ventana, int dificultad) {
        this.ventana = ventana;
        this.dificultad = dificultad;

        setLayout(null);
        setFocusable(true);
        addKeyListener(this);

        anchoPantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
        altoPantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
        anchoAutopista = (int) (anchoPantalla * 0.6);
        xAutopista = (anchoPantalla - anchoAutopista) / 2;

        int carril = anchoAutopista / 4;

        int velocidadJugador = switch (dificultad) {
            case 1 -> 7;
            case 2 -> 9;
            case 3 -> 12;
            default -> 7;
        };
        jugador = new Coche(Color.BLUE, xAutopista + carril * 2, altoPantalla - 200, velocidadJugador, xAutopista, xAutopista + anchoAutopista, "/img/coche_bueno-removebg-preview.png");
        enemigos = new ArrayList<>();
        puntuacion = 0;

        botonPausa = new JButton("Pausa");
        botonPausa.setBounds(anchoPantalla - 120, 20, 100, 30);
        botonPausa.addActionListener(e -> {
            pausado = !pausado;
            if (pausado) {
                mostrarMenuPausa();
            } else {
                removeAll();
                add(botonPausa);
            }
        });
        add(botonPausa);

        temporizador = new Timer(30, this);
        temporizador.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!pausado) {
            jugador.mover();

            if (random.nextInt(24 - dificultad * 4) == 0) {
                int carril = anchoAutopista / 4;
                int posicionCarril = random.nextInt(4);
                int offsetX = random.nextBoolean() ? 10 : carril - 90;
                enemigos.add(new Coche(Color.RED, xAutopista + posicionCarril * carril + offsetX, -120, 3 + dificultad, xAutopista, xAutopista + anchoAutopista, "/img/coche_malo-removebg-preview.png"));
            }

            Iterator<Coche> it = enemigos.iterator();
            while (it.hasNext()) {
                Coche enemigo = it.next();
                enemigo.moverAbajo();

                if (enemigo.getY() > altoPantalla) {
                    it.remove();
                    puntuacion += 10;
                }

                if (jugador.colisionaCon(enemigo)) {
                    temporizador.stop();
                    JOptionPane.showMessageDialog(this, "¡Has perdido!\nPuntuación: " + puntuacion);
                    ventana.mostrarMenu();
                }
            }

            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(20, 100, 20));
        g.fillRect(0, 0, anchoPantalla, altoPantalla);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(xAutopista, 0, anchoAutopista, altoPantalla);

        g.setColor(Color.WHITE);
        int carril = anchoAutopista / 4;
        for (int i = 1; i < 4; i++) {
            int x = xAutopista + i * carril;
            for (int y = 0; y < altoPantalla; y += 40) {
                g.fillRect(x - 2, y, 4, 20);
            }
        }

        jugador.dibujar(g);
        for (Coche c : enemigos) {
            c.dibujar(g);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntos: " + puntuacion, 50, 70);
    }

    private void mostrarMenuPausa() {
        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(700, 300, 200, 50);
        botonContinuar.addActionListener(e -> {
            pausado = false;
            removeAll();
            add(botonPausa);
        });

        JButton botonSalir = new JButton("Abandonar");
        botonSalir.setBounds(700, 400, 200, 50);
        botonSalir.addActionListener(e -> {
            temporizador.stop();
            ventana.mostrarMenu();
        });

        removeAll();
        add(botonContinuar);
        add(botonSalir);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        jugador.teclaPresionada(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        jugador.teclaSoltada(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}