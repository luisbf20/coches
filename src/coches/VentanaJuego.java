package coches;

import javax.swing.*;

public class VentanaJuego extends JFrame {

    public VentanaJuego() {
        setTitle("Juego de Coches");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mostrarMenu();

        setVisible(true);
    }

    public void mostrarMenu() {
        setContentPane(new PanelMenu(this));
        revalidate();
    }

    public void mostrarSeleccionDificultad() {
        setContentPane(new PanelDificultad(this));
        revalidate();
    }

    public void iniciarJuego(int dificultad) {
        PanelJuego panelJuego = new PanelJuego(this, dificultad);
        setContentPane(panelJuego);
        revalidate();
        repaint();
        panelJuego.requestFocusInWindow();
    }

	public void mostrarInstrucciones() {
		setContentPane(new PanelInstrucciones(this));
		revalidate();
	}

	public void mostrarCreditos() {
		setContentPane(new PanelCreditos(this));
		revalidate();
	}
}