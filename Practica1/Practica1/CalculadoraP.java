package Practica1;

import java.awt.*;
import java.awt.event.*;

public class CalculadoraP extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TextField txt_in;//TextField en el que se ingresan y muestran los datos.
    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;//Se crean los botones  0-9
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button bsuma;
    private Button bresta;
    private Button bmulti;
    private Button b_div;
    private Button b_cuadrado;
    private Button b_igual;
    private Label lbl_c1;
    private Label lbl_c2;
    private Label lbl_c3;///Se crean los botones propios a las operaciones y al resultado de estas.
    private Label lbl_op;
    private Panel panel_c;
    private Panel panel_s;//Paneles para poner cada uno de los componentes.
    private int dat1;//Numero 1 ingresado.
    private int dat2;//Numero 2 ingresado.
    private String op;
    private Oper ope;
    
    public CalculadoraP(String nombre) {
        super(nombre);//Asignación de nombre.
        initComponents();//Inicialiación de los componentes.
    }
    //inicializa todos los componentes.
    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        ope = new Oper();
        panel_s = new Panel();
        panel_c = new Panel();
        panel_s.setLayout(new GridLayout());
        panel_c.setLayout(new GridLayout());//Layout 
        b0 = new Button ("0");//Se nombran los botones y se les añade un actionlister 
        b0.addActionListener(this);
        b1 = new Button ("1");
        b1.addActionListener(this);
        b2 = new Button ("2");
        b2.addActionListener(this);
        b3 = new Button ("3");
        b3.addActionListener(this);
        b4 = new Button ("4");
        b4.addActionListener(this);
        b5 = new Button ("5");
        b5.addActionListener(this);
        b6 = new Button ("6");
        b6.addActionListener(this);
        b7 = new Button ("7");
        b7.addActionListener(this);
        b8 = new Button ("8");
        b8.addActionListener(this);
        b9 = new Button ("9");
        b9.addActionListener(this);
        bsuma = new Button ("+");
        bsuma.addActionListener(this);
        bresta = new Button ("-");
        bresta.addActionListener(this);
        bmulti = new Button ("*");
        bmulti.addActionListener(this);
        b_div = new Button ("/");
        b_div.addActionListener(this);
        b_cuadrado = new Button ("^");
        b_cuadrado.addActionListener(this);
        b_igual = new Button ("=");
        b_igual.addActionListener(this);
        lbl_c1 = new Label ("C1");
        lbl_c2 = new Label ("C2");
        lbl_c3 = new Label ("C3");
        lbl_op = new Label ("Op");
        txt_in = new TextField();//Se crea el TextField.
        txt_in.setForeground(Color.GRAY);//Con las especificaciones de la práctica.
        txt_in.setText("000000000");
        panel_s.setLayout(new GridLayout(1,1));
        panel_s.add(txt_in, 0,0);
        panel_c.setLayout(new GridLayout(5,4));
        panel_c.add(lbl_c1);//Se añaden los label así como los botones al panel 
        panel_c.add(lbl_c2);
        panel_c.add(lbl_c3);
        panel_c.add(lbl_op);
        panel_c.add(b1);
        panel_c.add(b2);
        panel_c.add(b3);
        panel_c.add(bsuma);
        panel_c.add(b4);
        panel_c.add(b5);
        panel_c.add(b6);
        panel_c.add(bresta);
        panel_c.add(b7);
        panel_c.add(b8);
        panel_c.add(b9);
        panel_c.add(b_div);
        panel_c.add(bmulti);
        panel_c.add(b0);
        panel_c.add(b_cuadrado);
        panel_c.add(b_igual);
        this.setLayout(new BorderLayout());
        this.add(panel_s, BorderLayout.NORTH);
        this.add(panel_c, BorderLayout.CENTER);
        this.setSize(500,400);
        this.setResizable(false);
        this.setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getSource() == b0){
            txt_in.setText(txt_in.getText() + "0");
        }//Al presionar algún boton con un número se muestra lo que está en el TextField 
        if (arg0.getSource() == b1){
            txt_in.setText(txt_in.getText() + "1");
        }
        if (arg0.getSource() == b2){
            txt_in.setText(txt_in.getText() + "2");
        }
        if (arg0.getSource() == b3){
            txt_in.setText(txt_in.getText() + "3");
        }
        if (arg0.getSource() == b4){
            txt_in.setText(txt_in.getText() + "4");
        }
        if (arg0.getSource() == b5){
            txt_in.setText(txt_in.getText() + "5");
        }
        if (arg0.getSource() == b6){
            txt_in.setText(txt_in.getText() + "6");
        }
        if (arg0.getSource() == b7){
            txt_in.setText(txt_in.getText() + "7");
        }
        if (arg0.getSource() == b8){
            txt_in.setText(txt_in.getText() + "8");
        }
        if (arg0.getSource() == b9){
            txt_in.setText(txt_in.getText() + "9");
        }//Al presionar una operación se guarda el numero 
        if (arg0.getSource() == bsuma){
            String nose = txt_in.getText();
            if(isNumber(nose)){//Primero se hace una comprobación .
                dat1=Integer.parseInt(nose);
                op = "+";//Según la operación se define el operador.
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa  datos de maximo 20 digitos");
        }
        if (arg0.getSource() == bresta){
            String nose = txt_in.getText();
            if(isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "-";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
        if (arg0.getSource() == bmulti){
            String nose = txt_in.getText();
            if(isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "*";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa solo números o datos de maximo 20 digitos");
        }
        if (arg0.getSource() == b_div){
            String nose = txt_in.getText();
            if(isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "/";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa datos de maximo 20 digitos");
        }
        if (arg0.getSource() == b_cuadrado){
            String nose = txt_in.getText();
            if(isNumber(nose)){
                dat1=Integer.parseInt(nose);
                op = "^";
                txt_in.setText("");
            }
            else
            txt_in.setText("Por favor ingresa datos de maximo 20 digitos");
        }//Al presionar el igual, guarada el segundo número 
        if (arg0.getSource() == b_igual){
            String nose = txt_in.getText();
            if(isNumber(nose)){//Comprobación.
                dat2=Integer.parseInt(nose);
                txt_in.setText(ope.Ope(dat1, dat2, op));
            }
            else
            txt_in.setText("Por favor ingresa datos de maximo 20 digitos");
        }
    }
    
    public static boolean isNumber(String cadena) {

        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    public static void main(String args []){
        CalculadoraP F = new CalculadoraP("Calculadora GUI");
    }
    
}