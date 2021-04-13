package ejercicios.ejercicio4;
import java.awt.*;
import java.awt.event.*;

public class Menuv4p1 extends Frame implements ActionListener {
    private Label lbl_msg;
    private TextArea txt_out;
    private Button btn_clear;
    private TextField txt_ini;
    private Button btn_aceptar;
    private Panel panel_central;
    private Panel panel_superior;
    private Panel panel_inferior;

    public Menuv4p1() {
        initComponents();
    }

    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // panel_superior = new Panel();
        // panel_central = new Panel();
        // panel_inferior = new Panel();
        // panel_central.setLayout(new BorderLayout());
        // panel_superior.setLayout(new BorderLayout());
        // panel_inferior.setLayout(new BorderLayout());
        txt_ini = new TextField();
        btn_aceptar = new Button("Aceptar");
        btn_clear = new Button("Limpiar");
        txt_out = new TextArea();
        lbl_msg = new Label("Introduzca el texto :");
        btn_aceptar.addActionListener(this);
        btn_clear.addActionListener(this);
        this.setLayout(new GridLayout(3,3));
        this.add(lbl_msg, 0, 0);
        this.add(txt_ini, 0, 1);
        this.add(btn_aceptar, 0, 2);
        this.add(txt_out, 1,1);
        this.add(btn_clear,2,2);

        // panel_superior.add(btn_aceptar, BorderLayout.EAST);
        // panel_superior.add(txt_ini, BorderLayout.CENTER);
        // panel_superior.add(lbl_msg, BorderLayout.WEST);
        // panel_central.add(txt_out, BorderLayout.CENTER);
        // panel_inferior.add(btn_clear, BorderLayout.EAST);
        // this.add(panel_superior, BorderLayout.NORTH);
        // this.add(panel_inferior, BorderLayout.SOUTH);
        // this.add(panel_central, BorderLayout.CENTER);
        this.setSize(400,300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        
    }
    
    public static void main(String args[]){
        Menuv4p1 m = new Menuv4p1();
    }

}
