package ejercicios.ejercicio2;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaCListener extends Frame implements ActionListener  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
 
    public VentanaCListener() {
        this.init();
        this.setSize(400, 300);
        this.setVisible(true);
    }
    /**
     * Inicializamos los widgets y los metemos al contenedor
     */
    public void init() {
        array = new ArrayList<>();
        isClicked = false;
        btn_click = new Button("Aceptar");
        btn_clear = new Button("Limpiar");
        lbl_msg = new Label("Introduzca el Texto en el campo inferior de la ventana:");
        txt_in = new TextField("");
        txt_result = new TextArea();
        this.setLayout(new BorderLayout());
        this.add(lbl_msg, BorderLayout.NORTH);
        this.add(txt_in, BorderLayout.SOUTH);
        this.add(btn_click, BorderLayout.EAST);
        this.add(txt_result, BorderLayout.CENTER);
        this.add(btn_clear, BorderLayout.WEST);
        btn_click.addActionListener(this);
        btn_clear.addActionListener(this);
    }
    public static void main(String args[]) {
        VentanaCListener v = new VentanaCListener();
        v.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        /* if (isClicked)
        {
            btn_click.setLabel("Presioname!!!");
        }else{
            btn_click.setLabel("Presionado!!!");
        } */
        if (arg0.getSource() == btn_click) {
            String texto = txt_in.getText();
            if (texto.equals("SUMAR")) { 
                if (array.size() > 0) {
                    Integer i = 0;
                    for(Integer n: array) {
                        i = i + n;
                    }
                    texto = txt_in.getText() + (" " + i.toString());
                }
            } else {
                try{
                    Integer i = Integer.parseInt(texto);
                    array.add(i);
                    }catch(Exception e) {}
            }
            
            txt_result.append(texto + "\n");
        }
        if (arg0.getSource() == btn_clear) {
            txt_result.setText("");
            txt_in.setText("");
            array.clear();
        }
        isClicked = !isClicked;
    }
    /** 
     * Creación de los widgets
     */
    Button btn_click;
    Button btn_clear;
    TextField txt_in;
    Label lbl_msg;
    TextArea txt_result;
    ArrayList<Integer> array;
    boolean isClicked;

}