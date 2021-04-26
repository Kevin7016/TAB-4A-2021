package Practica2;

/**
 *
 * @author molin
 */
import java.awt.*;

public class Forma extends Canvas{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int x, y;
    private int w, h;
    private boolean isClicked;

    public Forma() {
        x = 250;
        y = 270;
        w = 300;
        h = 220;
        isClicked = false;
    }

    public void paint(Graphics g) {
        //Cuadrado
        g.setColor(Color.RED);
        g.fillRect(10, 100, 200, 300);
        g.setColor(Color.gray);
        g.drawRect(10,100,200,300);
        //Rombo/Rectangulo
        g.setColor(Color.white);
        g.drawArc(220,0, 100,0, 200, 300);
        g.setColor(Color.BLACK);
        g.drawRect(220, 100, 200, 300);
        
        //Círculo 
        g.setColor(Color.GRAY);
        g.drawArc(200, 0, 80, 80,0,360);
        g.setColor(Color.green);
        g.fillArc(200, 0, 80, 80,0,360);
        //Objeto arrastrable
        g.setColor(Color.GRAY);
        g.drawArc(x, y, 80, 80,0,360);
        g.setColor(Color.black);
        g.fillArc(x, y, 80, 80,0,360);
        //Texto
        g.drawString("Figura arrastrable\n"+"\na crecer con uso de mouse(W)",170,20);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = !this.isClicked;
    }
}
