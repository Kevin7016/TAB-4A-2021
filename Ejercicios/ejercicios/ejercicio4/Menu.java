package ejercicios.ejercicio4;

import java.awt.*;
import java.awt.event.*;

public class Menu extends Frame implements ActionListener {

    private Label lbl_msg;
    private TextArea txt_out;
    private Button btn_clear;
    private TextField txt_ini;
    private Button btn_aceptar;
    private Panel panel_central;
    private Panel panel_superior;
    private Panel panel_inferior;

    public Menu() {
        initComponents();
    }

    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_inferior = new Panel();
        panel_central.setLayout(new BorderLayout());
        panel_superior.setLayout(new BorderLayout());
        panel_inferior.setLayout(new BorderLayout());
        txt_ini = new TextField();
        btn_aceptar = new Button("Aceptar");
        btn_clear = new Button("Limpiar");
        txt_out = new TextArea();
        lbl_msg = new Label("Introduzca el texto :");
        btn_aceptar.addActionListener(this);
        btn_clear.addActionListener(this);
        this.setLayout(new BorderLayout());
        panel_superior.add(btn_aceptar, BorderLayout.EAST);
        panel_superior.add(txt_ini, BorderLayout.CENTER);
        panel_superior.add(lbl_msg, BorderLayout.WEST);
        panel_central.add(txt_out, BorderLayout.CENTER);
        panel_inferior.add(btn_clear, BorderLayout.EAST);
        this.add(panel_superior, BorderLayout.NORTH);
        this.add(panel_inferior, BorderLayout.SOUTH);
        this.add(panel_central, BorderLayout.CENTER);
        this.setSize(500,300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        
    }
    
    public static void main(String args[]){
        Menu m = new Menu();
    }
}
