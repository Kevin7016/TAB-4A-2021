package Venana;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {
public static void main( String args[] ) {
        
    Comandos formulario = new Comandos();
    formulario.setBounds(405,450,570,406);
    formulario.setLocationRelativeTo(null);
    formulario.setTitle("MINI BLOCK DE NOTAS");
    formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
    formulario.setVisible(true);
        
	}
}