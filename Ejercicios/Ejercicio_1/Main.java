package Ejercicios.Ejercicio_1;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {
/**
 * 
 */
    private static  final long serialVersionUID = 1L;
    public Main() {
        this .setSize(300,200);
        this.setVisible(true);
    }
    public static void main (String args []) {
        Main window = new Main ();
        window.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
