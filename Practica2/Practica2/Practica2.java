package Practica2;

/**
 *
 * @author molin
 */
import java.awt.Frame;
import java.awt.event.*;

public class Practica2 extends Frame implements MouseListener, MouseMotionListener, KeyListener{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Forma zonaDeDibujo;

    public Practica2() {
        initComponents();
    }

    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        zonaDeDibujo = new Forma();
        zonaDeDibujo.addMouseListener(this);
        zonaDeDibujo.addMouseMotionListener(this);
        zonaDeDibujo.addKeyListener(this);
        this.addKeyListener(this);
        this.add(zonaDeDibujo);
        this.setSize(450,450);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Practica2 p = new Practica2();
    }
    private void collisionChek()
    {
        if(zonaDeDibujo.getX() <= 10)
        {
            zonaDeDibujo.setX(10);
        }
        if(zonaDeDibujo.getX() >= 130)
        {
            zonaDeDibujo.setX(130);
        }
        if(zonaDeDibujo.getY() <= 100)
        {
            zonaDeDibujo.setY(100);
        }
        if(zonaDeDibujo.getY() >= 430)
        {
            zonaDeDibujo.setY(430);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("Clicked");
        if (zonaDeDibujo.isClicked()) {
            zonaDeDibujo.setW(arg0.getX());
            zonaDeDibujo.setH(arg0.getY());
            zonaDeDibujo.repaint();
        } else {
            zonaDeDibujo.setX(250);
            zonaDeDibujo.setY(270);
        }
        zonaDeDibujo.setClicked();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Entrando");
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Saliendo");
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Presionado");
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Liberado");
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        if(!zonaDeDibujo.isClicked()) {
            zonaDeDibujo.setX(arg0.getX());
            zonaDeDibujo.setY(arg0.getY());
            collisionChek();
            zonaDeDibujo.repaint();
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        System.out.println("Mover");
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Presionando " + arg0.getKeyChar());
        if (!zonaDeDibujo.isClicked()) {
            switch(arg0.getKeyChar()) {
                case 'w':
                case 'W':
                     zonaDeDibujo.setW(6000);
                     zonaDeDibujo.setH(6000);
            }
            zonaDeDibujo.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Liberando " + arg0.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("Tecleada: " + arg0.getKeyChar());
    }
}

