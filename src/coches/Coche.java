package coches;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Coche {

    private int x, y, ancho = 80, alto = 120;
    private int velocidad;
    private boolean izquierda, derecha, arriba, abajo;
    private Color color;
    private int xMinAutopista, xMaxAutopista;
    private Image imagen;

    public Coche(Color color, int x, int y, int velocidad, int xMinAutopista, int xMaxAutopista, String rutaimagen) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.xMinAutopista = xMinAutopista;
        this.xMaxAutopista = xMaxAutopista;
        
        ImageIcon icon = new ImageIcon(getClass().getResource(rutaimagen));
        this.imagen = icon.getImage().getScaledInstance(ancho,alto,Image.SCALE_SMOOTH);
    }

    public void mover() {
        if (izquierda) x -= velocidad;
        if (derecha) x += velocidad;
        if (arriba) y -= velocidad;
        if (abajo) y += velocidad;
        x = Math.max(xMinAutopista, Math.min(x, xMaxAutopista - ancho));
    }

    public void moverAbajo() {
        y += velocidad;
    }

    public void dibujar(Graphics g) {
    	if (imagen != null) {
            g.drawImage(imagen, x, y, null);
        } else {
            g.setColor(color);
            g.fillRect(x, y, ancho, alto);
        }
    }

    public boolean colisionaCon(Coche otro) {
        Rectangle r1 = new Rectangle(x, y, ancho, alto);
        Rectangle r2 = new Rectangle(otro.x, otro.y, otro.ancho, otro.alto);
        return r1.intersects(r2);
    }

    public void teclaPresionada(int tecla) {
        switch (tecla) {
            case KeyEvent.VK_LEFT -> izquierda = true;
            case KeyEvent.VK_RIGHT -> derecha = true;
            case KeyEvent.VK_UP -> arriba = true;
            case KeyEvent.VK_DOWN -> abajo = true;
        }
    }

    public void teclaSoltada(int tecla) {
        switch (tecla) {
            case KeyEvent.VK_LEFT -> izquierda = false;
            case KeyEvent.VK_RIGHT -> derecha = false;
            case KeyEvent.VK_UP -> arriba = false;
            case KeyEvent.VK_DOWN -> abajo = false;
        }
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
