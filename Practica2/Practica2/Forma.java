package Practica2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author molin
 */
public class Forma extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int x, y;
    private int w, h;
    private String isFigura;
    boolean isClicked;

    public Forma() {
        x = y = 100;
        w = h = 100;
    }

    @Override
    public void paintComponent(Graphics u) {
        super.paintComponent(u);
        try {
            switch (isFigura) {
                case "Circulo":
                    u.setColor(Color.black);
                    u.fillOval(x, y, w, h);
                    u.drawString("Puedo Crecer", x, y);
                    break;
                case "Cuadrado":
                   u.setColor(Color.blue);
                   u.fillRect(80, 60, w, h);
                   u.setColor(Color.black);
                   u.fillOval(x, y, (int)(w * 0.30), (int)(h * 0.30));
                    break;
                case "Rombo":
                    if(this.isClicked){
                    u.setColor(Color.blue);
                    u.fillRect(x, y, w, h);
                    u.setColor(Color.pink);
                    u.fillOval(x, y, w, h);
                    u.setColor(Color.black);
                    u.fillArc(x, y, w, h, 60, 90);
                    }else{   
                    u.setColor(Color.blue);
                    u.fillRect(80,60, w, h);
                    u.setColor(Color.pink);
                    u.fillOval(x, y, w, h);
                    u.setColor(Color.black);
                    u.fillArc(x, 10, w, h, 60, 90);
                    }
                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        paintComponent(g);
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

    public Forma(LayoutManager layout) {
        super(layout);
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

    public String getIsFigura() {
        return isFigura;
    }

    public void setIsFigura(String isFigura) {
        this.isFigura = isFigura;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = !this.isClicked;
    }
}

