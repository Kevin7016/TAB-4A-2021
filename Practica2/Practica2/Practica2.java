package Practica2;

/**
 *
 * @author molin
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Practica2 extends JFrame {

   
    private static final long serialVersionUID = 1L;

    public Practica2() {
        componentesinit();
    }

    public void componentesinit() {

        this.setLayout(new BorderLayout());
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paintContainerKeyPressed(e);
            }
        });

        Circulo = new JButton("Circulo (a)");
        Circulo.setFocusable(false);
        Circulo.setFont(new Font("Arial", 10, 20));
        Circulo.addActionListener(e -> CirculoActionPerformed(e));
        
               
        Cuadrado = new JButton("Cuadrado (w)");
        Cuadrado.setFocusable(false);
        Cuadrado.setFont(new Font("Arial", 10, 20));
        Cuadrado.addActionListener(e -> CuadradoActionPerformed(e));

        Rombo = new JButton("Rombo (d)");
        Rombo.setFocusable(false);
        Rombo.setFont(new Font("Arial", 10, 20));
        Rombo.addActionListener(e -> RomboActionPerformed(e));

        

        Boton = new JPanel();
        Boton.setBackground(new Color(216, 241, 255));
        Boton.add(Circulo);
        Boton.add(Cuadrado);
        Boton.add(Rombo);

        
        contOpciones = new JPanel();
        contOpciones.setPreferredSize(new Dimension(90, 400));
        contOpciones.setBackground(new Color(216, 241, 255));
        
        

        zonaDeDibujo = new Forma();
        zonaDeDibujo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                paintContainerMouseClicked(e);
            }
        });
        zonaDeDibujo.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                paintContainerMouseDragged(e);
            }
        });
        zonaDeDibujo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paintContainerKeyPressed(e);
            }
        });

        this.add(Boton, BorderLayout.SOUTH);
        this.add(zonaDeDibujo, BorderLayout.CENTER);

        //  Ventana
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    
    public void reiniciar(){//metodo para reiniciar contador
        cont = 0;
        } 
    

    private void CirculoActionPerformed(ActionEvent e) {
        zonaDeDibujo.setIsFigura("Circulo");
        
    }
        
    private void CuadradoActionPerformed(ActionEvent e) {
        zonaDeDibujo.setIsFigura("Cuadrado");
        JOptionPane.showMessageDialog(null, "Cuadrado");
    }
    
    private void RomboActionPerformed(ActionEvent e) {
        zonaDeDibujo.setIsFigura("Rombo");
        JOptionPane.showMessageDialog(null, "Rombo");
    }

    private void paintContainerMouseClicked(MouseEvent e) {
        zonaDeDibujo.setClicked();
        zonaDeDibujo.repaint();
    }

    private void paintContainerMouseDragged(MouseEvent e) {
        if (!zonaDeDibujo.isClicked()) {
            zonaDeDibujo.setX(e.getX());
            zonaDeDibujo.setY(e.getY());
        }else{
            zonaDeDibujo.setW(e.getX());
            zonaDeDibujo.setH(e.getY());
            }
            zonaDeDibujo.repaint();
        }
    
    private void paintContainerKeyPressed(KeyEvent e) {
        if (!zonaDeDibujo.isClicked()) {
            switch (e.getKeyCode()) {
                case 'a':
                case 'A':
                    Circulo.doClick();
                    break;
                case 'w':
                case 'W':
                    Cuadrado.doClick();
                    break;
                case 'd':
                case 'D':
                    Rombo.doClick();
                    break;
                default:
                    break;
            }
        }
    }

    //Variables a usar
    JButton Circulo;
    JButton Cuadrado;
    JButton Rombo;
    JPanel  Boton;
    Forma zonaDeDibujo;
    JPanel contOpciones;
    int cont = 0;
}
