package ejercicios2p.Ejercicio1B;
import java.awt.*;
import javax.swing.*;

public class InterfaceCliente extends JFrame {

    public InterfaceCliente() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout());

        contPanel = new JPanel();
        imgFondo = new JLabel();
        btnAceptar = new JButton();

        contPanel.setLayout(null);

        imgFondo.setText("Hola Mundo");
        contPanel.add(imgFondo);
        imgFondo.setBounds(70, 30, 180, 128);

        btnAceptar.setText("Aceptar");
        contPanel.add(btnAceptar);
        btnAceptar.setBounds(170, 120, 120, 23);

        getContentPane().add(contPanel);

        // Personalizacion de la ventana
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        InterfaceCliente user = new InterfaceCliente();
    }

    // Variable
    JPanel contPanel;
    JLabel imgFondo;
    JButton btnAceptar;
    // End Variable

}